package com.eazybytes.eazystore.repository;

import com.eazybytes.eazystore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}