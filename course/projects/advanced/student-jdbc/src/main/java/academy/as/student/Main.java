package academy.as.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/** پروژه پایان سطح پیشرفته برای تمرین JDBC و PreparedStatement. */
public final class Main {
    private static final String URL = "jdbc:sqlite:students.db";

    private Main() { }

    public static void main(String[] args) throws Exception {
        initialize();
        create("Ali", "ali@example.com");
        printAll();
    }

    static void initialize() throws Exception {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, email TEXT NOT NULL UNIQUE)");
        }
    }

    static void create(String name, String email) throws Exception {
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement statement = connection.prepareStatement("INSERT OR IGNORE INTO students(name,email) VALUES(?,?)")) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
        }
    }

    static void printAll() throws Exception {
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement statement = connection.prepareStatement("SELECT id,name,email FROM students ORDER BY id");
             ResultSet result = statement.executeQuery()) {
            while (result.next()) {
                System.out.printf("%d | %s | %s%n", result.getLong("id"), result.getString("name"), result.getString("email"));
            }
        }
    }
}
