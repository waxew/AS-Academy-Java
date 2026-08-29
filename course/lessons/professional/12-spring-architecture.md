# درس 12 — معماری Spring Boot

مسیر پیشنهادی درخواست:

```text
HTTP Request
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Database
```

## مسئولیت‌ها
- Controller: HTTP و Validation سطح ورودی.
- Service: Use Case و Business Rule.
- Repository: دسترسی به داده.
- DTO: قرارداد ورودی/خروجی API.
- Entity: مدل Persistence.

## قانون
Business Logic نباید داخل Controller یا Entity متراکم شود. ساختار باید قابل Test و قابل تغییر باقی بماند.
