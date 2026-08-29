package academy.as.store.inventory;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/** Repository موجودی؛ Checkout موجودی Product را از این درگاه دریافت می‌کند. */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByProductId(Long productId);
}
