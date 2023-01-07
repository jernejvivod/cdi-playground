package si.jernej.cdi.beans;

import jakarta.enterprise.context.Dependent;

@Dependent
public class ToBeInjected
{
    public int returnSeven()
    {
        return 7;
    }

}
