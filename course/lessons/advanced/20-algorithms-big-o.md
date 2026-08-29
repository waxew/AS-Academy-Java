# الگوریتم و Big O

## هدف
هنرجو بتواند کارایی زمانی و حافظه‌ای راه‌حل‌ها را مقایسه کند.

## مفاهیم
O(1)، O(log n)، O(n)، O(n log n)، O(n²)، Time Complexity و Space Complexity.

```java
static int findMax(int[] values) {
    int max = values[0];
    // آرایه یک بار پیمایش می‌شود؛ پیچیدگی زمانی O(n) است.
    for (int value : values) {
        if (value > max) max = value;
    }
    return max;
}
```

## تمرین
پیچیدگی زمانی جست‌وجوی خطی، دو حلقه تو در تو و Binary Search را تحلیل کنید.
