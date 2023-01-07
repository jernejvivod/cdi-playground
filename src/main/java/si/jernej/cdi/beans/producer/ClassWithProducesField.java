package si.jernej.cdi.beans.producer;

import jakarta.enterprise.inject.Produces;
import si.jernej.cdi.beans.producer.qualifier.B;

public class ClassWithProducesField
{
    // A producer field must be default-access, public, protected or private.
    @B
    private @Produces ClassForProduces classForProducesInstance = new ClassForProduces("This instance has been obtained from a producer field.");
}
