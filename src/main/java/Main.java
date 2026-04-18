import java.math.BigDecimal;
public class Main {
    public static void main(String[] args){
//        WalletPaymentProcessor obj=new WalletPaymentProcessor("MiniPayWallet");
//        obj.processPayment(1001,1002,new BigDecimal("2000.00"));
//        System.out.println(obj.generateAuditLog());
//        // This is the powerful part — storing a WalletPaymentProcessor in a PaymentProcessor variable
//        PaymentProcessor processor = new WalletPaymentProcessor("MiniPay-Wallet");
//        processor.processPayment(2001, 2002, new BigDecimal("500.00"));
        User u1=new User(101,"daksh","bhat@gmail.com");
       SavingsAccount sa=new SavingsAccount(1001,u1,"inr",new BigDecimal("5000.00"));
       try{
           sa.withdraw(new BigDecimal("9000.00"));
       }
       catch(InsufficientBalanceException e){
           System.out.println("Caught: "+e.getMessage());

        }
       try{
           sa.deposit(new BigDecimal("-500.00"));
       }
       catch(InvalidTransactionException e){
           System.out.println("Caught: "+e.getMessage());
       }
        try {
            sa.deposit(new BigDecimal("1000.00"));
            System.out.println("Deposit successful. Balance: " + sa.getBalance());
        } catch (InvalidTransactionException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
