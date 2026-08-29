package academy.as.store.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Use caseهای مرتبط با Product در Service نگه داشته می‌شوند.
 */
@Service
@Transactional
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        // Constructor Injection وابستگی را صریح و قابل Test می‌کند.
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product create(String name, long price) {
        Product product = new Product(name, price);
        return repository.save(product);
    }
}
