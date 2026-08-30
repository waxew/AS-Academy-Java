# JVM، Bytecode و مدیریت حافظه

## هدف
در پایان این درس باید بتوانید مسیر اجرای برنامه Java، Memory Areaهای اصلی JVM، Class Loading، Garbage Collection و ابزارهای اولیه عیب‌یابی Runtime را توضیح دهید.

## مسیر اجرا
`Main.java → javac → .class Bytecode → Class Loader → JVM → JIT → Machine Code`

Java source مستقیماً توسط CPU اجرا نمی‌شود. Compiler آن را به Bytecode تبدیل می‌کند و JVM این Bytecode را اجرا و بخش‌های پرتکرار را با JIT به کد ماشین بهینه تبدیل می‌کند.

## Class Loader
Class Loading معمولاً در سه گام دیده می‌شود: Loading، Linking و Initialization. Class Loaderها بر اساس delegation model کار می‌کنند تا Core classها به‌طور امن و سازگار بارگذاری شوند.

## Stack
هر Thread Stack مستقل دارد. هر فراخوانی Method یک Stack Frame ایجاد می‌کند که اطلاعاتی مانند local variableها و operand stack را نگه می‌دارد.

```java
static int add(int a, int b) {
    int result = a + b;
    return result;
}
```

فراخوانی بازگشتی بسیار عمیق می‌تواند `StackOverflowError` ایجاد کند.

## Heap
Objectها معمولاً روی Heap قرار می‌گیرند و بین Threadها قابل اشتراک هستند. Garbage Collector اشیایی را که دیگر از GC Rootها قابل دسترسی نیستند بازیابی می‌کند.

```java
StringBuilder builder = new StringBuilder("Java");
builder.append(" JVM");
```

Reference محلی روی Stack Frame است، اما Object مربوطه روی Heap قرار دارد.

## Metaspace
Metadata کلاس‌ها در Metaspace نگهداری می‌شود. ClassLoader leak می‌تواند باعث رشد غیرعادی این بخش شود.

## Garbage Collection
GC بر Reachability کار می‌کند، نه بر اینکه یک Object "دیگر استفاده نمی‌شود" از نظر منطقی. تا وقتی reference زنده وجود دارد، Object ممکن است قابل جمع‌آوری نباشد.

مفاهیم مهم:
- Young/Old generation در Collectorهای generational.
- Minor/Major collection.
- Stop-the-world pause.
- Throughput در برابر latency.

Collectorهای مدرن JVM شامل G1 و ZGC هستند. انتخاب Collector باید بر اساس workload، latency target و heap size انجام شود.

## Memory Leak در Java
داشتن GC به معنی غیرممکن بودن Memory Leak نیست. اگر برنامه referenceهای غیرضروری را نگه دارد، GC نمی‌تواند آن Objectها را آزاد کند.

نمونه‌ها:
- Cache بدون limit.
- Listener ثبت‌شده و حذف‌نشده.
- Collection static که دائماً رشد می‌کند.
- ThreadLocal پاک‌نشده در Thread Pool.

## String Pool
String literalها می‌توانند در String Pool reuse شوند. به همین دلیل `==` برای مقایسه محتوای String درست نیست؛ از `equals()` استفاده کنید.

## JIT و Warm-up
Performance Java application ممکن است در شروع با حالت پایدار متفاوت باشد، چون JIT بر اساس profiling Runtime کد پرتکرار را optimize می‌کند. Benchmark ساده با `System.nanoTime()` برای microbenchmark قابل اعتماد نیست؛ ابزارهایی مانند JMH برای این کار طراحی شده‌اند.

## ابزارهای عیب‌یابی
- `jps`: دیدن JVM processها.
- `jstack`: Thread dump.
- `jcmd`: مجموعه فرمان‌های diagnostics.
- `jmap`: اطلاعات Heap در سناریوهای خاص.
- Java Flight Recorder / JFR: profiling و event recording.

## Heap Dump و Thread Dump
Heap dump برای تحلیل مصرف حافظه و retained objectها مفید است. Thread dump برای deadlock، blocked thread و CPU-related debugging کاربرد دارد.

## خطاهای مهم
- `OutOfMemoryError`: JVM نتوانسته حافظه لازم را تأمین کند؛ علت فقط "heap کوچک" نیست و باید root cause تحلیل شود.
- `StackOverflowError`: عمق بیش از حد Call Stack، معمولاً recursion یا cycle فراخوانی.

## تمرین
1. برنامه‌ای بنویسید که recursion عمیق ایجاد کند و علت StackOverflow را تحلیل کنید.
2. Cache بدون limit بسازید و توضیح دهید چرا GC حافظه را آزاد نمی‌کند.
3. با `jcmd` اطلاعات JVM یک برنامه در حال اجرا را ببینید.
4. تفاوت Heap Dump و Thread Dump را توضیح دهید.
5. سه workload فرضی تعریف کنید و درباره throughput/latency trade-off آن‌ها بحث کنید.

## معیار تسلط
اگر بتوانید مشکل Runtime را به ناحیه مناسب JVM، GC، Thread یا Class Loading محدود کنید و ابزار تشخیصی مناسب انتخاب کنید، این درس را در سطح کاربردی یاد گرفته‌اید.
