# Producer Methods, Producer Fields, Disposer methods

## Producer Methods

A producer method acts as a source of objects to be injected, where:

- the objects to be injected are not required to be instances of beans, or
- the concrete type of the objects to be injected may vary at runtime, or
- the objects require some custom initialization that is not performed by the bean constructor

A producer method must be a default-access, public, protected or private, non-abstract method of a managed bean class. A producer method may be either static or non-static.

A bean may declare multiple producer methods.

A producer method may be declared by annotating a method with the `@jakarta.enterprise.inject.Produces` annotation.

A producer method may also specify scope, bean name, stereotypes and/or qualifiers.

A producer method may have any number of parameters. All producer method parameters are injection points.

## Producer Fields


## Disposer Methods



