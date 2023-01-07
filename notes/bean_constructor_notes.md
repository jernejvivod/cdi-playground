# Bean Constructors

The bean constructor may be identified by annotating the constructor with `@Inject`.

```
@SessionScoped
public class ShoppingCart implements Serializable
{
    private User customer;

    @Inject
    public ShoppingCart(User customer)
    {
        this.customer = customer;
    }

    public ShoppingCart(ShoppingCart original)
    {
        this.customer = original.customer;
    }
    
    ShoppingCart()
    {
    }

...

}
```

If a bean class does not explicitly declare a constructor using `@Inject`, the constructor that accepts no parameters is the bean constructor.

A bean constructor may have any number of parameters. All parameters of a bean constructor are injection points.

