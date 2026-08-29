# String، ورودی و تبدیل داده

## هدف
کار با متن، دریافت ورودی و تبدیل String به عدد.

```java
import java.util.Scanner;

public class InputDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.println("Hello " + name + ", age=" + age);
        }
    }
}
```

## مباحث
String immutability، equals، equalsIgnoreCase، substring، contains، split، trim، StringBuilder، parseInt و parseDouble.

## تمرین
نام کامل کاربر را بگیرید، فاصله‌های اضافه را حذف و تعداد کلمات را محاسبه کنید.
