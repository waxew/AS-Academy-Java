# درس 08 — Exception و File I/O

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDemo {
    public static void main(String[] args) {
        Path path = Path.of("note.txt");

        try {
            // فایل متنی را با API مدرن NIO می‌نویسیم.
            Files.writeString(path, "AS Academy Java");

            // محتوای فایل را دوباره می‌خوانیم.
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException exception) {
            // IOException یک Checked Exception است و باید مدیریت شود.
            System.err.println("File operation failed: " + exception.getMessage());
        }
    }
}
```

## تمرین
دفترچه یادداشتی بسازید که هر یادداشت را در یک فایل ذخیره و بعداً بازیابی کند.
