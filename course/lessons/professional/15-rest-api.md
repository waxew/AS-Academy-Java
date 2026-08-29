# فصل 15 — REST API

## مفاهیم اصلی
Resource، URI، HTTP Method، Status Code، Request Body، Response Body، Validation و Error Contract.

```java
@RestController
@RequestMapping("/api/students")
class StudentController {
    @GetMapping
    List<String> all() {
        return List.of("Ali", "Sara");
    }
}
```

## HTTP
- GET: خواندن
- POST: ایجاد
- PUT/PATCH: تغییر
- DELETE: حذف

## تمرین
برای Student عملیات CRUD طراحی کنید و Status Code مناسب هر عملیات را تعیین کنید.
