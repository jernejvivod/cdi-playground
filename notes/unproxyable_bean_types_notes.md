# Unproxyable Bean Types

The container uses proxies to provide certain functionality. Certain legal bean types cannot be proxied by the container:

- classes which do not have a non-private constructor with no parameters,
- classes which are declared final,
- classes which have non-static, final methods with public, protected or default visibility,
- primitive types,
- array types

A bean type must be proxyable if an injection point resolves to a bean:
- that requires a client proxy, or
- that has a bound interceptor

