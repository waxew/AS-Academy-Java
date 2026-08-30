# Concurrency و Multithreading در Java

## هدف
در پایان درس باید تفاوت Concurrency و Parallelism، مشکل Shared Mutable State و ابزار مناسب برای اجرای Taskهای هم‌زمان را تشخیص دهید.

## Thread و Task
به‌جای ساخت Thread برای هر کار، منطق Task را از سیاست اجرای آن جدا کنید.

```java
try (ExecutorService executor = Executors.newFixedThreadPool(4)) {
    executor.submit(() -> processOrder(101));
    executor.submit(() -> processOrder(102));
}
```

## Race Condition
عملیات `counter++` اتمیک نیست؛ Read، Increment و Write جداگانه دارد. چند Thread می‌توانند Update یکدیگر را از بین ببرند.

```java
AtomicInteger counter = new AtomicInteger();
counter.incrementAndGet();
```

Atomicها برای عملیات ساده مناسب‌اند؛ برای invariantهای چندمرحله‌ای ممکن است Lock لازم باشد.

## synchronized و Lock

```java
synchronized void withdraw(long amount) {
    if (balance < amount) throw new IllegalStateException("insufficient balance");
    balance -= amount;
}
```

Critical Section را تا حد ممکن کوچک نگه دارید. Lock طولانی Throughput را کاهش می‌دهد.

## Visibility و volatile
`volatile` Visibility بین Threadها را فراهم می‌کند اما مجموعه عملیات را Atomic نمی‌کند. بنابراین `volatile int counter` مشکل `counter++` را حل نمی‌کند.

## Deadlock
Deadlock زمانی رخ می‌دهد که Threadها منتظر Lockهای یکدیگر بمانند. راهکارها شامل Lock ordering ثابت، کاهش Nested Lock و استفاده کنترل‌شده از `tryLock` است.

## Concurrent Collections
برای Shared Collection از ابزارهایی مثل `ConcurrentHashMap` و Blocking Queueها استفاده کنید؛ نه اینکه بدون تحلیل یک `HashMap` عادی را بین Threadها Share کنید.

## CompletableFuture

```java
CompletableFuture<String> future = CompletableFuture
        .supplyAsync(() -> loadProfile())
        .thenApply(profile -> profile.toUpperCase())
        .exceptionally(error -> "fallback");

System.out.println(future.join());
```

برای Pipelineهای asynchronous مفید است، ولی chainهای بسیار پیچیده باید با مدیریت Timeout، Exception و Executor طراحی شوند.

## Virtual Threads
در Java 21، Virtual Thread برای workloadهای بسیار زیاد و عمدتاً blocking I/O مفید است.

```java
try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
    for (int i = 0; i < 10_000; i++) {
        executor.submit(() -> callRemoteService());
    }
}
```

Virtual Thread باعث سریع‌تر شدن CPU-bound algorithm نمی‌شود. هدف اصلی کاهش هزینه Thread-per-request برای عملیات blocking است.

## CPU-bound در برابر I/O-bound
- CPU-bound: تعداد Workerها معمولاً نزدیک تعداد Coreها نگه داشته می‌شود.
- I/O-bound: Concurrency بیشتر می‌تواند مفید باشد؛ Virtual Threads گزینه مهمی است.

## Thread Safety با Immutability
بهترین Shared State اغلب Shared State تغییرپذیر نیست. Immutable objectها و Message Passing می‌توانند نیاز به Lock را کاهش دهند.

## خطاهای رایج
- ساخت Thread نامحدود.
- Share کردن mutable collection بدون synchronization.
- استفاده از `sleep` برای هماهنگی Threadها.
- بلعیدن `InterruptedException`.
- فرض اینکه ConcurrentHashMap همه عملیات ترکیبی را خودکار atomic می‌کند.
- استفاده از parallel stream بدون Benchmark.

## تمرین
1. Race Condition یک Counter را ایجاد و با AtomicInteger اصلاح کنید.
2. Producer/Consumer را با BlockingQueue بسازید.
3. دو Future مستقل را با CompletableFuture ترکیب کنید.
4. یک Deadlock آزمایشی بسازید و با Lock ordering رفع کنید.
5. اجرای 1000 عملیات blocking را با Fixed Thread Pool و Virtual Threads مقایسه کنید.

## معیار تسلط
برای هر workload باید بتوانید مشخص کنید Shared State چیست، چه چیزی باید Atomic باشد، چه Executorی مناسب است و Failure/Timeout/Interruption چگونه مدیریت می‌شود.
