package academy.as.store.order;

import academy.as.store.product.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/** یک قلم سفارش؛ قیمت لحظه خرید را مستقل از تغییرات بعدی Product نگه می‌دارد. */
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    private long unitPrice;

    protected OrderItem() { }

    public OrderItem(Product product, int quantity, long unitPrice) {
        if (product == null) throw new IllegalArgumentException("product");
        if (quantity <= 0) throw new IllegalArgumentException("quantity");
        if (unitPrice < 0) throw new IllegalArgumentException("unitPrice");
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public long total() { return unitPrice * quantity; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public long getUnitPrice() { return unitPrice; }
}
