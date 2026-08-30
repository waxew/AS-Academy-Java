# طراحی REST API حرفه‌ای

## هدف
REST فقط نگاشت CRUD به HTTP نیست. API باید contract پایدار، status code درست، validation، pagination، error model و evolution strategy داشته باشد.

## Resource Design
URI را حول resource طراحی کنید:

```text
GET    /api/students
POST   /api/students
GET    /api/students/{id}
PATCH  /api/students/{id}
DELETE /api/students/{id}
```

از verbهای غیرضروری در URI مثل `/getStudents` دوری کنید.

## Controller

```java
@RestController
@RequestMapping("/api/students")
class StudentController {
    private final StudentService service;

    StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    StudentResponse find(@PathVariable long id) {
        return service.find(id);
    }
}
```

## Status Code
- 200: پاسخ موفق معمولی.
- 201: resource ایجاد شد؛ بهتر است Location مشخص باشد.
- 204: موفق بدون body.
- 400: request نامعتبر.
- 401: authentication لازم/نامعتبر.
- 403: authenticated ولی مجاز نیست.
- 404: resource وجود ندارد.
- 409: conflict با state فعلی.
- 422 در بعضی APIها برای semantic validation استفاده می‌شود.

## Validation
Syntax/contract validation را از business rule جدا کنید.

```java
public record CreateStudentRequest(
        @NotBlank String name,
        @Email String email
) {}
```

Unique بودن email معمولاً business/database rule است، نه صرفاً bean validation.

## Error Contract
Error response باید machine-readable و پایدار باشد؛ مثلاً code، message، field errors، timestamp و trace/request id.

## Pagination
List endpoint بزرگ نباید همه رکوردها را برگرداند. Offset pagination ساده است؛ cursor/keyset pagination برای datasetهای بزرگ و feedهای متغیر می‌تواند مناسب‌تر باشد.

## Filtering و Sorting
پارامترهای filter/sort را whitelist و validate کنید. اجازه ندهید نام arbitrary column مستقیماً به query تبدیل شود.

## Idempotency
GET/PUT/DELETE از نظر semantics باید idempotent باشند. برای عملیات مالی POST می‌توان Idempotency-Key طراحی کرد تا retry باعث پرداخت دوباره نشود.

## PUT در برابر PATCH
PUT معمولاً representation را جایگزین می‌کند؛ PATCH تغییر جزئی را بیان می‌کند. Contract باید مشخص کند null به معنی حذف، بدون تغییر یا مقدار واقعی است.

## Versioning و Evolution
تا جای ممکن تغییر backward-compatible انجام دهید. حذف/تغییر field یا semantic existing endpoint breaking change است. Versioning می‌تواند path/header/media type باشد، اما strategy باید ثابت باشد.

## OpenAPI
API contract را با OpenAPI مستند کنید. Documentation باید با implementation sync بماند و مثال request/response داشته باشد.

## امنیت API
Mass assignment، over-posting، اطلاعات اضافی در response و IDOR از خطرهای رایج‌اند. DTO و authorization روی resource ownership ضروری است.

## تمرین
1. CRUD Student را با DTO طراحی کنید.
2. Pagination و sorting اضافه کنید.
3. Error contract واحد برای validation و not-found بسازید.
4. PATCH را با semantics مشخص طراحی کنید.
5. برای Checkout idempotency strategy بنویسید.

## معیار تسلط
باید بتوانید API را به‌عنوان یک contract عمومی طراحی کنید؛ نه صرفاً مجموعه‌ای از Controller methodها.
