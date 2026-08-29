# درس 11 — JDBC

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/academy";

        // اطلاعات حساس در پروژه واقعی باید از Environment Variable خوانده شوند.
        try (Connection connection = DriverManager.getConnection(url, "academy", "change-me")) {
            String sql = "SELECT id, name FROM products WHERE price >= ?";

            // PreparedStatement از پارامتر bind شده استفاده می‌کند و ریسک SQL Injection را کاهش می‌دهد.
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, 1000L);

                try (ResultSet result = statement.executeQuery()) {
                    while (result.next()) {
                        System.out.println(result.getLong("id") + " - " + result.getString("name"));
                    }
                }
            }
        }
    }
}
```

> نام کاربری و رمز بالا صرفاً مثال آموزشی است و نباید Credential واقعی داخل Git ذخیره شود.
