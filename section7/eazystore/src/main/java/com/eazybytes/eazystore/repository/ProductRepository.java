package com.eazybytes.eazystore.repository;

import com.eazybytes.eazystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Product is Product class in entity. Long is product id data type
//Jpa Repository will handle all queries for database transformed into java methods
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
