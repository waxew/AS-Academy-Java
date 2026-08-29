# راهنمای پاسخ تمرین‌های تخصصی

## ساختار CRUD پیشنهادی
`Controller → Service → Repository → Database`

Controller فقط HTTP concerns، Service منطق Use Case و Repository دسترسی داده را مدیریت کند.

## Validation
برای ورودی API از DTO استفاده کنید و Entity را مستقیماً به Request bind نکنید.

## Transaction
Boundary تراکنش را معمولاً در Service و حول یک Use Case واقعی قرار دهید.
