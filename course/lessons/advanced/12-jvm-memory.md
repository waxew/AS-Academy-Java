# فصل 12 — JVM و مدیریت حافظه

## هدف
درک مسیر اجرای کد Java و نقش Class Loader، Stack، Heap و Garbage Collector.

## مسیر اجرا
`Main.java → javac → Bytecode → JVM → Machine Code`

## Stack و Heap
Stack معمولاً فریم فراخوانی متدها و متغیرهای محلی را نگه می‌دارد. Objectها روی Heap قرار می‌گیرند و Garbage Collector اشیای غیرقابل‌دسترسی را بازیابی می‌کند.

```java
public class MemoryDemo {
    public static void main(String[] args) {
        // متغیر local در فریم متد main قرار دارد.
        int count = 10;

        // reference محلی است و شیء StringBuilder روی Heap قرار می‌گیرد.
        StringBuilder builder = new StringBuilder("Java");
        builder.append(" JVM");

        System.out.println(builder + " / " + count);
    }
}
```

## تمرین
تفاوت StackOverflowError و OutOfMemoryError را تحقیق کنید و برای هرکدام یک سناریوی آموزشی توضیح دهید.

## چک‌لیست
- Bytecode را می‌شناسم.
- تفاوت Stack و Heap را توضیح می‌دهم.
- نقش Garbage Collector را می‌دانم.
