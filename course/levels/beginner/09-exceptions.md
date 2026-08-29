# 09 — Exception Handling

- Exception hierarchy
- `try`, `catch`, `finally`
- `throw`, `throws`
- Checked / Unchecked
- Custom Exception
- try-with-resources

```java
public class InvalidPriceException extends RuntimeException {
    public InvalidPriceException(String message) { super(message); }
}
```
