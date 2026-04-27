package com.minipay.service;

import com.minipay.exception.InvalidTransactionException;
import com.minipay.model.Account;
import com.minipay.model.Transaction;
import com.minipay.model.TransactionType;
import com.minipay.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
@Service
public class PaymentService {

    // fields
    private Map<Long, User> users;
    private Map<Long, Account> accounts;
    private List<Transaction> transactions;
    private long transactionCounter;

    // constructor — initialise with empty collections
    public PaymentService() {
        this.users = new HashMap<>();
        this.accounts = new HashMap<>();
        this.transactions = new ArrayList<>();
        this.transactionCounter = 1;
    }
    public void registerUser(User user){
        users.put(user.getUserId(),user);
    }
    public void addAccount(Account account){
        accounts.put(account.getAccountId(),account);
    }
    public void transferMoney(long fromAccountId, long toAccountId, BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTransactionException(
                    "Transfer amount must be positive, received: " + amount
            );
        }


        if (fromAccountId == toAccountId) {
            throw new InvalidTransactionException(
                    "Cannot transfer to the same account: " + fromAccountId
            );
        }
        Account fromAccount=Optional.ofNullable(accounts.get(fromAccountId)).orElseThrow(()->new InvalidTransactionException("Account not found: " + fromAccountId));
        // Also apply Optional to toAccount
        Account toAccount = Optional.ofNullable(accounts.get(toAccountId))
                .orElseThrow(() -> new InvalidTransactionException(
                        "Account not found: " + toAccountId));

        // TODO: wrap in @Transactional in Phase 3 — if deposit fails after withdraw,
// the entire operation must roll back to prevent money loss
        // Then use the variables directly
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        Transaction t1=new Transaction(transactionCounter,fromAccountId, TransactionType.DEBIT,amount,"Transfer to account " + toAccountId,"20-4-26" );
        Transaction t2=new Transaction(transactionCounter+1,toAccountId, TransactionType.CREDIT,amount,"Transfer from account " + fromAccountId,"20-4-26");
transactions.add(t1);
transactions.add(t2);
transactionCounter+=2;
System.out.println("Transfer successful: " + amount + " from account " + fromAccountId + " to " + toAccountId);

    }
    public List<Transaction> getTransactionHistory(long accountId){
       return transactions.stream().filter(t->t.getAccountId()==accountId).collect(Collectors.toList());
    }
    public List<Transaction> getDebitTransactions(long accountId){
        return transactions.stream().filter(t->t.getAccountId()==accountId&&t.getType()==TransactionType.DEBIT).collect(Collectors.toList());
    }
    public BigDecimal getTotalSpent(long accountID){
return transactions.stream().filter(t->t.getAccountId()==accountID&&t.getType()==TransactionType.DEBIT).map(Transaction::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
    }
    public Optional<Transaction> findTransaction(long transactionId){
return transactions.stream().filter(t->t.getTransactionId()==transactionId).findFirst();
    }
    public void printAllTransactions(){
        transactions.forEach(System.out::println);
    }
    public BigDecimal getBalance(long accountId){
       return Optional.ofNullable(accounts.get(accountId)).orElseThrow(()->new InvalidTransactionException( "Account not found: " + accountId)).getBalance();
    }


}
