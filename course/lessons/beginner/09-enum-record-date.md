# Enum، Record و Date/Time

## Enum
```java
enum OrderStatus {
    NEW, PAID, SENT, DELIVERED
}
```

## Record
```java
public record Money(long amount, String currency) {
    public Money {
        if (amount < 0) throw new IllegalArgumentException("amount");
    }
}
```

## Date/Time
```java
LocalDate today = LocalDate.now();
LocalDate due = today.plusDays(7);
```

## تمرین
برای سیستم سفارش Status، مقدار پول و تاریخ سررسید طراحی کنید.
