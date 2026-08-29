package academy.as.store.payment;

/**
 * Port پرداخت در معماری Dependency Inversion.
 * پروژه آموزشی به درگاه بانکی واقعی وابسته نمی‌شود و Adapter می‌تواند بعداً جایگزین شود.
 */
public interface PaymentGateway {
    PaymentResult pay(long amount, String reference);

    record PaymentResult(boolean successful, String transactionId) { }
}
