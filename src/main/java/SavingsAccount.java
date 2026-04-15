import java.math.BigDecimal;

public class SavingsAccount extends Account {
    private BigDecimal minimumBalance;
    public SavingsAccount(long accountId,User owner,String currency,BigDecimal minimumBalance){
        super(accountId, owner, currency);
        this.minimumBalance=minimumBalance;
    }
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Invalid Withdrawal Amount");
            return;
        }
        if ((getBalance().subtract(amount)).compareTo(minimumBalance) < 0) {
            System.out.println("Cannot withdraw - minimum balance must be maintained");
            return;
        }
        setBalance(getBalance().subtract(amount));
    }
public BigDecimal getMinimumBalance(){
        return minimumBalance;
}
@Override
    public String toString(){
        return "Account details: Account Id-"+ getAccountId()+" Userdetails- "+getOwner().getName()+" Balance- "+getBalance()+" Currency- "+getCurrency()+" Minimum Balance- "+getMinimumBalance();

    }
}
