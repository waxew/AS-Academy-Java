# راهنمای پاسخ تمرین‌های مقدماتی

## BankAccount
```java
class BankAccount {
    private long balance;

    void deposit(long amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount");
        balance += amount;
    }

    void withdraw(long amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("invalid withdraw");
        }
        balance -= amount;
    }
}
```

## نکته
پاسخ‌ها راهنما هستند؛ ابتدا خودتان طراحی کنید و سپس مقایسه کنید.
