# درس 02 — متغیرها و انواع داده

## هدف
شناخت Primitive Typeها، String، ثابت‌ها و تبدیل نوع.

```java
public class VariablesDemo {
    public static void main(String[] args) {
        // عدد صحیح برای سن.
        int age = 25;

        // long برای اعداد بزرگ‌تر استفاده می‌شود.
        long population = 8_000_000_000L;

        // double برای اعداد اعشاری با دقت عمومی مناسب است.
        double price = 125_500.75;

        // boolean فقط true یا false می‌گیرد.
        boolean active = true;

        // String یک Reference Type است.
        String name = "AS Academy";

        // final مقدار را پس از مقداردهی غیرقابل تغییر می‌کند.
        final double TAX_RATE = 0.10;

        System.out.println(name + " / " + age + " / " + active);
        System.out.println(population);
        System.out.println(price * (1 + TAX_RATE));
    }
}
```

## نکات
`byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean` انواع Primitive هستند. `String` شیء است.

## تمرین
برای یک محصول نام، قیمت، تعداد، موجود بودن و کد محصول تعریف کنید و مبلغ کل را محاسبه کنید.
