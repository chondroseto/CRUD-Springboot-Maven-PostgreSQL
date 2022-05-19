package com.enigmacamp.learnspring.controller;


import com.enigmacamp.learnspring.model.Product;
import com.enigmacamp.learnspring.service.ProductService;
import com.enigmacamp.learnspring.util.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<WebResponse<Page<Product>>>  getAllProducts(
            @RequestParam(name = "page",defaultValue = "2")Integer page,
            @RequestParam(name = "size",defaultValue = "3")Integer size,
            @RequestParam(name = "sortBy",defaultValue = "name") String sortBy,
            @RequestParam(name = "direction",defaultValue = "ASC") String direction

    ){
//        List<Product> productList = productService.getAllProduct();
        Sort sort = Sort.by(Sort.Direction.fromString(direction),sortBy);
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Product> productPerPage = productService.getProductPerPage(pageable);
        return ResponseEntity.ok().body(new WebResponse<>("Success get All products",productPerPage));
    }

    @PostMapping
    public ResponseEntity<WebResponse<Product>> createNewProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(new WebResponse<>("Create a new Product is successfuly",productService.createProduct(product)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebResponse<Product>> getProductById(@PathVariable Integer id){
        return ResponseEntity.ok().body(new WebResponse<>("Product is found",productService.getById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WebResponse<String>> deleteProductById(@PathVariable Integer id){
        productService.deleteById(id);
        return ResponseEntity.ok().body(new WebResponse<>("Delete Product is Successfuly",null));
    }

    @PutMapping
    public ResponseEntity<WebResponse<Product>> updateProductById(@RequestBody Product product){
        return ResponseEntity.ok().body(new WebResponse<>("Update Product is Successfuly",productService.createProduct(product)));
    }

    @GetMapping("/searchByName")
    public List<Product> searchProductsByName(@RequestParam(name = "name", defaultValue = "")String productName){
        return productService.getProductsByName(productName);
    }

}