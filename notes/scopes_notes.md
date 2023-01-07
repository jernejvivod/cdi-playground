# Scopes

Scoped objects exist in well-defined lifecycle context:
- They may be automatically created when needed and then automatically destroyed when the context in which they were created ends.
- Their state is automatically shared by clients that execute in the same context.

All beans have a scope. The scope of a bean determines the lifecycle of its instances, and which instances of the bean are visible to instances of other beans, as
defined in Scopes and Contexts. A scope type is represented by an annotation type.

For example, an object that represents the current user is represented by a session scoped object:

```
@Produces @SessionScoped User getCurrentUser() { ... }
```

An object that represents an order is represented by a conversation scoped object:

```
@ConversationScoped
public class Order { ... }
```


A list that contains the results of a search screen might be represented by a request scoped object:

```
@Produces @RequestScoped @Named("orders")
List<Order> getOrderSearchResults() { ... }
```

The set of scopes is extensible.

There are three standard scope types defined in CDI Lite, all defined in the package `jakarta.enterprise.context`.

- The container must provide an implementation of the `@RequestScoped` and `@ApplicationScoped` annotations defined in Context management for built-in scopes.

- There is a `@Dependent` pseudo-scope for dependent objects.


## Defining New Scope Types

A scope type is a Java annotation defined as `@Retention(RUNTIME)`. Typically a scope type is defined as `@Target({TYPE, METHOD, FIELD})`. All scope types must also specify the
`@jakarta.inject.Scope` or `@jakarta.enterprise.context.NormalScope` meta-annotation.


A scope type must not have any attributes.

For example, the following annotation declares a "business process scope":

```
@Inherited
@NormalScope
@Target({TYPE, METHOD, FIELD})
@Retention(RUNTIME)
public @interface BusinessProcessScoped {}
```

Custom scopes are nromally defined by extensions, which must also provide an implementation of the `Context` interface. Portable extensions provide a context object directly, while build compatible
extensions provide a class that the container has to instantiate to obtain the context object.

## Declaring the Bean Scope

The scope of a bean is defined by annotating the bean class or producer method or field with a scope type.

Alternatively, a scope type may be specified using a stereotype annotation.

## Default scope

When no scope is explicitly declared by annotating the bean class or producer method or field the scope of a bean is defaulted.

The default scope for a bean which does not explicitly declare a scope depends upon its declared stereotypes.

If the bean does not declare any stereotype with a declared default scope, the default scope for the bean is `@Dependent`.

## Default Bean Discovery Mode

The default bean discovery mode for a bean archive is `annotated`, and such a bean archive is said to be an implicit bean archive.

## Bean Defining Annotations

A bean class may have a bean defining annotation, allowing it to be placed anywhere in an application, as defined in Bean archives. A bean class with a bean defining annotation is
said to be an implicit bean.

The set of bean defining annotations contains:

- `@ApplicationScoped` and `@RequestScoped` annotations.
- all other normal scope types,
- `@Interceptor` annotation,
- all stereotype annotations (i.e. annotations annotated with `@Stereotype`),
- and the `@Dependent` scope annotation.


Note that to ensure compatibility with other Jakarta Dependency Injection implementations, all pseudo-scope annotations except `@Dependent` are not bean defining annotations.
However, a stereotype annotation including a pseudo-scope annotation is a bean defining annotation.

