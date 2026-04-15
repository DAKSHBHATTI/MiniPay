import java.math.BigDecimal;
public class Main {
    public static void main(String[] args){
        User u1=new User(1001,"daksh","bhattidkash12@gmail.com");
        User u2=new User(1002,"priya","priya12@gmail.com");
        System.out.println(u1);
        System.out.println(u2);
        u1.setActive(false);
        System.out.println(u1);
//Account a1=new Account(1001,u1,"INR");
//a1.deposit(new BigDecimal("1000.00"));
//a1.withdraw(new BigDecimal("250.00"));
//System.out.println(a1);
//a1.withdraw(new BigDecimal("900.00"));
//        System.out.println(a1.toString());
//        Transaction t1=new Transaction(341, a1.getAccountId(),TransactionType.DEBIT,new BigDecimal("250.00"),"Payment to Priya","2024-01-15 10:30:00");
//        Transaction t2=new Transaction(342, a1.getAccountId(),TransactionType.CREDIT,new BigDecimal("1000.00"),"Received from Rahul","2024-01-15 10:30:00");
// System.out.println(t1);
//        System.out.println(t2);
        SavingsAccount sa = new SavingsAccount(2001, u1, "INR", new BigDecimal("500.00"));
        CurrentAccount ca = new CurrentAccount(2002, u2, "INR", new BigDecimal("1000.00"));
sa.deposit(new BigDecimal("3000.00"));
sa.withdraw(new BigDecimal("2600.00"));
        sa.withdraw(new BigDecimal("2000.00"));
        System.out.println(sa);
        ca.deposit((new BigDecimal("1000.00")));
        ca.withdraw(new BigDecimal("1800.00"));
        ca.withdraw(new BigDecimal("300.00"));
        System.out.println(ca);
    }
}
