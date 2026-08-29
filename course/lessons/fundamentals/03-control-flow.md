# درس 03 — شرط‌ها و حلقه‌ها

```java
public class ControlFlowDemo {
    public static void main(String[] args) {
        int score = 780;

        // تعیین سطح کاربر بر اساس امتیاز.
        if (score >= 1000) {
            System.out.println("VIP");
        } else if (score >= 500) {
            System.out.println("Professional");
        } else if (score >= 100) {
            System.out.println("Normal");
        } else {
            System.out.println("Beginner");
        }

        // شمارش از 1 تا 5.
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
    }
}
```

## مباحث
`if`, `else if`, `else`, `switch`, `for`, `while`, `do-while`, `break`, `continue`.

## تمرین
برنامه‌ای بنویسید که اعداد 1 تا 100 را پیمایش و مجموع اعداد زوج را محاسبه کند.
