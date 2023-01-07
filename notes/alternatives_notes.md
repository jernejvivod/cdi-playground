# Alternatives

An alternative is a bean that must be explicitly selected if it should be available for lookup, injection, or name resolution.

## Declaring an Alternative

An alternative may be declared by annotating the bean class or producer method or field with the `@Alternative` annotation.

Alternatively, an alternative may be declared by annotating a bean, producer method or producer field with a stereotype that declares an `@Alternative` annotation.

## Activating Alternative Beans

An alternative bean can be activated by adding the `<class>` element to the `beans.xml` file:
```
<alternatives>
  <class>com.example.AlternativeBean</class>
</alternatives>
```

An alternative bean can be activated by using the `@Priority` annotation and a priority value.

