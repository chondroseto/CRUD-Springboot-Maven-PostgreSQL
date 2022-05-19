package com.enigmacamp.learnspring.controller;

import com.enigmacamp.learnspring.model.Customers;
import com.enigmacamp.learnspring.service.CustomersService;
import com.enigmacamp.learnspring.util.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    CustomersService customersService;

    @GetMapping("/{id}")
    public ResponseEntity<WebResponse<Customers>> getCustomerById(@PathVariable Integer id){
        Customers customers = customersService.getCustomerById(id);
        return ResponseEntity.ok().body(new WebResponse(String.format("Customers with id = %d is found",customers.getId()),customers));
    }

    @GetMapping
    public ResponseEntity<WebResponse<List<Customers>>> getAllCustomers(){
        return ResponseEntity.ok().body(new WebResponse("get all customers is Successfully",customersService.getAllCustomers()));
    }

    @PostMapping
    public ResponseEntity<WebResponse<Customers>> createCustomer(@RequestBody Customers customers){
        return ResponseEntity.ok().body(new WebResponse("Create a new customers is Successfully",customersService.createCustomer(customers)));
    }

    @PutMapping
    public ResponseEntity<WebResponse<Customers>> updateCustomers(@RequestBody Customers customers){
        return ResponseEntity.ok().body(new WebResponse("Update customers is Successfully",customersService.createCustomer(customers)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WebResponse<String>> deleteCustomerById(@PathVariable Integer id){
        customersService.deleteCustomerById(id);
        return ResponseEntity.ok().body(new WebResponse("Delete customers is Successfully",null));
    }

}
