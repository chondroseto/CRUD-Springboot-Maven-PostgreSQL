package com.enigmacamp.learnspring.repository;

import com.enigmacamp.learnspring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> findByNameLike(String productName);
}
