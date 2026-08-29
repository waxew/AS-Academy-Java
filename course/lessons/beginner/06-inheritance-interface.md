# درس 06 — Inheritance، Polymorphism و Interface

```java
public interface PaymentMethod {
    // هر روش پرداخت باید این قرارداد را پیاده‌سازی کند.
    void pay(long amount);
}

class CashPayment implements PaymentMethod {
    @Override
    public void pay(long amount) {
        System.out.println("Cash payment: " + amount);
    }
}

class CardPayment implements PaymentMethod {
    @Override
    public void pay(long amount) {
        System.out.println("Card payment: " + amount);
    }
}
```

## نکته
کد سطح بالاتر می‌تواند با `PaymentMethod` کار کند و به نوع واقعی پرداخت وابسته نباشد. این پایه‌ای برای Polymorphism و Dependency Inversion است.
