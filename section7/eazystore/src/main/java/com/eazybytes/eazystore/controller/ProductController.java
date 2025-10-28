package com.eazybytes.eazystore.controller;

import com.eazybytes.eazystore.entity.Product;
import com.eazybytes.eazystore.repository.ProductRepository;
import com.eazybytes.eazystore.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService iProductService;

//    private final ProductRepository productRepository; //using repository interface in section 121-122

    /* this constructor is not needed if you already use @RequiredArgsConstructor from lombok library

    //Mentioning @Autowired is optional if a class is only have one constructor
    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    */

    @GetMapping
    public List<Product> getProducts() {
        // In Memory Database: H2 DB (don't need to install any software, testing purposes only in dev environment)
        // Database Example: MySQL, Oracle, Postgres

//        List<Product> productList = productRepository.findAll(); //using repository interface in section 121-122

        List<Product> productList = iProductService.getProducts();
        return productList;
    }
}
