package academy.as.grade;

import java.util.Arrays;

/**
 * پروژه پایان سطح مبانی.
 * این کلاس Array، Loop، Method و محاسبات پایه را در یک مسئله واقعی تمرین می‌کند.
 */
public final class Main {
    private Main() { }

    public static void main(String[] args) {
        // داده نمونه برای اجرای سریع پروژه بدون نیاز به ورودی خارجی.
        int[] scores = {18, 14, 20, 11, 17};

        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println("Min: " + min(scores));
        System.out.println("Max: " + max(scores));
        System.out.println("Average: " + average(scores));
        System.out.println("Passed: " + passedCount(scores, 10));
    }

    static int min(int[] values) {
        int min = values[0];
        for (int value : values) {
            if (value < min) min = value;
        }
        return min;
    }

    static int max(int[] values) {
        int max = values[0];
        for (int value : values) {
            if (value > max) max = value;
        }
        return max;
    }

    static double average(int[] values) {
        int sum = 0;
        for (int value : values) sum += value;
        return (double) sum / values.length;
    }

    static int passedCount(int[] values, int passScore) {
        int count = 0;
        for (int value : values) {
            if (value >= passScore) count++;
        }
        return count;
    }
}
