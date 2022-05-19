package com.enigmacamp.learnspring.controller;


import com.enigmacamp.learnspring.model.Purchase;
import com.enigmacamp.learnspring.request.TransactionRequest;
import com.enigmacamp.learnspring.service.PurchaseService;
import com.enigmacamp.learnspring.util.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<WebResponse<Purchase>> createTransaction(@RequestBody TransactionRequest transactionRequest){
        Purchase sendPurchase = purchaseService.transaction(transactionRequest);
        return ResponseEntity.ok().body(new WebResponse("Berhasil Membeli barang",sendPurchase));
    }


}
