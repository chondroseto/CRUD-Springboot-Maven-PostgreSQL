package com.enigmacamp.learnspring.service;

import com.enigmacamp.learnspring.model.Purchase;
import com.enigmacamp.learnspring.request.TransactionRequest;

public interface PurchaseService {
    Purchase transaction(TransactionRequest transactionRequest);
}
