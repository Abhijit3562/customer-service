package com.retailbank.customerservice.repository;

import com.retailbank.customerservice.CustomerServiceApplication;
import com.retailbank.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    public Customer findByEmail(String email);

    public boolean existsByEmail(String email);

}
