package academy.as.invoice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** تست‌های مرجع پروژه Invoice Manager. */
class MainTest {

    @Test
    void calculatesInvoiceTotal() {
        Main.Product keyboard = new Main.Product(1, "Keyboard", 2_500_000);
        Main.Product mouse = new Main.Product(2, "Mouse", 1_200_000);

        Main.Invoice invoice = new Main.Invoice();
        invoice.add(new Main.InvoiceItem(keyboard, 1));
        invoice.add(new Main.InvoiceItem(mouse, 2));

        assertEquals(4_900_000L, invoice.total());
    }

    @Test
    void rejectsInvalidQuantity() {
        Main.Product product = new Main.Product(1, "Keyboard", 2_500_000);
        assertThrows(IllegalArgumentException.class, () -> new Main.InvoiceItem(product, 0));
    }

    @Test
    void rejectsNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new Main.Product(1, "Bad", -1));
    }
}
