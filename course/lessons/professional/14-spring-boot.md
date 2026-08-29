# فصل 14 — Spring Boot

## هدف
ساخت برنامه Backend با پیکربندی کم و معماری لایه‌ای.

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## مفاهیم
Starter، Auto Configuration، Bean، Dependency Injection، Configuration، Profiles، Controller، Service و Repository.

## تمرین
یک API ساده برای مدیریت `Student` بسازید و Controller را از Service جدا نگه دارید.
