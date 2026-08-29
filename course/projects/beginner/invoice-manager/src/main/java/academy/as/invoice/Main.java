package academy.as.invoice;

import java.util.ArrayList;
import java.util.List;

/** پروژه پایان سطح مقدماتی برای تمرین OOP و Collection. */
public final class Main {
    private Main() { }

    public static void main(String[] args) {
        Product keyboard = new Product(1, "Keyboard", 2_500_000);
        Product mouse = new Product(2, "Mouse", 1_200_000);

        Invoice invoice = new Invoice();
        invoice.add(new InvoiceItem(keyboard, 1));
        invoice.add(new InvoiceItem(mouse, 2));

        for (InvoiceItem item : invoice.items()) {
            System.out.printf("%s x%d = %,d%n", item.product().name(), item.quantity(), item.total());
        }
        System.out.printf("Total: %,d%n", invoice.total());
    }

    record Product(long id, String name, long unitPrice) {
        Product {
            if (id <= 0) throw new IllegalArgumentException("id");
            if (name == null || name.isBlank()) throw new IllegalArgumentException("name");
            if (unitPrice < 0) throw new IllegalArgumentException("unitPrice");
        }
    }

    record InvoiceItem(Product product, int quantity) {
        InvoiceItem {
            if (product == null) throw new IllegalArgumentException("product");
            if (quantity <= 0) throw new IllegalArgumentException("quantity");
        }

        long total() {
            return product.unitPrice() * quantity;
        }
    }

    static final class Invoice {
        private final List<InvoiceItem> items = new ArrayList<>();

        void add(InvoiceItem item) {
            items.add(item);
        }

        List<InvoiceItem> items() {
            return List.copyOf(items);
        }

        long total() {
            return items.stream().mapToLong(InvoiceItem::total).sum();
        }
    }
}
