package academy.as.store.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import academy.as.store.product.Product;
import academy.as.store.user.AppUser;
import academy.as.store.user.Role;
import org.junit.jupiter.api.Test;

/** Unit Test Aggregate سفارش و قوانین وضعیت آن. */
class CustomerOrderTest {
    @Test
    void calculatesTotalAndMarksPaid() {
        AppUser user = new AppUser("buyer@example.com", "hash", Role.CUSTOMER);
        Product product = new Product("Java Book", 500_000);
        CustomerOrder order = new CustomerOrder(user);
        order.addItem(new OrderItem(product, 2, product.getPrice()));

        assertEquals(1_000_000L, order.total());
        order.markPaid();
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void emptyOrderCannotBePaid() {
        CustomerOrder order = new CustomerOrder(new AppUser("buyer@example.com", "hash", Role.CUSTOMER));
        assertThrows(IllegalStateException.class, order::markPaid);
    }
}
