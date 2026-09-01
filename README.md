# AS Academy Java

اپ دوره Java در معماری جدید AS Academy.

## معماری فعلی

این repository دیگر محل اصلی نگهداری محتوای آموزشی یا UI مشترک نیست:

- `AS-Academy-Core`: موتور مشترک، Navigation contract، Database، Progress، Search، Quiz/Exercise، Bookmark، Notes، Update و سرویس‌های runtime.
- `AS-Academy-MainUi`: UI/UX مشترک، Screenها، Drawer/Profile، Theme، Lesson Reader و نمایش Course Package.
- `AS-Academy-MainCourse`: منبع واحد تمام درس‌ها، فصل‌ها، تمرین‌ها، Quizها، آزمون‌ها، پروژه‌ها، Capstone، Glossary و metadata دوره‌ها.
- `AS-Academy-Java`: App shell نازک Java؛ فقط Application/Build config، اتصال سه لایه، branding/capability واقعاً اختصاصی و release app را نگه می‌دارد.

## Source of Truth دوره Java

محتوای Java باید در مسیر زیر توسعه داده شود:

`AS-Academy-MainCourse/courses/java/course`

فایل `academy-integration.json` قرارداد اتصال این app به Core، MainUi و MainCourse را مشخص می‌کند.

## وضعیت محتوای قبلی

`course/` و `course-content/` فعلاً به‌عنوان Migration Snapshot نگه داشته شده‌اند تا انتقال بدون از دست‌رفتن محتوا انجام شود. بعد از کامل‌شدن migration، تغییر محتوای آموزشی در این دو مسیر مجاز نیست و نسخه مرجع فقط MainCourse خواهد بود.

محتوای موجود شامل چهار سطح مبانی، مقدماتی، پیشرفته و تخصصی، 38 فصل، بانک 165 تمرینی، Quiz/Assessment، پروژه‌های runnable و Academy Store API Capstone است.

## قانون توسعه

1. منطق مشترک فقط در Core.
2. UI مشترک فقط در MainUi.
3. محتوای آموزشی فقط در MainCourse.
4. Java repo فقط App shell و قابلیت واقعاً اختصاصی Java.
5. Stable IDهای دوره هنگام migration حفظ می‌شوند تا Progress، Bookmark و Note کاربران نشکند.
6. Course Package باید قبل از Release با validator/compiler رسمی Core تأیید شود.

## CI

CIهای پروژه‌های runnable و Capstone حفظ شده‌اند. CI محتوای Course Package در دوره migration به MainCourse منتقل/بازطراحی می‌شود تا منبع واحد محتوا را validate کند.

---
AS Academy / AS Team Group
