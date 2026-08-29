# Transaction و Performance دیتابیس

## مفاهیم
Atomicity، Consistency، Isolation، Durability، Transaction Boundary، Index، N+1، Pagination و Batch Processing.

```java
@Transactional
public void transfer(Account from, Account to, long amount) {
    from.withdraw(amount);
    to.deposit(amount);
}
```

اگر عملیات دوم شکست بخورد، Transaction باید از ثبت وضعیت نیمه‌کاره جلوگیری کند.

## تمرین
سناریوی خریدی طراحی کنید که کاهش موجودی و ثبت سفارش در یک Transaction انجام شود.
