package academy.as.store.product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository استاندارد Spring Data برای Product.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
