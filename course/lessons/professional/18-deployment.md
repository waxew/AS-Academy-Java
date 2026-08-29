# فصل 18 — Docker و Deployment

## هدف
اجرای قابل تکرار برنامه در محیط‌های مختلف.

```dockerfile
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## مباحث
Build artifact، Environment Variable، Container، Docker Compose، CI/CD، Health Check، Logging، Monitoring و Production Profile.

## تمرین
برای یک Spring Boot API فایل Dockerfile و تنظیمات محیط Development/Production طراحی کنید.
