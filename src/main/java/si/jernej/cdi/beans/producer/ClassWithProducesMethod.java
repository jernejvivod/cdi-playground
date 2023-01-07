package si.jernej.cdi.beans.producer;

import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import si.jernej.cdi.beans.producer.qualifier.A;

public class ClassWithProducesMethod
{
    // TODO add injection point parameter
    @Produces
    @A
    public ClassForProduces getInstance()
    {
        return new ClassForProduces("This instance has been obtained from a producer method.");
    }

    public void close(@Disposes @A ClassForProduces classForProduces)
    {
        // called to run any disposal logic for the in run any disposal logic for the instance to be disposed of
    }
}
