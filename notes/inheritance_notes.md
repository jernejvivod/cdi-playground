# Inheritance

A bean may inherit type-level metadata and members from its superclasses.

Inheritance of type-level metadata by beans from their superclasses is controlled via use of the Java `@Inherited` meta-annotation.
Type-level metadata is never inherited from interfaces implemented by a bean.


Member-level metadata is not inherited. However, injected fields, initializer methods, lifecycle callback methods and non-static observer methods are inherited by beans from their superclasses.

The implementation of a bean may be extended by the implementation of a second bean. This specification recognizes two distinct scenarios in which this situation occurs:

- The second bean specializes the first bean in certain deployment scenarios. In these deployments, the second bean completely replaces the first, fulfilling the same role in the system.

- The second bean is simply reusing the Java implementation, and otherwise bears no relation to the first bean.

## Inheritance of Type-level metadata

Suppose a class X is extended directly or indirectly by the bean class of a managed bean Y.


