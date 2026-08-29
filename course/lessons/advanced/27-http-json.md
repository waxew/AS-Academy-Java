# HTTP Client و JSON

```java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://example.com/api/items"))
        .GET()
        .build();

HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.statusCode());
```

## مباحث
HTTP Method، Header، Timeout، Status Code، JSON serialization/deserialization و خطاهای شبکه.

## تمرین
یک Client کوچک بسازید که JSON دریافت و فیلدهای موردنیاز را استخراج کند.
