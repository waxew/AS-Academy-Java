package academy.as.store.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import academy.as.store.cart.Cart;
import academy.as.store.inventory.Inventory;
import academy.as.store.inventory.InventoryRepository;
import academy.as.store.payment.PaymentGateway;
import academy.as.store.product.Product;
import academy.as.store.product.ProductRepository;
import academy.as.store.user.AppUser;
import academy.as.store.user.AppUserRepository;
import academy.as.store.user.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/** Integration Test واقعی Checkout با H2 و Transactionهای Spring. */
@SpringBootTest
class CheckoutServiceTest {
    @Autowired CheckoutService checkout;
    @Autowired ProductRepository products;
    @Autowired InventoryRepository inventory;
    @Autowired AppUserRepository users;

    @Test
    void checkoutDecreasesInventoryAndCreatesInvoice() {
        AppUser user = users.save(new AppUser("checkout@example.com", "hash", Role.CUSTOMER));
        Product product = products.save(new Product("Java Course", 700_000));
        inventory.save(new Inventory(product, 5));

        Cart cart = new Cart();
        cart.add(product.getId(), 2);
        CheckoutService.CheckoutResult result = checkout.checkout(user, cart);

        assertEquals(1_400_000L, result.invoice().totalAmount());
        assertEquals(3, inventory.findByProductId(product.getId()).orElseThrow().getQuantity());
        assertTrue(cart.isEmpty());
    }
}
