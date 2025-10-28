package com.eazybytes.eazystore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @GetMapping
    public String getProducts() {
        return "Here are your products";
        // In Memory Database: H2 DB (don't need to install any software, testing purposes only in dev environment)
        // Database Example: MySQL, Oracle, Postgres
    }
}
