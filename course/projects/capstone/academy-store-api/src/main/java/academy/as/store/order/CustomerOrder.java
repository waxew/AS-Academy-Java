package academy.as.store.order;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import academy.as.store.user.AppUser;
import jakarta.persistence.*;

/** ریشه Aggregate سفارش؛ اقلام و وضعیت سفارش از داخل Aggregate مدیریت می‌شوند. */
@Entity
@Table(name = "customer_orders")
public class CustomerOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AppUser customer;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private OrderStatus status;
    @Column(nullable = false)
    private Instant createdAt;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id", nullable = false)
    private List<OrderItem> items = new ArrayList<>();

    protected CustomerOrder() { }
    public CustomerOrder(AppUser customer) {
        if (customer == null) throw new IllegalArgumentException("customer");
        this.customer = customer;
        this.status = OrderStatus.CREATED;
        this.createdAt = Instant.now();
    }
    public void addItem(OrderItem item) {
        if (status != OrderStatus.CREATED) throw new IllegalStateException("Order is not editable");
        items.add(item);
    }
    public long total() { return items.stream().mapToLong(OrderItem::total).sum(); }
    public void markPaid() {
        if (status != OrderStatus.CREATED || items.isEmpty()) throw new IllegalStateException("Order cannot be paid");
        status = OrderStatus.PAID;
    }
    public void cancel() {
        if (status == OrderStatus.PAID) throw new IllegalStateException("Paid order cannot be cancelled directly");
        status = OrderStatus.CANCELLED;
    }
    public Long getId() { return id; }
    public OrderStatus getStatus() { return status; }
    public List<OrderItem> getItems() { return List.copyOf(items); }
}
