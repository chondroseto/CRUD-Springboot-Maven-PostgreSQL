package com.enigmacamp.learnspring.service.impl;

import com.enigmacamp.learnspring.exception.NotFoundException;
import com.enigmacamp.learnspring.model.Customers;
import com.enigmacamp.learnspring.repository.CustomersRepository;
import com.enigmacamp.learnspring.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    CustomersRepository customerSRepository;

    @Override
    public Customers createCustomer(Customers customers) {
        if(customers.getId() != null){
            getCustomerById(customers.getId());
        }
        return customerSRepository.save(customers);
    }

    @Override
    public Customers getCustomerById(Integer id) {
        Optional<Customers> customers = customerSRepository.findById(id);
        if(customers.isPresent()){
            return customers.get();
        }else{
            throw new NotFoundException("Customer is not found");
        }
    }

    @Override
    public List<Customers> getAllCustomers() {
        return customerSRepository.findAll();
    }

    @Override
    public String deleteCustomerById(Integer id) {
        Customers customers = getCustomerById(id);
        customerSRepository.deleteById(customers.getId());
        return "Success delete customer id = " + id +"";
    }
}
