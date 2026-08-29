# Dynamic Programming

## ایده
وقتی زیرمسئله‌ها تکرار می‌شوند، نتیجه آن‌ها را ذخیره می‌کنیم تا محاسبه دوباره انجام نشود.

```java
static long fibonacci(int n) {
    if (n <= 1) return n;
    long[] dp = new long[n + 1];
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```

## تمرین
مسئله Climbing Stairs را با Dynamic Programming حل کنید.
