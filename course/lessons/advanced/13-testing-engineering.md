# Testing و مهندسی نرم‌افزار در Java

## هدف
کد حرفه‌ای فقط کدی نیست که امروز کار کند؛ باید قابل فهم، تست، تغییر و عیب‌یابی باشد.

## Test Pyramid
- Unit Test: سریع، ایزوله و زیاد.
- Integration Test: تعامل componentها، Database یا Framework.
- End-to-End Test: مسیر کامل و گران‌تر.

همه رفتارها را با E2E تست نکنید و همه چیز را نیز Mock نکنید.

## JUnit

```java
class DiscountCalculatorTest {
    private final DiscountCalculator calculator = new DiscountCalculator();

    @Test
    void appliesTwentyPercentDiscount() {
        assertEquals(800, calculator.calculate(1000, 20));
    }

    @Test
    void rejectsInvalidPercent() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(1000, 120));
    }
}
```

نام Test باید رفتار مورد انتظار را بیان کند.

## Arrange / Act / Assert
Test خوانا معمولاً سه مرحله دارد: آماده‌سازی داده، اجرای رفتار و بررسی نتیجه. Test نباید چند رفتار مستقل را هم‌زمان اثبات کند.

## Boundary Cases
فقط Happy Path کافی نیست. Zero، Empty، Null، Min/Max، Duplicate، Unauthorized و Failure dependencyها باید بررسی شوند.

## Parameterized Test
برای مجموعه‌ای از ورودی‌های مشابه از Parameterized Test استفاده کنید تا duplication کاهش یابد، بدون اینکه intent تست مبهم شود.

## Mockito و Test Double
Mock برای dependency خارجی یا interaction مهم مفید است.

```java
PaymentGateway gateway = mock(PaymentGateway.class);
when(gateway.pay(5000)).thenReturn("PAY-1");
```

Mock کردن value objectها، collectionها یا implementation detailها معمولاً علامت طراحی ضعیف Test است.

## Integration Test
Repository، SQL mapping، Serialization، Security configuration و Framework wiring اغلب نیاز به Integration Test دارند. چیزی که Unit Test نمی‌تواند ثابت کند را به زور Mock نکنید.

## FIRST
Unit Test خوب معمولاً Fast، Independent، Repeatable، Self-validating و Timely است.

## Clean Code
اصول عملی:
- نام دقیق‌تر از comment جبرانی است.
- Method کوچک با مسئولیت مشخص.
- side effect پنهان کم.
- dependencyها صریح.
- duplication معنادار حذف شود.
- Exception بلعیده نشود.

## SOLID
- SRP: یک دلیل اصلی برای تغییر.
- OCP: توسعه رفتار بدون تغییر مکرر core logic.
- LSP: subtype قرارداد type پایه را نقض نکند.
- ISP: interfaceهای کوچک و متمرکز.
- DIP: business policy به abstraction وابسته باشد، نه infrastructure concrete.

## Dependency Injection

```java
final class CheckoutService {
    private final PaymentGateway paymentGateway;

    CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}
```

این طراحی testability را افزایش می‌دهد و coupling را کم می‌کند.

## Coverage
Coverage ابزار تشخیصی است، نه هدف. 100٪ line coverage می‌تواند با assertionهای ضعیف بی‌ارزش باشد. Behavior و risk مهم‌تر از درصد خام هستند.

## Mutation Testing
Mutation testing عمداً تغییرات کوچک در code ایجاد می‌کند تا ببیند Testها آن‌ها را می‌گیرند یا نه؛ برای سنجش قدرت assertionها مفید است.

## Test Smell
- Test وابسته به ترتیب اجرا.
- sleep واقعی.
- shared mutable fixture.
- assertion نداشتن.
- mock بیش از حد.
- تست implementation detail private.

## تمرین
1. DiscountCalculator را با boundary test کامل کنید.
2. CheckoutService را با Fake/Mock PaymentGateway تست کنید.
3. Repository را Integration Test کنید.
4. یک کلاس با dependency hard-coded را Refactor و Dependency Injection اضافه کنید.
5. پنج Test Smell در یک Test Suite فرضی پیدا کنید.

## پروژه مهندسی
یک feature کوچک را با چرخه Red → Green → Refactor بسازید. Unit Test، Integration Test، CI و گزارش کوتاه تصمیم‌های طراحی را تحویل دهید.

## معیار تسلط
باید بتوانید مشخص کنید چه چیزی Unit Test، چه چیزی Integration Test و چه چیزی E2E می‌خواهد و طراحی production code را برای testability خراب نکنید.
