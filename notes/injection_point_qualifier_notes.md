# Injection Point Qualifiers

## The Default Qualifier at Injection Points

If an injection point dclares no qualifier, the injection point has exactly one qualifier, the default qualifier `@Default`.


## The Qualifier `@Named` at Injection Points

The use of `@Named` as an injection point qualifier is not recommended, except in the case of integration with legacy code that uses string-based names to identify beans.

If an injected field declares a `@Named` annotation that does not specify the `value` member, the name of the field is assumed.

If any other injection point declares a `@Named` annotation that does not specify the `value` member, the container automatically detects the problem and treats it as a definition error.
