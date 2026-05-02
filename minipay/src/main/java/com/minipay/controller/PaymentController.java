package com.minipay.controller;

import com.minipay.dto.TransferRequest;
import com.minipay.exception.InsufficientBalanceException;
import com.minipay.exception.InvalidTransactionException;
import com.minipay.model.Transaction;
import com.minipay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
@Autowired
    private PaymentService paymentService;
@PostMapping("/transfer")
    public ResponseEntity<String>transferMoney(@RequestBody TransferRequest request){
    try{
        paymentService.transferMoney(request.getFromAccountId(), request.getToAccountId(), request.getAmount());
        return ResponseEntity.ok("Transfer Successful");
    }
    catch(InsufficientBalanceException  | InvalidTransactionException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
    @GetMapping("/history/{accountId}")
    public ResponseEntity<List<Transaction>>getTransactionHistory(@PathVariable  long accountId){
    List<Transaction>transactionList=paymentService.getTransactionHistory(accountId);
    return ResponseEntity.ok(transactionList);
    }
}
