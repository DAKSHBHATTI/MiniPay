import java.math.BigDecimal;

public interface PaymentProcessor {
    boolean processPayment(long fromAccountId, long toAccountId, BigDecimal amount);
    boolean refundPayment(long transactionId);
    String getProcessorName();
}