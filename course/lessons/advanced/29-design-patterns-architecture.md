# Design Patterns و معماری قابل نگهداری

## اصل مهم
Pattern نسخه آماده برای Copy/Paste نیست. Pattern نام مشترکی برای یک مسئله تکرارشونده طراحی و راه‌حل آزموده‌شده آن است.

## Strategy
وقتی رفتار قابل تعویض داریم، مانند روش پرداخت، Strategy مناسب است.

```java
public interface PaymentStrategy {
    Receipt pay(long amount);
}
```

## Factory
ساخت Object پیچیده یا وابسته به نوع ورودی را از Client جدا می‌کند.

## Repository
Domain/Application را از جزئیات Persistence جدا می‌کند. Spring Data Repository نمونه‌ای رایج از این ایده است، اما مفهوم Repository محدود به Spring نیست.

## Adapter
یک Interface داخلی را به API یا سرویس خارجی متصل می‌کند؛ مثلاً اتصال `PaymentGateway` به بانک.

## Observer
برای انتشار Event به چند Listener مفید است. قبل از استفاده باید Coupling، ترتیب اجرا و مدیریت خطا بررسی شود.

## معماری لایه‌ای
`Controller -> Application Service -> Domain -> Repository/Adapter`

Controller مسئول HTTP است، نه Business Rule. Domain نباید به HTTP یا Database Framework وابسته باشد.

## SOLID در عمل
- SRP: یک دلیل اصلی برای تغییر.
- OCP: افزودن رفتار جدید با کمترین تغییر در کد پایدار.
- LSP: Subtype باید قرارداد Parent را حفظ کند.
- ISP: Interfaceهای کوچک و هدفمند.
- DIP: منطق سطح بالا به Abstraction وابسته باشد.

## Anti-patternها
God Class، Service با صدها خط، Controller شامل SQL، Static State مشترک، Catch کردن `Exception` بدون تصمیم، و Singleton سراسری بدون نیاز.

## تمرین معماری
یک فروشگاه را با Product، Inventory، Order و Payment طراحی کنید. مشخص کنید کدام بخش Domain، Application، Infrastructure و Delivery است. سپس Payment را طوری طراحی کنید که درگاه بانکی بدون تغییر Checkout قابل تعویض باشد.

## معیار قبولی
دانشجو باید Pattern را بر اساس مسئله انتخاب کند، نه صرفاً نام Pattern را حفظ کند.
