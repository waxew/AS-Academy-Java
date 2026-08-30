# Dynamic Programming در Java

## هدف
Dynamic Programming یا DP روشی برای حل مسئله‌هایی است که زیرمسئله‌های هم‌پوشان و ساختار بهینه دارند. هدف حفظ فرمول نیست؛ باید بتوانید State، Transition و Base Case را استخراج کنید.

## از Recursion تا DP
Fibonacci بازگشتی ساده محاسبات یکسان را بارها تکرار می‌کند و زمان آن تقریباً نمایی است.

```java
static long fibSlow(int n) {
    if (n <= 1) return n;
    return fibSlow(n - 1) + fibSlow(n - 2);
}
```

## Memoization: Top-Down
نتیجه زیرمسئله را Cache می‌کنیم.

```java
static long fib(int n, Map<Integer, Long> memo) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n);
    long value = fib(n - 1, memo) + fib(n - 2, memo);
    memo.put(n, value);
    return value;
}
```

زمان از رشد نمایی به O(n) کاهش پیدا می‌کند و O(n) حافظه مصرف می‌شود.

## Tabulation: Bottom-Up

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

## Space Optimization
وقتی State فعلی فقط به دو State قبلی وابسته است، کل Array لازم نیست.

```java
static long fibonacciOptimized(int n) {
    if (n <= 1) return n;
    long previous = 0;
    long current = 1;
    for (int i = 2; i <= n; i++) {
        long next = previous + current;
        previous = current;
        current = next;
    }
    return current;
}
```

فضا از O(n) به O(1) می‌رسد.

## چارچوب حل مسئله DP
1. State چیست؟
2. جواب State از کدام Stateهای قبلی ساخته می‌شود؟
3. Base Case چیست؟
4. ترتیب محاسبه چگونه است؟
5. آیا همه Stateها لازم‌اند؟
6. پیچیدگی Time/Space چقدر است؟

## مثال Climbing Stairs
اگر در هر حرکت 1 یا 2 پله جلو برویم:

`ways[i] = ways[i - 1] + ways[i - 2]`

این رابطه همان الگوی Fibonacci را دارد.

## 0/1 Knapsack
در Knapsack هر Item فقط یک‌بار قابل انتخاب است. State معمولاً بر اساس تعداد Itemهای بررسی‌شده و ظرفیت باقی‌مانده تعریف می‌شود. این مسئله تفاوت Greedy و DP را خوب نشان می‌دهد: انتخاب محلی بهترین Item لزوماً جواب جهانی بهینه نمی‌دهد.

## Longest Common Subsequence
برای دو String، State دوبعدی می‌تواند طول LCS تا indexهای مشخص را نگه دارد. این الگو در Diff، Bioinformatics و مقایسه Sequenceها دیده می‌شود.

## Coin Change
بسته به سؤال می‌توان کمترین تعداد Coin یا تعداد روش‌های ساخت Amount را محاسبه کرد. تعریف دقیق State قبل از کدنویسی حیاتی است.

## DP همیشه بهترین انتخاب نیست
اگر زیرمسئله تکراری نداریم، Memoization ارزش زیادی ندارد. گاهی Greedy، BFS، Divide and Conquer یا الگوریتم مستقیم ساده‌تر و سریع‌تر است.

## خطاهای رایج
- شروع کدنویسی قبل از تعریف State.
- Base Case اشتباه.
- Loop order اشتباه در DP دوبعدی.
- استفاده از DP برای مسئله‌ای که Greedy کافی است.
- نادیده‌گرفتن Overflow در `int` و حتی `long`.

## تمرین‌های مرحله‌ای
1. Climbing Stairs را Top-Down و Bottom-Up حل کنید.
2. Minimum Cost Climbing Stairs را حل و State را توضیح دهید.
3. Coin Change برای کمترین تعداد Coin را پیاده کنید.
4. LCS دو String را با جدول دوبعدی حل کنید.
5. 0/1 Knapsack را پیاده و پیچیدگی آن را تحلیل کنید.

## چالش
برای هر تمرین نسخه Brute Force اولیه را بنویسید، سپس آن را به Memoization و بعد Tabulation تبدیل کنید. زمان اجرای ورودی‌های بزرگ‌تر را مقایسه کنید.

## معیار تسلط
اگر برای یک مسئله جدید بتوانید State، Transition، Base Case و ترتیب محاسبه را بدون دیدن Solution استخراج کنید، وارد سطح واقعی DP شده‌اید.
