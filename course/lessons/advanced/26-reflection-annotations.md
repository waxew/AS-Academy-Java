# Reflection و Annotation در Java

## Annotation چیست؟
Annotation نوعی Metadata است که Compiler، Tool یا Framework می‌تواند آن را پردازش کند.

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Audited {
    String value() default "default";
}
```

## Retention
- SOURCE: بعد از Compile نگهداری نمی‌شود.
- CLASS: در bytecode هست ولی الزاماً Runtime قابل خواندن نیست.
- RUNTIME: Reflection در Runtime می‌تواند آن را بخواند.

## Target
با `@Target` مشخص می‌کنیم Annotation روی TYPE، METHOD، FIELD، PARAMETER و سایر Elementها قابل استفاده است.

## Reflection
Reflection اجازه می‌دهد ساختار Type را در Runtime بررسی کنیم.

```java
Class<?> type = OrderService.class;
System.out.println(type.getName());
Arrays.stream(type.getDeclaredMethods())
        .forEach(method -> System.out.println(method.getName()));
```

## خواندن Annotation

```java
if (type.isAnnotationPresent(Audited.class)) {
    Audited audited = type.getAnnotation(Audited.class);
    System.out.println(audited.value());
}
```

## Constructor و Method Invocation
Reflection می‌تواند Constructor یا Method را پیدا و اجرا کند، اما Exception handling و Access Control آن پیچیده‌تر از فراخوانی عادی است.

```java
Method method = type.getDeclaredMethod("calculate", long.class);
Object result = method.invoke(service, 100L);
```

## کاربردهای واقعی
Frameworkهایی مثل Spring، JUnit، Hibernate و Serialization libraries از Metadata، Reflection، Proxy و Code Generation برای wiring، test discovery، mapping و interception استفاده می‌کنند.

## Annotation Processing
همه پردازش Annotationها Runtime نیست. Annotation Processor می‌تواند در Compile Time کد یا metadata تولید کند و خطاها را زودتر تشخیص دهد.

## Proxy
Dynamic Proxy برای Interfaceها می‌تواند رفتارهایی مانند Logging، Metrics یا Security را اطراف Method Invocation اضافه کند. این مفهوم پایه‌ای برای درک AOP است.

## هزینه و محدودیت
Reflection می‌تواند خوانایی و Type Safety را کاهش دهد و refactoring را سخت‌تر کند. دسترسی عمیق به اعضای private نیز با Module System و محدودیت‌های جدید Java حساس‌تر شده است.

## چه زمانی Reflection نکنیم؟
اگر مسئله با Interface، Polymorphism، Factory یا Dependency Injection صریح حل می‌شود، Reflection معمولاً انتخاب اول نیست.

## تمرین
1. Annotation به نام `@Required` بسازید.
2. با Reflection تمام Fieldهای Annotated یک Object را بررسی کنید.
3. Validator ساده‌ای بسازید که null بودن Fieldهای Required را گزارش دهد.
4. تمام Methodهای یک Service را همراه Parameter Type چاپ کنید.
5. تفاوت Runtime Reflection و Compile-time Annotation Processing را توضیح دهید.

## پروژه کوچک
Mini Test Runner بسازید: Annotation سفارشی `@TestCase` تعریف کنید، Methodهای Annotated را کشف و اجرا کنید و نتیجه Pass/Fail را گزارش دهید.

## معیار تسلط
باید بدانید Reflection چه مشکلی را حل می‌کند، چه هزینه‌ای دارد و چرا Frameworkها از آن استفاده می‌کنند بدون اینکه Business Code را بی‌دلیل Reflection-heavy کنید.
