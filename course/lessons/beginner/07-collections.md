# درس 07 — Collections Framework

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsDemo {
    public static void main(String[] args) {
        // List ترتیب عناصر را حفظ می‌کند و تکرار مجاز است.
        List<String> products = new ArrayList<>();
        products.add("Laptop");
        products.add("Phone");

        // Map داده را به صورت کلید/مقدار نگه می‌دارد.
        Map<Long, String> customers = new HashMap<>();
        customers.put(1L, "Ali");
        customers.put(2L, "Sara");

        products.forEach(System.out::println);
        System.out.println(customers.get(1L));
    }
}
```

## انتخاب ساختار
- ArrayList: دسترسی سریع بر اساس index.
- HashSet: یکتایی و lookup سریع.
- HashMap: نگاشت key/value.
- TreeMap/TreeSet: داده مرتب‌شده.
