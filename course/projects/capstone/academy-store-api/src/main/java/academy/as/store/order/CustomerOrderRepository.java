package academy.as.store.order;

import org.springframework.data.jpa.repository.JpaRepository;

/** Repository سفارش‌ها؛ Persistence از Service جدا نگه داشته می‌شود. */
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
