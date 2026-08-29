package academy.as.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

/** تست یکپارچه آموزشی برای SQLite/JDBC. */
class MainTest {

    @Test
    void sqlitePersistsStudent() throws Exception {
        Path database = Files.createTempFile("academy-students-", ".db");
        String url = "jdbc:sqlite:" + database;

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE students (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, email TEXT NOT NULL UNIQUE)");
            statement.executeUpdate("INSERT INTO students(name,email) VALUES('Sara','sara@example.com')");
        }

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM students")) {
            assertEquals(1, result.getInt(1));
        } finally {
            Files.deleteIfExists(database);
        }
    }
}
