# درس 01 — اولین برنامه Java

## هدف
در پایان این درس هنرجو می‌تواند ساختار یک برنامه ساده Java را توضیح دهد، آن را کامپایل کند و خروجی بگیرد.

## کد
```java
public class Main {
    // نقطه شروع اجرای برنامه است.
    public static void main(String[] args) {
        // این دستور متن را در خروجی استاندارد چاپ می‌کند.
        System.out.println("Hello Java!");
    }
}
```

## توضیح خط‌به‌خط
- `public class Main`: تعریف یک کلاس عمومی با نام Main.
- `public static void main(String[] args)`: نقطه ورود برنامه JVM.
- `System.out.println`: چاپ یک خط در Console.

## اجرا
```bash
javac Main.java
java Main
```

## تمرین
1. متن خروجی را به نام خودتان تغییر دهید.
2. سه خط جداگانه چاپ کنید.
3. تفاوت `print` و `println` را آزمایش کنید.
