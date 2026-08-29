# Reflection و Annotation

## Annotation سفارشی
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Audited {}
```

## Reflection
```java
Class<?> type = MyService.class;
System.out.println(type.getSimpleName());
```

## کاربرد
Frameworkهایی مانند Spring برای کشف metadata و wiring از Reflection و Annotation استفاده می‌کنند.

## هشدار
استفاده بی‌رویه از Reflection خوانایی، ایمنی نوع و performance را کاهش می‌دهد.
