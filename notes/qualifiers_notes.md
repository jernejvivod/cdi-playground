# Qualifiers

A qualifier type represents some client-visible semantic associated with a type that is satisfied by some implementations of the type (and not by others). For example, we could introduce qualifier types representing synchronicity and asynchronicity. In Java code, qualifier types are represented by
annotations.

```
@Synchronous
class SynchronousPaymentProcessor implements PaymentProcessor
{
    ...
}

@Asynchronous
class AsynchronousPaymentProcessor implements PaymentProcessor
{
    ...
}
```

Qualifier types are applied to injection points to distinguish which implementation is required by the client. For example, when the container
encounters the following injected field, an instance of `SynchronousPaymentProcessor` will be injected:

```
@Inject
@Synchronous
private PaymentProcessor paymentProcessor;
```

An injection point may specify multiple qualifiers.


## Built-in Qualifier Types

Three standard qualifier types are defined in the package `jakarta.enterprise.inject`. In addition, the built-in qualifier type @Named is defined
by the package `jakarta.inject`.

Every bean has the built-in qualifier `@Any`, even if it does not explicitly declare this qualifier.

If a bean does not explicitly declare a qualifier other than `@Named` or `@Any`, the bean has exactly one additional qualifier, of type `@Default`.
This is called the default qualifier.

The following declaration results in a bean with three qualifiers: `@Any`, `@Default` and `@Named("ord")`.

The default qualifier is also assumed for any injection point that does not explicitly declare a qualifier, as defined in the default qualifier
at injection points.

A qualifier type is a Java annotation defined as `@Retention(RUNTIME)`. It is also typically defined as `@Target({METHOD, FIELD, PARAMETER, TYPE})`.

Example:

```
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface Synchronous {}
```

A bean may only be injected to an injection point if it has all the qualifiers of the injection point.

Qualifier types may be applied to parameters of producer methods, initializer methods, disposer methods, observer methods or bean constructors to
determine the bean instance that is passed when the method is called by the container.

