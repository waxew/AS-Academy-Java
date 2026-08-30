# AS Academy Java

مرجع جامع آموزش Java از صفر مطلق تا Java Backend حرفه‌ای در مجموعه AS Academy.

## وضعیت
Course Package نسخه `1.3.0` شامل چهار سطح، 38 فصل، 165 تمرین مرحله‌بندی‌شده، Quiz/Assessment، پروژه‌های runnable و Capstone فروشگاهی است.

## معماری Core-First
این مخزن Course Repository است. Navigation، Design System، Database، Content Engine، Progress، Quiz/Exercise Engine، Search، Bookmark، Settings، Achievement، Update، Backup و Code Runner Framework در `AS-Academy-Core` نگهداری می‌شوند و اینجا تکرار نمی‌شوند.

این مخزن فقط محتوای Java، metadata، branding، تمرین، آزمون، پروژه و capabilityهای اختصاصی دوره را نگه می‌دارد.

## مسیر آموزشی
1. مبانی Java و محیط توسعه
2. Syntax، Type، Control Flow، Array و Method
3. OOP، Collections، Exception و File I/O
4. Generics، Lambda، Stream و Optional
5. Concurrency و Virtual Threads
6. JVM، Memory، GC و Diagnostics
7. SQL، JDBC و Transaction
8. Testing، Clean Code و SOLID
9. Algorithms، Data Structures، Tree/Graph و Dynamic Programming
10. Reflection، Annotation، HTTP/JSON
11. Maven، Gradle، Logging و Design Patterns
12. Spring Core و Dependency Injection
13. Spring Boot و Production Configuration
14. REST API، Validation و Error Contract
15. JPA/Hibernate، Transaction و Performance
16. Spring Security و JWT
17. Spring Boot Testing
18. Docker، CI/CD و Deployment
19. Java Android
20. Git/GitHub، Interview و Portfolio
21. Capstone: Academy Store API

## تمرین و ارزیابی
`course/exercises/EXERCISE-BANK.md` شامل 165 تمرین از مقدماتی تا Capstone و مصاحبه است. تمرین‌های پیشرفته نیازمند تحلیل complexity/test هستند و بخش Professional با تست خودکار و architecture rationale ارزیابی می‌شود.

## پروژه‌ها
پروژه‌های runnable شامل Grade Analyzer، Invoice Manager و Student JDBC هستند. Capstone نهایی `Academy Store API` با Spring Boot، Security/JWT، JPA/Hibernate، PostgreSQL، Checkout، Inventory، Payment abstraction، Testing، Docker و CI توسعه داده شده است.

## قرارداد Course Package
دوره از قرارداد `AS-Academy-Core/docs/course-contract.md` پیروی می‌کند. Stable IDها حفظ می‌شوند و تغییر curriculum با versioning مدیریت می‌شود. فایل‌های پایه شامل `manifest.json`، `branding.json`، `levels.json` و `chapters.json` هستند.

## ساختار اصلی
```text
course/
├── manifest.json
├── branding.json
├── course.json
├── levels.json
├── chapters.json
├── learning-flow.json
├── lessons/
├── exercises/
├── quizzes/
├── projects/
└── glossary/
```

## CI
دو مسیر CI برای پروژه‌های runnable دوره و Spring Boot Capstone تعریف شده‌اند. هر تغییر کد باید build/test را سبز نگه دارد.

## قانون توسعه
قابلیت عمومی جدید باید ابتدا در `AS-Academy-Core` پیاده‌سازی شود. این repository نباید نسخه تکراری Navigation، Database، Progress، Quiz Engine یا سایر زیرساخت‌های مشترک ایجاد کند.

---
AS Academy / AS Team Group
