# درس 10 — Concurrency

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        // Thread Pool مدیریت Threadها را از منطق کسب‌وکار جدا می‌کند.
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            executor.submit(() -> System.out.println("Task A"));
            executor.submit(() -> System.out.println("Task B"));
        }
    }
}
```

## مباحث تکمیلی
Race Condition، Synchronization، Locks، Atomic Types، CompletableFuture و Virtual Threads.
