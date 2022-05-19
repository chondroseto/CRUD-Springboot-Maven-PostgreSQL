package com.enigmacamp.learnspring.repository;

import com.enigmacamp.learnspring.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers,Integer> {
}
