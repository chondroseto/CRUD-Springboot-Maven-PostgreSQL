package com.enigmacamp.learnspring.service;

import com.enigmacamp.learnspring.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProduct();

    Product getById(Integer id);

    String deleteById(Integer id);

    Page<Product> getProductPerPage(Pageable pageable);

    List<Product> getProductsByName(String productName);

}
