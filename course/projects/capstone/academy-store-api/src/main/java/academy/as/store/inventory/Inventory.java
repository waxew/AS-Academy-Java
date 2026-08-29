package academy.as.store.inventory;

import academy.as.store.product.Product;
import jakarta.persistence.*;

/** موجودی هر Product را نگهداری می‌کند و اجازه موجودی منفی نمی‌دهد. */
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", unique = true, nullable = false)
    private Product product;
    @Column(nullable = false)
    private int quantity;

    protected Inventory() { }
    public Inventory(Product product, int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.product = product;
        this.quantity = quantity;
    }
    public int getQuantity() { return quantity; }
    public void decrease(int amount) {
        if (amount <= 0 || amount > quantity) throw new IllegalArgumentException("Insufficient inventory");
        quantity -= amount;
    }
}
