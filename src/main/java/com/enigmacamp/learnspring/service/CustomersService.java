package com.enigmacamp.learnspring.service;

import com.enigmacamp.learnspring.model.Customers;

import java.util.List;

public interface CustomersService {
    Customers getCustomerById(Integer id);

    List<Customers> getAllCustomers();

    Customers createCustomer(Customers customers);

    String deleteCustomerById(Integer id);

}
