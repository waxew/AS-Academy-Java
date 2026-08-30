# Spring Boot از Bootstrap تا Production

## هدف
Spring Boot راه‌اندازی Spring application را استاندارد می‌کند، اما Auto Configuration جای فهم configuration را نمی‌گیرد.

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## Starter
Starter مجموعه dependencyهای سازگار برای یک capability است؛ مثل Web، Validation، Data JPA، Security و Actuator.

## Auto Configuration
Spring Boot بر اساس classpath، propertyها و Beanهای موجود configuration مناسب پیشنهاد می‌کند. اگر Bean سفارشی تعریف کنید، بسیاری از auto-configurationها back off می‌کنند.

## Externalized Configuration
Configuration محیطی را از source code جدا کنید.

```yaml
server:
  port: ${PORT:8080}

spring:
  datasource:
    url: ${DB_URL}
    username: ${DB_USER}
    password: ${DB_PASSWORD}
```

Secret واقعی نباید داخل repository commit شود.

## Profiles
Profile برای تفاوت محیط‌ها مفید است؛ مثلاً local/test/prod. از profile برای پنهان‌کردن معماری متفاوت استفاده نکنید.

## Configuration Properties
برای مجموعه propertyهای مرتبط، type-safe configuration بهتر از پراکندن `@Value` در ده‌ها کلاس است.

```java
@ConfigurationProperties(prefix = "academy.payment")
public record PaymentProperties(Duration timeout, int maxRetries) {}
```

## Validation
Configuration critical را در startup validate کنید تا application با secret یا URL ناقص بالا نیاید.

## Actuator
Actuator endpointهای operational مانند health و metrics فراهم می‌کند. همه endpointها نباید public باشند؛ exposure باید کنترل شود.

## Logging
از structured/contextual logging استفاده کنید و password، JWT، API key یا داده حساس را log نکنید. correlation/request ID برای trace کردن request مفید است.

## Graceful Shutdown
Application باید هنگام shutdown request جدید را کنترل و کارهای در حال اجرا را تا حد معقول تمام کند. این موضوع در container orchestration مهم است.

## Environment Parity
Test با H2 مفید است اما تفاوت آن با PostgreSQL می‌تواند bug پنهان کند. برای integration سطح بالاتر، Database واقعی containerized گزینه بهتری است.

## Startup Failure
Failure سریع و واضح بهتر از application نیمه‌فعال است. Missing configuration، migration failure و unavailable dependency باید diagnostic مناسب داشته باشند.

## تمرین
1. Student API را با Starterهای Web و Validation بسازید.
2. DB configuration را به environment variable منتقل کنید.
3. `@ConfigurationProperties` برای JWT یا Payment بسازید.
4. Health endpoint اضافه و exposure آن را محدود کنید.
5. Profile test و production را مقایسه کنید.

## پروژه کوچک
Academy Store را با configuration جدا برای local/test/prod، health check، structured logging و startup validation آماده کنید.

## معیار تسلط
دانشجو باید بداند application چرا با یک configuration خاص بالا آمده، configuration از کجا آمده و production concernهای startup/health/logging چگونه مدیریت می‌شوند.
