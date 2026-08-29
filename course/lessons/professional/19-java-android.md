# فصل 19 — Java برای Android

## هدف
آشنایی هنرجوی Java با کاربرد زبان در Android و مسیر مهاجرت به Kotlin.

## مباحث
Activity، Fragment، Intent، RecyclerView، Lifecycle، ViewModel، Room، Retrofit، Permission، Notification و WorkManager.

```java
Intent intent = new Intent(this, DetailActivity.class);
intent.putExtra("student_id", 10L);
startActivity(intent);
```

## نکته
در پروژه‌های جدید Android، Kotlin انتخاب رایجی است؛ اما درک Java برای نگهداری پروژه‌های قدیمی، کتابخانه‌ها و درک اکوسیستم JVM ارزشمند است.

## تمرین
یک برنامه ساده فهرست درس‌ها طراحی کنید که صفحه List و Detail داشته باشد.
