package academy.as.store.invoice;

import java.time.Instant;

/** Invoice یک Snapshot مالی از سفارش است و مبلغ آن بعد از صدور نباید تغییر کند. */
public record Invoice(String number, Long orderId, long totalAmount, Instant issuedAt) {
    public Invoice {
        if (number == null || number.isBlank()) throw new IllegalArgumentException("number");
        if (orderId == null) throw new IllegalArgumentException("orderId");
        if (totalAmount < 0) throw new IllegalArgumentException("totalAmount");
        if (issuedAt == null) throw new IllegalArgumentException("issuedAt");
    }
}
