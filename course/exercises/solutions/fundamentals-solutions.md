# راهنمای پاسخ تمرین‌های مبانی

## مجموع اعداد زوج 1 تا 100
```java
int sum = 0;
for (int i = 1; i <= 100; i++) {
    if (i % 2 == 0) {
        sum += i;
    }
}
System.out.println(sum);
```

## بزرگ‌ترین مقدار آرایه
```java
int[] values = {4, 9, 2, 17, 3};
int max = values[0];
for (int value : values) {
    if (value > max) {
        max = value;
    }
}
System.out.println(max);
```

ابتدا خودتان تمرین را حل کنید و سپس پاسخ را بررسی کنید.
