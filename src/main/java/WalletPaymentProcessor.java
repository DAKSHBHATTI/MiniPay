import java.math.BigDecimal;

public class WalletPaymentProcessor implements PaymentProcessor, Auditable {
    private String processorName;
   private  long lastTransactionId;

    public WalletPaymentProcessor(String processorName) {
        this.processorName = processorName;
    }

    @Override
    public boolean processPayment(long fromAccountId, long toAccountId, BigDecimal amount) {
        System.out.println("Processing wallet payment of " + amount + " from account " + fromAccountId + " to account " + toAccountId);
        this.lastTransactionId = fromAccountId;
        return true;
    }

    @Override
    public boolean refundPayment(long transactionId) {
        System.out.println("Refunding transaction:"+transactionId);
        return true;
    }
    public String getProcessorName() {
        return processorName;
    }
    @Override
    public String generateAuditLog(){
        return "Audit : Wallet Processor-last transaction: "+ lastTransactionId;
    }

}

