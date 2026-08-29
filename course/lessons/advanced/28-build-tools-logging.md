# Maven، Gradle و Logging حرفه‌ای

## هدف
دانشجو باید بتواند یک پروژه Java واقعی را Build، Test، Package و عیب‌یابی کند و به جای `System.out.println` از Logging ساخت‌یافته استفاده کند.

## Maven
چرخه رایج Maven شامل `validate`، `compile`، `test`، `package`، `verify` و `install` است. فایل `pom.xml` قرارداد Build پروژه را تعریف می‌کند.

```bash
mvn clean verify
```

نکته مهم: Dependency باید فقط زمانی اضافه شود که واقعاً مورد نیاز باشد. افزایش بی‌دلیل Dependencyها سطح حمله، زمان Build و پیچیدگی نگهداری را بالا می‌برد.

## Gradle
Gradle بر Task و Dependency Graph متکی است. در پروژه‌های Java معمولاً Taskهای `compileJava`، `test` و `build` را می‌بینیم.

```bash
./gradlew clean build
```

## Maven یا Gradle؟
Maven ساختار قراردادی و XML شفاف دارد. Gradle انعطاف بیشتر و DSL قدرتمندتری ارائه می‌دهد. هدف این درس انتخاب متعصبانه یک ابزار نیست؛ دانشجو باید بتواند Build Lifecycle هر دو را بخواند و خطاهای Dependency/Plugin را تحلیل کند.

## Logging
سطوح رایج: TRACE، DEBUG، INFO، WARN و ERROR.

```java
private static final Logger log = LoggerFactory.getLogger(OrderService.class);

public void createOrder(long orderId) {
    log.info("Creating order id={}", orderId);
}
```

هرگز Password، JWT، API Key، اطلاعات کارت یا Secret را Log نکنید.

## تمرین
1. یک Maven Project بسازید که `mvn verify` آن موفق شود.
2. همان پروژه را با Gradle بازسازی کنید.
3. Logging را اضافه و `System.out.println`ها را حذف کنید.
4. یک Dependency آسیب‌دیده فرضی را با Dependency Tree پیدا کنید.

## معیار قبولی
دانشجو باید تفاوت Build Tool، Dependency Manager، Test Lifecycle و Logging Framework را توضیح دهد و یک پروژه را از CLI بدون IDE Build کند.
