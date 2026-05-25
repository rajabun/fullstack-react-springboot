package com.eazybytes.eazystore.controller;

import com.eazybytes.eazystore.dto.ProductDto;
import com.eazybytes.eazystore.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
//@CrossOrigin(origins = "http://localhost:5173") 1st way to fix cors error
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final IProductService iProductService;

    //Using @Slf4j, this variable is not need to create manually
    //private static final Logger log = LoggerFactory.getLogger(ProductController.class);

//    private final ProductRepository productRepository; //using repository interface in section 121-122

    /* this constructor is not needed if you already use @RequiredArgsConstructor from lombok library

    //Mentioning @Autowired is optional if a class is only have one constructor
    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    */

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() throws InterruptedException { //DTO Pattern
        // In Memory Database: H2 DB (don't need to install any software, testing purposes only in dev environment)
        // Database Example: MySQL, Oracle, Postgres

//        List<Product> productList = productRepository.findAll(); //using repository interface in section 121-122

        System.out.println("Hello Products API");
        List<ProductDto> productList = iProductService.getProducts();
        System.out.print("Testing code changes dev tools");

        log.trace("Very detailed trace log");
        log.debug("Debug message");
        log.info("Informational Message, default value of log");
        log.warn("Warning. Something might go wrong");
        log.error("An error occurred. Needs immediate attention");

        return ResponseEntity.ok(productList);
    }
}
