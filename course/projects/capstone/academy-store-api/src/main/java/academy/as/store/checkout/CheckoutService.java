package academy.as.store.checkout;

import java.time.Instant;
import java.util.UUID;
import academy.as.store.cart.Cart;
import academy.as.store.inventory.Inventory;
import academy.as.store.inventory.InventoryRepository;
import academy.as.store.invoice.Invoice;
import academy.as.store.order.CustomerOrder;
import academy.as.store.order.CustomerOrderRepository;
import academy.as.store.order.OrderItem;
import academy.as.store.payment.PaymentGateway;
import academy.as.store.product.Product;
import academy.as.store.product.ProductRepository;
import academy.as.store.user.AppUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Application Service جریان خرید.
 * همه تغییرات Database در یک Transaction انجام می‌شوند تا سفارش و موجودی ناسازگار نشوند.
 */
@Service
public class CheckoutService {
    private final ProductRepository products;
    private final InventoryRepository inventory;
    private final CustomerOrderRepository orders;
    private final PaymentGateway payments;

    public CheckoutService(ProductRepository products, InventoryRepository inventory,
                           CustomerOrderRepository orders, PaymentGateway payments) {
        this.products = products;
        this.inventory = inventory;
        this.orders = orders;
        this.payments = payments;
    }

    @Transactional
    public CheckoutResult checkout(AppUser customer, Cart cart) {
        if (cart == null || cart.isEmpty()) throw new IllegalArgumentException("Cart is empty");

        CustomerOrder order = new CustomerOrder(customer);
        for (Cart.CartItem cartItem : cart.items()) {
            Product product = products.findById(cartItem.productId())
                    .orElseThrow(() -> new IllegalArgumentException("Product not found"));
            Inventory stock = inventory.findByProductId(product.getId())
                    .orElseThrow(() -> new IllegalStateException("Inventory not found"));

            stock.decrease(cartItem.quantity());
            order.addItem(new OrderItem(product, cartItem.quantity(), product.getPrice()));
        }

        long total = order.total();
        PaymentGateway.PaymentResult payment = payments.pay(total, "ORDER-" + UUID.randomUUID());
        if (!payment.successful()) throw new IllegalStateException("Payment failed");

        order.markPaid();
        CustomerOrder saved = orders.save(order);
        Invoice invoice = new Invoice("INV-" + UUID.randomUUID(), saved.getId(), total, Instant.now());
        cart.clear();
        return new CheckoutResult(saved.getId(), payment.transactionId(), invoice);
    }

    public record CheckoutResult(Long orderId, String transactionId, Invoice invoice) { }
}
