package si.jernej.cdi.beans.beanconstructor;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;

@Dependent
public class BeanClassWithBeanConstructorAndInitializerMethod
{
    public static class Bean
    {
        private String message;

        public String getMessage()
        {
            return message;
        }

        public void setMessage(String message)
        {
            this.message = message;
        }
    }


    // Alternative bean that can be activated either in beans.xml or by adding the `@Priority` annotation.
    @Alternative
    public static class AlternativeBean extends Bean
    {
        @Override
        public String getMessage()
        {
            return super.getMessage() + " (set in AlternativeBean)";
        }
    }

    private Bean beanSetInBeanConstructor;
    private Bean beanSetInInitializerMethod;

    @Inject
    public BeanClassWithBeanConstructorAndInitializerMethod(Bean beanSetInBeanConstructor)
    {
        beanSetInBeanConstructor.setMessage("set in bean constructor");
        this.beanSetInBeanConstructor = beanSetInBeanConstructor;
    }

    public Bean getBeanSetInBeanConstructor()
    {
        return beanSetInBeanConstructor;
    }

    public Bean getBeanSetInInitializerMethod()
    {
        return beanSetInInitializerMethod;
    }

    @Inject
    public void setBeanSetInInitializerMethod(Bean beanSetInInitializerMethod)
    {
        beanSetInInitializerMethod.setMessage("set in initializer method");
        this.beanSetInInitializerMethod = beanSetInInitializerMethod;
    }
}
