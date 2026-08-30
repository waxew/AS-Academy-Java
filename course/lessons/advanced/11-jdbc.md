# JDBC، Transaction و دسترسی امن به Database

## هدف
این درس JDBC را از اجرای یک SELECT ساده به طراحی Data Access قابل‌اعتماد می‌برد: PreparedStatement، Transaction، Batch، Connection Pool و Error Handling.

## اتصال
Credential واقعی نباید در Source Control ذخیره شود.

```java
String url = System.getenv("DB_URL");
String user = System.getenv("DB_USER");
String password = System.getenv("DB_PASSWORD");

try (Connection connection = DriverManager.getConnection(url, user, password)) {
    // database work
}
```

## PreparedStatement

```java
String sql = "SELECT id, name, price FROM products WHERE price >= ?";
try (PreparedStatement statement = connection.prepareStatement(sql)) {
    statement.setLong(1, 1000L);
    try (ResultSet result = statement.executeQuery()) {
        while (result.next()) {
            long id = result.getLong("id");
            String name = result.getString("name");
            long price = result.getLong("price");
        }
    }
}
```

Parameter binding علاوه بر خوانایی، ریسک SQL Injection را برای valueها کاهش می‌دهد. نام Table/Column را نمی‌توان مثل value bind کرد؛ dynamic SQL باید whitelist شود.

## try-with-resources
Connection، Statement و ResultSet resource هستند و باید deterministic بسته شوند. `try-with-resources` روش استاندارد مدیریت آن‌هاست.

## Transaction
وقتی چند تغییر باید به‌صورت یک واحد موفق یا شکست بخورند، Transaction لازم است.

```java
connection.setAutoCommit(false);
try {
    decreaseInventory(connection, productId, quantity);
    createOrder(connection, customerId);
    connection.commit();
} catch (Exception error) {
    connection.rollback();
    throw error;
} finally {
    connection.setAutoCommit(true);
}
```

## ACID
- Atomicity: همه عملیات یا هیچ‌کدام.
- Consistency: invariantهای داده حفظ شوند.
- Isolation: Transactionهای هم‌زمان اثر کنترل‌شده داشته باشند.
- Durability: Commit موفق پایدار باشد.

## Isolation و Concurrency
Dirty Read، Non-repeatable Read و Phantom Read از anomalyهای مهم‌اند. Isolation بالاتر همیشه بهتر نیست؛ ممکن است concurrency و throughput را کاهش دهد.

## Batch
برای تعداد زیاد Insert/Update، Batch می‌تواند round-tripهای Database را کاهش دهد.

```java
try (PreparedStatement ps = connection.prepareStatement(
        "INSERT INTO tags(name) VALUES (?)")) {
    for (String tag : tags) {
        ps.setString(1, tag);
        ps.addBatch();
    }
    ps.executeBatch();
}
```

## Connection Pool
ساخت Connection فیزیکی برای هر Request پرهزینه است. در application serverها از poolهایی مانند HikariCP استفاده می‌شود. Pool باید محدود باشد؛ pool بسیار بزرگ می‌تواند Database را overload کند.

## DAO / Repository Boundary
SQL را از UI و Business Logic جدا کنید. Repository/DAO مسئول persistence است، اما Transaction boundary معمولاً باید با use case هماهنگ باشد.

## N+1 و Query Design
حتی بدون ORM نیز تعداد Queryها مهم است. Loopی که برای هر Row یک Query جدا اجرا می‌کند می‌تواند performance را نابود کند.

## SQL Injection
بد:
```java
String sql = "SELECT * FROM users WHERE email='" + email + "'";
```

درست: valueها را bind کنید و dynamic identifierها را whitelist کنید.

## خطاهای رایج
- نگهداری Connection در field global.
- فراموش‌کردن rollback.
- Transaction بسیار طولانی.
- SELECT * در مسیرهای حساس performance.
- log کردن password یا connection string حساس.
- pool بدون timeout و monitoring.

## تمرین
1. CRUD کامل Product را با Repository پیاده کنید.
2. انتقال موجودی بین دو انبار را Transactional کنید.
3. Batch insert برای 10,000 رکورد بسازید.
4. یک SQL Injection آسیب‌پذیر را به PreparedStatement تبدیل کنید.
5. سناریوی Lost Update را تحلیل و راه‌حل ارائه کنید.

## پروژه کوچک
سیستم Student JDBC را به Repository + Service تقسیم کنید، Migration اولیه بسازید، Transaction برای ثبت دانشجو و Course Enrollment اضافه کنید و Integration Test با Database موقت بنویسید.

## معیار تسلط
باید بتوانید Connection lifecycle، Transaction boundary، SQL safety و failure path را قبل از نوشتن Data Access code مشخص کنید.
