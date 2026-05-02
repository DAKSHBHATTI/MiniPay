package com.minipay.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private long fromAccountId;
    private long toAccountId;
    private BigDecimal amount;
}
