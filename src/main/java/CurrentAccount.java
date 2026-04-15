import java.math.BigDecimal;

public class CurrentAccount extends Account{
    private BigDecimal overdraftLimit;
    public CurrentAccount(long accountId,User owner,String currency,BigDecimal overdraftLimit){
        super(accountId, owner, currency);
        this.overdraftLimit=overdraftLimit;
    }
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Invalid Withdrawal Amount");
            return;
        }
        if (getBalance().subtract(amount).compareTo(overdraftLimit.negate()) < 0) {
            System.out.println("Overdraft limit exceeded");
            return;
        }
        setBalance(getBalance().subtract(amount));
    }
    public BigDecimal getOverdraftLimit(){
        return overdraftLimit;
    }

    @Override
    public String toString() {
        return super.toString()+" Overdraft limit: "+overdraftLimit;
    }
}
