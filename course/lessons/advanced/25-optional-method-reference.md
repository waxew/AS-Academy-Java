# Optional و Method Reference

```java
Optional<String> name = Optional.of("Java");
name.map(String::trim)
    .filter(value -> !value.isEmpty())
    .ifPresent(System.out::println);
```

Optional برای مدل‌کردن نبودن احتمالی مقدار مفید است؛ اما نباید جایگزین تمام nullها شود.

## تمرین
متدی بنویسید که Product را بر اساس id پیدا کند و `Optional<Product>` برگرداند.
