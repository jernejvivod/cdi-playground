package si.jernej.cdi;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import si.jernej.cdi.beans.Root;

public class Main
{
    public static Root getRoot(SeContainer container)
    {
        return container.select(Root.class).get();
    }

    public static void main(String[] args)
    {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();

        try (SeContainer container = initializer.initialize())
        {
            getRoot(container);
        }
    }
}
