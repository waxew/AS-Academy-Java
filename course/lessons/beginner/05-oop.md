# درس 05 — شی‌گرایی

## Product
```java
public class Product {
    // فیلدها private هستند تا Encapsulation رعایت شود.
    private final long id;
    private String name;
    private long price;

    public Product(long id, String name, long price) {
        this.id = id;
        this.name = name;
        setPrice(price);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }
}
```

## مفاهیم
Class، Object، Constructor، Encapsulation، Access Modifier، `this`, `static`, `final`.

## تمرین
کلاس `Customer` با شناسه، نام، شماره تماس و اعتبار ایجاد کنید.
