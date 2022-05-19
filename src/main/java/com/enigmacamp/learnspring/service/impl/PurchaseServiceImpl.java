package com.enigmacamp.learnspring.service.impl;

import com.enigmacamp.learnspring.exception.NotFoundException;
import com.enigmacamp.learnspring.model.Customers;
import com.enigmacamp.learnspring.model.Product;
import com.enigmacamp.learnspring.model.Purchase;
import com.enigmacamp.learnspring.repository.PurchaseRepository;
import com.enigmacamp.learnspring.request.TransactionRequest;
import com.enigmacamp.learnspring.service.CustomersService;
import com.enigmacamp.learnspring.service.ProductService;
import com.enigmacamp.learnspring.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import javax.transaction.Transactional;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    ProductService productService;

    @Autowired
    CustomersService customersService;

    @Override
    public Purchase transaction(TransactionRequest transactionRequest) {

        /**
         * jumlah pembelian harus kurang dari jumlah stock barang
         * stok barang berkurang ketika pembelian berhasil
         */

         // idcustomer
        Customers customers = customersService.getCustomerById(transactionRequest.getCustomerId());
        Product product = productService.getById(transactionRequest.getProductId());
        Purchase purchase = new Purchase();
        purchase.setCustomers(customers);
        purchase.setProduct(product);
        purchase.setQty(transactionRequest.getQty());
        if(product.getQty() < purchase.getQty()){
            throw new NotFoundException("Stock barang habis");
        }else{
            int lastStock = product.getQty() - purchase.getQty();
            product.setQty(lastStock);
            productService.createProduct(product);
        }
        int lastTotalPurchase = product.getPrice() * purchase.getQty();
        purchase.setTotalPrice(lastTotalPurchase);
        return purchaseRepository.save(purchase);
    }
}
