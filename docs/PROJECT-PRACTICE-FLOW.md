# جریان پروژه‌محور آموزش Java

پس از پایان هر سطح، برنامه باید Mini Project همان سطح را از Course Package نمایش دهد و Progress/Project Tracking را از AS-Academy-Core دریافت کند.

1. هنرجو صورت مسئله را می‌خواند.
2. قبل از مشاهده سورس مرجع، نسخه خودش را پیاده‌سازی می‌کند.
3. مثال‌ها و تست‌های دستی را اجرا می‌کند.
4. Checklist پروژه را تکمیل می‌کند.
5. سورس مرجع را با راه‌حل خودش مقایسه می‌کند.
6. Quiz پایان سطح را انجام می‌دهد.
7. Milestone سطح در Core ثبت می‌شود.

## پروژه‌های مرجع
- Fundamentals: Grade Analyzer
- Beginner: Invoice Manager
- Advanced: Student JDBC
- Professional: Academy Store API

## اصل معماری
Course فقط محتوا، سورس آموزشی، Stable ID و metadata را نگهداری می‌کند. Progress Engine، Navigation، Database، Quiz Engine و Project Tracking نباید در این repository دوباره پیاده‌سازی شوند و متعلق به AS-Academy-Core هستند.
