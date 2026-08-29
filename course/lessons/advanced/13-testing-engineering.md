# فصل 13 — Testing و مهندسی نرم‌افزار

## هدف
نوشتن کدی که قابل نگهداری، تست و توسعه باشد.

## اصول
- نام‌گذاری واضح
- Single Responsibility
- Dependency Inversion
- حذف تکرار
- تست رفتار به‌جای جزئیات پیاده‌سازی

```java
public final class DiscountCalculator {
    // منطق مستقل از UI و Database است؛ بنابراین تست آن ساده است.
    public long calculate(long price, int percent) {
        if (price < 0 || percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Invalid input");
        }
        return price - Math.round(price * percent / 100.0);
    }
}
```

## تمرین
برای متد بالا Test Caseهای قیمت صفر، تخفیف صفر، تخفیف صددرصد و ورودی نامعتبر طراحی کنید.

## موضوعات تکمیلی
JUnit، Mockito، Integration Test، Maven، Gradle، Clean Code، SOLID و Design Patterns.
