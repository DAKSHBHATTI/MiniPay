import java.math.BigDecimal;
public class Account {
    private long accountId;
    private User owner;
    private BigDecimal balance;
    private String currency;
    public Account(long accountId,User owner,String currency){
        this.accountId=accountId;
        this.owner=owner;
        this.currency=currency;
        this.balance=new BigDecimal("0.00");
    }
    public long getAccountId(){
        return accountId;
    }
    public User getOwner(){
        return owner;
    }
    public BigDecimal getBalance(){
        return balance;
    }
    public String getCurrency(){
        return currency;
    }
    public void deposit(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO)<=0) {
            throw new InvalidTransactionException("Deposit amount must be positive, received: " + amount);
        }
         balance=balance.add(amount);
    }
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTransactionException("Withdrawal amount must be positive,received: "+amount);
        }
        if (balance.compareTo(amount) < 0) {
           throw new InsufficientBalanceException("Insufficient balance: have " + balance + ", need " + amount);
        }
       balance= balance.subtract(amount);
    }
    protected void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    @Override
    public String toString(){
        return "Account details: Account Id-"+ accountId+" Userdetails- "+owner.getName()+" Balance- "+balance+" Currency- "+currency;

    }



}
