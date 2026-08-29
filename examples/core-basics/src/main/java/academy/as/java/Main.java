package academy.as.java;

/**
 * نمونه اجرایی مبانی Java برای AS Academy.
 * تمام منطق عمداً ساده نگه داشته شده تا هنرجو جریان برنامه را دنبال کند.
 */
public final class Main {

    private Main() {
        // جلوگیری از ساخت نمونه از کلاس utility.
    }

    public static void main(String[] args) {
        // ورودی نمونه برای محاسبه مبلغ نهایی.
        long unitPrice = 125_000L;
        int quantity = 3;
        double discountPercent = 10.0;

        // مبلغ قبل از تخفیف.
        long subtotal = unitPrice * quantity;

        // مقدار تخفیف.
        long discount = Math.round(subtotal * discountPercent / 100.0);

        // مبلغ نهایی.
        long finalPrice = subtotal - discount;

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Final: " + finalPrice);
    }
}
