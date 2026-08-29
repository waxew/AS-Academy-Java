# فصل 16 — JPA و Hibernate

## هدف
نگاشت Objectهای Java به داده‌های رابطه‌ای.

```java
@Entity
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
```

## مباحث
Entity، Repository، Persistence Context، Transaction، OneToOne، OneToMany، ManyToOne، ManyToMany، Lazy/Eager Loading، JPQL و N+1.

## تمرین
مدل Course و Student را با رابطه مناسب طراحی کنید.
