# درس 04 — آرایه‌ها و متدها

```java
import java.util.Arrays;

public class Scores {
    public static void main(String[] args) {
        int[] scores = {18, 12, 20, 15, 17};

        // متد average برای جلوگیری از تکرار منطق محاسبه استفاده می‌شود.
        double average = average(scores);

        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println("Average: " + average);
    }

    // این متد آرایه نمرات را دریافت می‌کند و میانگین را برمی‌گرداند.
    static double average(int[] values) {
        int sum = 0;

        for (int value : values) {
            sum += value;
        }

        return (double) sum / values.length;
    }
}
```

## تمرین
متدهای `min`, `max`, `sum` و `average` را بدون استفاده از Stream API پیاده‌سازی کنید.
