package academy.as.store.cart;

import java.util.ArrayList;
import java.util.List;

/** مدل دامنه ساده سبد خرید برای تمرین Collection و Business Rules. */
public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void add(Long productId, int quantity) {
        if (productId == null) throw new IllegalArgumentException("productId");
        if (quantity <= 0) throw new IllegalArgumentException("quantity");
        items.add(new CartItem(productId, quantity));
    }

    public List<CartItem> items() { return List.copyOf(items); }
    public boolean isEmpty() { return items.isEmpty(); }
    public void clear() { items.clear(); }

    public record CartItem(Long productId, int quantity) { }
}
