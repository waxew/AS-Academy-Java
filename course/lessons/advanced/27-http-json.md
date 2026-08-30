# HTTP Client، JSON و ارتباط با API

## هدف
این درس ارتباط Java application با سرویس HTTP واقعی را پوشش می‌دهد: Request، Response، Timeout، JSON mapping، خطا، Retry و امنیت.

## HTTP Request

```java
HttpClient client = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(5))
        .build();

HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://example.com/api/items"))
        .timeout(Duration.ofSeconds(10))
        .header("Accept", "application/json")
        .GET()
        .build();

HttpResponse<String> response = client.send(
        request,
        HttpResponse.BodyHandlers.ofString()
);
```

## Methodها
GET برای دریافت، POST برای ایجاد/فرمان، PUT برای جایگزینی، PATCH برای تغییر جزئی و DELETE برای حذف رایج‌اند. Semantics API مهم‌تر از حفظ نام Method است.

## Status Code
- 2xx موفقیت.
- 400 ورودی نامعتبر.
- 401 احراز هویت نشده.
- 403 دسترسی ممنوع.
- 404 Resource پیدا نشده.
- 409 Conflict.
- 429 Rate Limit.
- 5xx خطای سمت Server.

Client نباید فقط 200 را Success فرض کند؛ بعضی APIها 201 یا 204 برمی‌گردانند.

## JSON Mapping
در پروژه واقعی از Libraryهایی مثل Jackson استفاده می‌شود.

```java
record ProductDto(long id, String name, long price) {}

ObjectMapper mapper = new ObjectMapper();
ProductDto product = mapper.readValue(json, ProductDto.class);
```

DTO را از Domain Entity جدا نگه دارید تا تغییر Contract خارجی مستقیماً Domain را آلوده نکند.

## POST JSON

```java
String body = mapper.writeValueAsString(new ProductDto(0, "Keyboard", 2500));
HttpRequest request = HttpRequest.newBuilder(uri)
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .build();
```

## Async Client

```java
client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenAccept(System.out::println)
        .join();
```

Async بودن به معنی حذف نیاز به Timeout و Error Handling نیست.

## Timeout و Retry
Retry فقط برای Failureهای مناسب انجام شود. Retry کورکورانه روی POST غیر-idempotent ممکن است عملیات را دوبار انجام دهد. Backoff و Jitter برای سیستم‌های واقعی مهم‌اند.

## Rate Limiting
کد 429 و Headerهای مربوط به Retry باید مدیریت شوند. Client حرفه‌ای باید از overload کردن سرویس مقابل جلوگیری کند.

## امنیت
- Token و API Key را Hard-code نکنید.
- Secret را Log نکنید.
- TLS certificate validation را در Production غیرفعال نکنید.
- Response خارجی را Trusted input فرض نکنید.
- اندازه Body و Timeout را کنترل کنید.

## خطاهای شبکه
DNS failure، connection timeout، read timeout، connection reset، invalid JSON و 5xx سناریوهای جدا هستند و ممکن است سیاست متفاوتی بخواهند.

## تمرین
1. یک GET Client با Timeout بسازید.
2. JSON را به Record تبدیل کنید.
3. برای 404 و 500 Exceptionهای جدا تعریف کنید.
4. Retry محدود فقط برای 503 پیاده کنید.
5. یک POST idempotent با Idempotency Key طراحی کنید.

## پروژه کوچک
یک `AcademyApiClient` بسازید که Course list را دریافت کند، JSON را به DTO تبدیل کند، Timeout و خطاها را مدیریت کند و تست آن با Fake HTTP Server نوشته شود.

## معیار تسلط
دانشجو باید بتواند HTTP را به‌عنوان یک مرز غیرقابل‌اعتماد طراحی کند: Contract، Timeout، Failure، Security و Mapping باید صریح باشند.
