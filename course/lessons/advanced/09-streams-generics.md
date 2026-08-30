# Generics، Lambda و Stream API

## Generics
Generics باعث Type Safety در Compile Time و حذف بسیاری از Castهای دستی می‌شود.

```java
static <T> T first(List<T> values) {
    if (values.isEmpty()) throw new IllegalArgumentException("empty list");
    return values.get(0);
}
```

## Bounds و PECS

```java
static double sum(List<? extends Number> values) {
    return values.stream().mapToDouble(Number::doubleValue).sum();
}
```

قاعده PECS: Producer Extends, Consumer Super. اگر Collection از T تولید می‌کند `? extends T` و اگر T دریافت می‌کند `? super T` را بررسی کنید.

## Type Erasure
بخش عمده اطلاعات Generic در Runtime پاک می‌شود. به همین دلیل `new T()` یا `instanceof List<String>` مستقیماً ممکن نیست.

## Lambda
Lambda پیاده‌سازی کوتاه Functional Interface است.

```java
Predicate<String> valid = value -> value != null && !value.isBlank();
Function<String, Integer> length = String::length;
```

Functional Interface فقط یک Abstract Method دارد؛ `Predicate`، `Function`، `Consumer` و `Supplier` ابزارهای استاندارد مهم‌اند.

## Stream Pipeline
Stream منبع داده را تغییر نمی‌دهد؛ Pipeline از Source، Intermediate Operations و Terminal Operation می‌سازد.

```java
int total = List.of(1, 2, 3, 4, 5, 6).stream()
        .filter(value -> value % 2 == 0)
        .map(value -> value * 2)
        .reduce(0, Integer::sum);
```

`filter` و `map` lazy هستند و تا Terminal Operation اجرا نمی‌شوند.

## map در برابر flatMap
`map` هر عنصر را به یک عنصر تبدیل می‌کند. `flatMap` ساختارهای تو در تو را Flatten می‌کند.

```java
List<String> tags = posts.stream()
        .flatMap(post -> post.tags().stream())
        .distinct()
        .toList();
```

## Collectors و Grouping

```java
Map<String, Long> countByCity = users.stream()
        .collect(Collectors.groupingBy(User::city, Collectors.counting()));
```

Grouping، Partitioning و downstream collectorها برای گزارش‌گیری بسیار مهم‌اند.

## Primitive Streams
برای محاسبات عددی از `IntStream`، `LongStream` و `DoubleStream` استفاده کنید تا Boxing غیرضروری کاهش یابد.

## Parallel Stream
`parallelStream()` به‌صورت خودکار برنامه را بهتر نمی‌کند. هزینه تقسیم کار، اندازه داده، نوع عملیات، ForkJoinPool مشترک و thread-safety باید Benchmark شوند.

## Side Effect
Pipeline ترجیحاً Stateless و بدون Side Effect باشد.

بد:
```java
List<String> result = new ArrayList<>();
users.stream().forEach(user -> result.add(user.name()));
```

بهتر:
```java
List<String> result = users.stream().map(User::name).toList();
```

## تمرین
1. یک Generic `Pair<K,V>` بسازید.
2. متدی با `? extends Number` برای Average بنویسید.
3. سفارش‌ها را بر اساس Customer با `groupingBy` گروه‌بندی کنید.
4. مجموع فروش هر Category را با Stream محاسبه کنید.
5. یک nested list را با `flatMap` Flatten کنید.
6. نسخه Loop و Stream یک گزارش را از نظر خوانایی و Performance مقایسه کنید.

## معیار تسلط
دانشجو باید Generic API ایمن طراحی کند، Wildcard را درست انتخاب کند و Stream را برای Transformation/Aggregation بدون Side Effect غیرضروری به‌کار ببرد.
