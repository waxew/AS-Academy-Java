# درس 09 — Generics، Lambda و Stream API

```java
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6);

        // فقط اعداد زوج انتخاب، دو برابر و سپس جمع می‌شوند.
        int total = values.stream()
                .filter(value -> value % 2 == 0)
                .map(value -> value * 2)
                .reduce(0, Integer::sum);

        System.out.println(total);
    }
}
```

## اصل مهم
Stream منبع داده را تغییر نمی‌دهد؛ یک pipeline از عملیات declarative می‌سازد.
