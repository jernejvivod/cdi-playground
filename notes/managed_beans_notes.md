# Managed Beans

A managed bean is a bean that is implemented by a Java class. This class
is called the bean class of the managed bean.

If a managed bean has a non-static public field, it must have scope @Dependent. If a managed bean with a non-static public field declares any
scope other than @Dependent, the container automatically detects the problem.

If the managed bean class is a generic type, it must have scope @Dependent. If a managed bean with a parameterized bean class declares any scope
other than @Dependent, the container automatically detects the problem and treats it as a definition error.

A Java class is a managed bean if it meets all of the following conditions:
- It is not an inner class.
- It is a non-abstract class.
- It does not implement `jakarta.enterprise.inject.spi.Extensions`.
- It is not annotated `@Vetoed` or in a package annotated `@Vetoed`.
- It has an appropriate constructor - either:
  - the class has a constructor with no parameters, or
  - the class declares a constructor annotated @Inject.

In CDI Full environment, a Java class is a managed bean also if:
  - It is an abstract or non-abstract class annotated `@Decorator`.

The unrestricted set of bean types for a managed bean contains the bean class, every superclass and all interfaces it implements directly or indirectly.

The default name for a managed bean is the unqualified class name of the bean class, after converting the first character to lower case. For example,
if the bean class is named `ProductList`, the default bean name is `productList`.

