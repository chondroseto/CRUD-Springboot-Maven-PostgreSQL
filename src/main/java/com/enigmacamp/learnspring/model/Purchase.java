package com.enigmacamp.learnspring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trx_purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Customers.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customers customers;

    @ManyToOne(targetEntity = Product.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private Integer qty;

    private Integer totalPrice;

    @CreatedDate
    @Column(updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss a",timezone = "Asia/Jakarta")
    private Date createdAt;

    @PrePersist
    private void createdDate(){
        if(this.createdAt == null) this.createdAt = new Date();
    }

    public Purchase(Integer id, Customers customers, Product product, Integer qty, Integer totalPrice, Date createdAt) {
        this.id = id;
        this.customers = customers;
        this.product = product;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
    }

    public Purchase(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
