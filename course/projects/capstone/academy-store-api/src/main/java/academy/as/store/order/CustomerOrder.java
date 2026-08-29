package academy.as.store.order;

import java.time.Instant;
import academy.as.store.user.AppUser;
import jakarta.persistence.*;

/** ریشه Aggregate سفارش؛ تغییر وضعیت باید از Methodهای Domain انجام شود. */
@Entity
@Table(name = "customer_orders")
public class CustomerOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AppUser customer;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;
    @Column(nullable = false)
    private Instant createdAt;

    protected CustomerOrder() { }
    public CustomerOrder(AppUser customer) {
        this.customer = customer;
        this.status = OrderStatus.CREATED;
        this.createdAt = Instant.now();
    }
    public void markPaid() {
        if (status != OrderStatus.CREATED) throw new IllegalStateException("Only created order can be paid");
        status = OrderStatus.PAID;
    }
    public void cancel() {
        if (status == OrderStatus.PAID) throw new IllegalStateException("Paid order cannot be cancelled directly");
        status = OrderStatus.CANCELLED;
    }
    public OrderStatus getStatus() { return status; }
}
