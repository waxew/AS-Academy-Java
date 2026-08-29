package academy.as.store.payment;

import java.util.UUID;
import org.springframework.stereotype.Component;

/** Adapter آزمایشی؛ هیچ پرداخت واقعی انجام نمی‌دهد. */
@Component
public class FakePaymentGateway implements PaymentGateway {
    @Override
    public PaymentResult pay(long amount, String reference) {
        if (amount <= 0) return new PaymentResult(false, null);
        return new PaymentResult(true, "TEST-" + UUID.randomUUID());
    }
}
