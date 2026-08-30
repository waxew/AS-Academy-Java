# Spring Core، Dependency Injection و معماری

## هدف
این درس توضیح می‌دهد Spring چه مشکلی را حل می‌کند، IoC Container چگونه Objectها را مدیریت می‌کند و چرا معماری لایه‌ای فقط نام‌گذاری Packageها نیست.

## IoC و Dependency Injection
در طراحی معمولی یک کلاس dependencyهای خود را می‌سازد. در Dependency Injection، dependency از بیرون وارد می‌شود.

```java
@Service
public class CheckoutService {
    private final PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}
```

Constructor Injection dependency را صریح، immutable و testable می‌کند.

## Bean
Objectی که توسط Spring Container ساخته و مدیریت می‌شود Bean است. Beanها می‌توانند با annotationهایی مثل `@Component`, `@Service`, `@Repository`, `@Controller` یا با `@Bean` تعریف شوند.

## Component Scanning
`@SpringBootApplication` به‌صورت ترکیبی configuration و component scanning را فعال می‌کند. Package structure مهم است؛ کلاس main معمولاً در package ریشه قرار می‌گیرد.

## Bean Lifecycle
Container Bean را می‌سازد، dependencyها را inject می‌کند و lifecycle callbackها را مدیریت می‌کند. ساخت resourceهای خارجی در constructor معمولاً ایده خوبی نیست؛ lifecycle و failure باید کنترل شوند.

## Scope
Scope پیش‌فرض Spring Beanها singleton است. singleton به معنی thread-safe بودن خودکار نیست. اگر mutable state داخل Service singleton نگه دارید، هم‌زمانی می‌تواند مشکل ایجاد کند.

## معماری درخواست

```text
HTTP Request
   ↓
Controller / Web Adapter
   ↓
Application Service / Use Case
   ↓
Domain Model
   ↓
Repository Port
   ↓
Persistence Adapter / Database
```

## Controller
مسئول HTTP است: parse request، validation سطح contract، status code و response mapping. Business Rule را در Controller متراکم نکنید.

## Service
Use Caseها را orchestration می‌کند: transaction boundary، repositoryها، domain operation و external gatewayها.

## Repository
Repository abstraction دسترسی به aggregate/domain data را جدا می‌کند. Spring Data می‌تواند implementation را بسازد، اما مفهوم Repository به framework وابسته نیست.

## DTO در برابر Entity
Entity persistence model است. DTO API contract است. bind مستقیم request به Entity coupling امنیتی و معماری ایجاد می‌کند.

## Configuration

```java
@Configuration
class PaymentConfiguration {
    @Bean
    PaymentGateway paymentGateway() {
        return new FakePaymentGateway();
    }
}
```

Configuration جای مناسبی برای wiring dependencyهایی است که annotation روی implementation آن‌ها مطلوب نیست.

## Circular Dependency
اگر Service A به B و B به A وابسته باشد، اغلب مرز مسئولیت اشتباه است. شکستن cycle با refactor طراحی بهتر از workaroundهای lifecycle است.

## AOP
Spring می‌تواند Cross-cutting concernهایی مانند Transaction، Security و Logging را با Proxy/AOP اعمال کند. دانستن این موضوع برای فهم `@Transactional` و `@PreAuthorize` ضروری است.

## مرزهای معماری
Framework باید در خدمت domain باشد. اگر همه business model به annotationها و HTTP/JPA details وابسته شود، تغییر framework یا تست مستقل سخت می‌شود.

## تمرین
1. Serviceای که dependency را با `new` می‌سازد به Constructor Injection تبدیل کنید.
2. Controller چاق را به Controller + Service تقسیم کنید.
3. Repository interface برای Order تعریف کنید.
4. Circular dependency فرضی را با بازطراحی responsibility حذف کنید.
5. توضیح دهید چرا singleton Service با mutable field می‌تواند خطرناک باشد.

## معیار تسلط
باید بتوانید Dependency Graph را توضیح دهید، Bean lifecycle و scope را درک کنید و business rule را از HTTP/Persistence concern جدا نگه دارید.
