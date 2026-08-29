package academy.as.store.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/** Unit Test قوانین سبد خرید بدون Spring و Database. */
class CartTest {
    @Test
    void addsAndClearsItems() {
        Cart cart = new Cart();
        cart.add(10L, 2);
        assertEquals(1, cart.items().size());
        assertEquals(2, cart.items().getFirst().quantity());
        cart.clear();
        assertTrue(cart.isEmpty());
    }

    @Test
    void rejectsInvalidQuantity() {
        Cart cart = new Cart();
        assertThrows(IllegalArgumentException.class, () -> cart.add(10L, 0));
    }
}
