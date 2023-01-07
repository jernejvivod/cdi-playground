# Bean Names

A bean may have a bean name. A bean with a name may be referred to by its name when used in a non-typesafe environment (like the Unified Expression Language). A valid
bean name is a period-separated list of valid EL identifiers.

Bean names are used by the rules of bean name resolution defined in Name resolution.

## Declaring the Bean Name

To specify the name of a bean, the qualifier `@jakarta.inject.Named` is applied to the bean class or producer method or field. This bean is named `currentOrder`:

```
@Named("currentOrder")
public class Order { ... }
```

If `@Named` is not declared by the bean, nor by its stereotypes, a bean has no name.

