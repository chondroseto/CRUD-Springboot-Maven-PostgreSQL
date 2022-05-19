package com.enigmacamp.learnspring.request;

import org.springframework.jmx.export.naming.IdentityNamingStrategy;

public class TransactionRequest {
    private Integer customerId;
    private Integer productId;
    private Integer qty;

    public TransactionRequest(Integer customerId, Integer productId, Integer qty) {
        this.customerId = customerId;
        this.productId = productId;
        this.qty = qty;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
