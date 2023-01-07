package si.jernej.cdi.beans;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;
import si.jernej.cdi.beans.beanconstructor.BeanClassWithBeanConstructorAndInitializerMethod;
import si.jernej.cdi.beans.producer.ClassForProduces;
import si.jernej.cdi.beans.producer.qualifier.A;
import si.jernej.cdi.beans.producer.qualifier.B;

@ApplicationScoped
public class Root
{
    @Inject
    private BeanManager beanManager;

    // Inject CDI bean
    @Inject
    private ToBeInjected toBeInjected;

    // Inject instance where the producer is annotated with the @A qualifier (method producer in ClassWithProducesMethod).
    @Inject
    @A
    private ClassForProduces classForProducesInstanceFromProducesMethod;

    // Inject instance where the producer is annotated with the @B qualifier (field producer in ClassWithProducesField).
    @Inject
    @B
    private ClassForProduces classForProducesInstanceFromProducesField;

    @Inject
    @Any
    private Instance<ClassForProduces> classForProducesInstance;

    @Inject
    private BeanClassWithBeanConstructorAndInitializerMethod beanClassWithBeanConstructorAndInitializerMethod;

    private int valueThatShouldBeSetInPostConstruct;

    @PostConstruct
    private void postConstruct()
    {
        this.valueThatShouldBeSetInPostConstruct = toBeInjected.returnSeven();
    }

    public BeanManager getBeanManager()
    {
        return beanManager;
    }

    public int getValueThatShouldBeSetInPostConstruct()
    {
        return valueThatShouldBeSetInPostConstruct;
    }

    public ClassForProduces getClassForProducesInstanceFromProducesMethod()
    {
        return classForProducesInstanceFromProducesMethod;
    }

    public ClassForProduces getClassForProducesInstanceFromProducesField()
    {
        return classForProducesInstanceFromProducesField;
    }

    public List<ClassForProduces> getClassForProducesInstancesList()
    {
        return this.classForProducesInstance.stream().toList();
    }

    public BeanClassWithBeanConstructorAndInitializerMethod getBeanClassWithBeanConstructor()
    {
        return beanClassWithBeanConstructorAndInitializerMethod;
    }
}
