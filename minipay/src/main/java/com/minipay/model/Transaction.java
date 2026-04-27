package com.minipay.model;

import java.math.BigDecimal;

public class Transaction {
    private long transactionId;
    private long accountId;
    private TransactionType type;
private BigDecimal amount;
private String description;
private String timestamp;

public Transaction(long transactionId, long accountId, TransactionType type, BigDecimal amount, String description, String timestamp){
    this.transactionId=transactionId;
    this.amount=amount;
    this.type=type;
    this.description=description;
    this.accountId=accountId;
    this.timestamp=timestamp;
}
public long getTransactionId(){
    return transactionId;
}
public long getAccountId(){
    return accountId;
}
public String getDescription(){
    return description;
}
    public String getTimestamp(){
        return timestamp;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    @Override
    public String toString(){
    return "Transaction{" +
            "transactionId=" + transactionId +
            ", accountId=" + accountId +
            ", amount=" + amount +
            ", type=" + type +
            ", description='" + description + '\'' +
            ", timestamp='" + timestamp + '\'' +
            '}';
    }

}
