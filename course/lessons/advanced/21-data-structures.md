# ساختمان داده در Java

## مسیر
Array → Linked List → Stack → Queue → Hash Table → Tree → Heap → Graph.

## Stack
```java
Deque<String> history = new ArrayDeque<>();
history.push("lesson-1");
history.push("lesson-2");
System.out.println(history.pop());
```

## Queue
```java
Queue<String> jobs = new ArrayDeque<>();
jobs.offer("compile");
jobs.offer("test");
System.out.println(jobs.poll());
```

## تمرین
Undo/Redo ساده با دو Stack پیاده‌سازی کنید.
