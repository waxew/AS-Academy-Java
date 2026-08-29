# AS Academy Java

مرجع جامع آموزش Java از صفر تا سطح تخصصی در مجموعه AS Academy.

## وضعیت
Course Package نسخه `1.0.0` با چهار سطح، 22 ماژول اصلی، تمرین، آزمون، پروژه، واژه‌نامه و Capstone آماده شده است.

## معماری
این مخزن یک **Course Repository** است. هسته مشترک برنامه از `AS-Academy-Core` تأمین می‌شود و در اینجا تکرار نمی‌شود.

### مسئولیت AS-Academy-Core
Navigation، Design System، Database، Content Engine، Progress، Quiz، Exercise، Project، Search، Bookmark، Glossary Engine، Profile/Drawer، Settings، Achievement، Update، Backup، Code Runner Framework و Course Schema.

### مسئولیت AS-Academy-Java
درس‌ها، مثال‌ها، تمرین‌ها، آزمون‌ها، پروژه‌ها، واژه‌نامه، Metadata، Branding و قابلیت‌های اختصاصی Java.

## مسیر دوره
1. شروع Java
2. نصب و محیط توسعه
3. انواع داده و عملگرها
4. کنترل جریان
5. آرایه‌ها و متدها
6. OOP پایه
7. OOP تکمیلی
8. Collections
9. Exception Handling
10. File I/O و Data
11. Modern Java
12. Concurrency
13. JVM
14. SQL و JDBC
15. Engineering, Testing, Clean Code و Patterns
16. Spring Core
17. Spring Boot
18. REST API
19. JPA و Hibernate
20. Security و JWT
21. Docker و Deployment
22. Java Android

## سطوح
- `fundamentals` — مبانی
- `beginner` — مقدماتی
- `advanced` — پیشرفته
- `professional` — تخصصی

## پروژه‌ها
مسیر پروژه‌ای از ماشین حساب و سیستم نمرات شروع می‌شود و به JDBC، REST API، Authentication و Backend فروشگاهی می‌رسد. پروژه نهایی `Academy Store API` با Spring Boot، Spring Security، JPA/Hibernate، PostgreSQL، Testing، Docker و OpenAPI تعریف شده است.

## ساختار
```text
course/
├── course.json
├── levels/
│   ├── fundamentals/
│   ├── beginner/
│   ├── advanced/
│   └── professional/
├── exercises/
├── quizzes/
├── projects/
└── glossary/

docs/
├── COURSE-ROADMAP.md
├── CORE-INTEGRATION.md
├── LEARNING-PATH.md
├── QUALITY-CHECKLIST.md
└── RELEASES.md
```

## اسناد مهم
- `docs/COURSE-ROADMAP.md` — نقشه جامع
- `docs/CORE-INTEGRATION.md` — مرز مسئولیت Core و Java
- `docs/LEARNING-PATH.md` — مسیرهای یادگیری
- `docs/QUALITY-CHECKLIST.md` — کنترل کیفیت
- `docs/RELEASES.md` — نسخه‌های محتوا
- `course/projects/PROJECTS.md` — پروژه‌های عملی
- `course/projects/capstone/README.md` — پروژه نهایی

## استاندارد محتوا
هر درس باید هدف یادگیری، توضیح مفهومی، مثال قابل اجرا و تمرین داشته باشد. شناسه‌های محتوا Stable هستند، فایل‌ها UTF-8 و RTL-friendly هستند و Secret یا Credential نباید وارد مخزن شود.

## توسعه بعدی
هر قابلیت عمومی جدید ابتدا باید در `AS-Academy-Core` پیاده‌سازی شود. تغییرات این مخزن باید تا حد امکان محدود به محتوای Java و Capability اختصاصی آن باقی بماند.

---
AS Academy / AS Team Group
