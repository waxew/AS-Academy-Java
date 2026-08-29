# Validation و مدیریت خطای API

## DTO
```java
public record CreateStudentRequest(
        @NotBlank String name,
        @Email String email
) {}
```

## Global Error Handling
```java
@RestControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<Map<String, String>> handle(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
    }
}
```

## تمرین
یک Error Contract ثابت شامل code، message و timestamp طراحی کنید.
