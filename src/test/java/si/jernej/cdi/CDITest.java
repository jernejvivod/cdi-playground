package si.jernej.cdi;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.inject.Named;
import si.jernej.cdi.beans.Root;
import si.jernej.cdi.beans.examplebeanswithqualifiers.BeanA;
import si.jernej.cdi.beans.examplebeanswithqualifiers.BeanB;
import si.jernej.cdi.beans.examplebeanswithqualifiers.BeanC;
import si.jernej.cdi.beans.examplebeanswithqualifiers.qualifier.Q;
import si.jernej.cdi.beans.producer.ClassForProduces;

class CDITest
{
    private static SeContainer seContainer;

    @BeforeAll
    static void beforeAll()
    {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        try
        {
            seContainer = initializer.initialize();
        }
        catch (Exception e)
        {
            seContainer.close();
        }
    }

    @AfterAll
    static void afterAll()
    {
        seContainer.close();
    }

    @Test
    void testPostConstruct()
    {
        Root root = Main.getRoot(CDITest.seContainer);
        Assertions.assertEquals(7, root.getValueThatShouldBeSetInPostConstruct());
    }

    @Test
    void testProducerMethod()
    {
        Root root = Main.getRoot(CDITest.seContainer);
        Assertions.assertEquals("This instance has been obtained from a producer method.", root.getClassForProducesInstanceFromProducesMethod().message());
    }

    @Test
    void testProducerField()
    {
        Root root = Main.getRoot(CDITest.seContainer);
        Assertions.assertEquals("This instance has been obtained from a producer field.", root.getClassForProducesInstanceFromProducesField().message());
    }

    @Test
    void testQualifiers()
    {
        Root root = Main.getRoot(CDITest.seContainer);
        Set<Class<? extends Annotation>> beanAQualifiers = root.getBeanManager().getBeans(BeanA.class).iterator().next().getQualifiers().stream().map(Annotation::annotationType).collect(Collectors.toSet());
        Set<Class<? extends Annotation>> beanBQualifiers = root.getBeanManager().getBeans(BeanB.class).iterator().next().getQualifiers().stream().map(Annotation::annotationType).collect(Collectors.toSet());
        Set<Class<? extends Annotation>> beanCQualifiers = root.getBeanManager().getBeans(BeanC.class, BeanC.class.getAnnotations()[0]).iterator().next().getQualifiers().stream().map(Annotation::annotationType).collect(Collectors.toSet());


        Assertions.assertEquals(Set.of(Default.class, Any.class), beanAQualifiers);
        Assertions.assertEquals(Set.of(Default.class, Any.class, Named.class), beanBQualifiers);
        Assertions.assertEquals(Set.of(Any.class, Q.class), beanCQualifiers);
    }

    @Test
    void testGetInstancesUsingInstance()
    {
        Root root = Main.getRoot(CDITest.seContainer);
        List<ClassForProduces> res = root.getClassForProducesInstancesList();
        Assertions.assertEquals(2, res.size());
    }

    @Test
    void testBeanConstructor()
    {
       Root root = Main.getRoot(CDITest.seContainer);
       Assertions.assertEquals("set in bean constructor", root.getBeanClassWithBeanConstructor().getBeanSetInBeanConstructor().getMessage());
        Assertions.assertEquals("set in initializer method", root.getBeanClassWithBeanConstructor().getBeanSetInInitializerMethod().getMessage());
    }
}
