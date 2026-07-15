package com.eazybytes.eazystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eazybytes.eazystore.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
