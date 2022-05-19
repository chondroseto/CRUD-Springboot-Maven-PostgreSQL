package com.enigmacamp.learnspring.service.impl;

import com.enigmacamp.learnspring.exception.NotFoundException;
import com.enigmacamp.learnspring.model.Product;
import com.enigmacamp.learnspring.repository.ProductRepository;
import com.enigmacamp.learnspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        if(product.getId() !=null){
            getById(product.getId());
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }else{
            throw new NotFoundException("Product is not found");
        }
    }

    @Override
    public String deleteById(Integer id) {
        Product product = getById(id);
        productRepository.deleteById(product.getId());
        return "Deleted is Success";
    }

    @Override
    public Page<Product> getProductPerPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> getProductsByName(String productName) {
        return productRepository.findByNameLike(productName);
    }
}
