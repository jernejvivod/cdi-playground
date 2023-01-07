# Initializer Methods

An initializer method is a default-access, public, protected or private, non-abstract, non-static, non-generic method of a bean class or of any other classes
supporting injection.

A bean class may declare multiple (or zero) initializer methods.


An initializer method may be declared by annotating the method `@jakarta.inject.Inject`.

```
@ConversationScoped
public class Order
{
    private Product product;
    private User customer;

    @Inject
    void setProduct(@Selected Product product)
    {
        this.product = product;
    }

    @Inject
    public void setCustomer(User customer)
    {
        this.customer = customer;
    }
}
```

