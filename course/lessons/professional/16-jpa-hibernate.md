# JPA و Hibernate حرفه‌ای

## هدف
JPA را به‌عنوان persistence abstraction بفهمید، نه جایگزین دانستن SQL و Database.

## Entity

```java
@Entity
@Table(name = "students")
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
```

Entity باید identity و lifecycle مشخص داشته باشد. API DTO را مستقیماً Entity نکنید.

## Persistence Context
Entity در transaction می‌تواند managed باشد. Hibernate تغییر managed entity را با Dirty Checking هنگام flush به SQL تبدیل می‌کند.

## Entity State
Transient، Managed، Detached و Removed stateهای مهم lifecycle هستند. بسیاری از رفتارهای عجیب JPA از نفهمیدن همین stateها ناشی می‌شود.

## Relationship

```java
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "course_id")
private Course course;
```

رابطه را بر اساس domain و query pattern طراحی کنید، نه فقط اینکه جدول‌ها foreign key دارند.

## Owning Side
در رابطه دوطرفه باید owning side را بفهمید و دو سمت object graph را هماهنگ نگه دارید. helper methodهایی مانند `order.addItem(item)` مفیدند.

## Lazy Loading
Lazy loading می‌تواند query غیرمنتظره یا `LazyInitializationException` ایجاد کند. EAGER کردن همه چیز راه‌حل نیست و می‌تواند graph بزرگی load کند.

## N+1
اگر یک query برای Parentها و سپس برای هر Parent یک query جدا اجرا شود N+1 رخ می‌دهد. راهکارها شامل fetch join، EntityGraph، projection و query اختصاصی هستند.

## JPQL و Projection
برای read modelها لازم نیست همیشه Entity کامل load شود. Projection می‌تواند داده موردنیاز endpoint را مستقیم برگرداند.

## Transaction
Persistence Context معمولاً با transaction معنا پیدا می‌کند. Transaction boundary را در Service/use case قرار دهید، نه در Controller.

## Optimistic Locking

```java
@Version
private long version;
```

برای تشخیص concurrent update مفید است. برای inventory حساس ممکن است pessimistic locking یا atomic database update مناسب‌تر باشد.

## Pessimistic Lock
وقتی resource باید هنگام transaction قفل شود، query می‌تواند lock mode بگیرد؛ اما lock طولانی throughput و deadlock risk را افزایش می‌دهد.

## Cascade و Orphan Removal
Cascade را کورکورانه روی همه relationها نگذارید. lifecycle parent/child باید واقعاً مشترک باشد.

## equals/hashCode
Entity identity و generated id باعث پیچیدگی equality می‌شود. استفاده از mutable field در hashCode می‌تواند collectionهای hash-based را خراب کند.

## Migration
`ddl-auto=create/update` جای migration production نیست. Schema evolution را با migration toolهایی مثل Flyway/Liquibase version کنید.

## Performance
- تعداد queryها را ببینید.
- index مناسب Database داشته باشید.
- pagination را فراموش نکنید.
- batch write و fetch size را در workload مناسب بررسی کنید.
- SQL generated را در debugging تحلیل کنید.

## تمرین
1. Student/Course relation را طراحی کنید.
2. یک N+1 ایجاد و با fetch join اصلاح کنید.
3. Optimistic locking به Entity اضافه کنید.
4. Projection برای report endpoint بسازید.
5. migration برای افزودن column جدید بنویسید.

## معیار تسلط
باید بتوانید SQL تقریبی پشت operationهای JPA را پیش‌بینی کنید و lifecycle، transaction و concurrency را آگاهانه مدیریت کنید.
