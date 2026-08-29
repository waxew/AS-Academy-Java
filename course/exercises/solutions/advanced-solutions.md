# راهنمای پاسخ تمرین‌های پیشرفته

## Stream Grouping
```java
Map<String, List<Product>> grouped = products.stream()
        .collect(Collectors.groupingBy(Product::category));
```

## CompletableFuture
```java
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "done");
System.out.println(future.join());
```

روی مدیریت خطا و Thread Pool مناسب نیز تمرکز کنید.
