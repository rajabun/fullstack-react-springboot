package com.eazybytes.eazystore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eazybytes.eazystore.service.IPaymentService;
import com.eazybytes.eazystore.dto.PaymentIntentRequestDto;
import com.eazybytes.eazystore.dto.PaymentIntentResponseDto;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final IPaymentService iPaymentService;

    @PostMapping("/create-payment-intent")
    public ResponseEntity<PaymentIntentResponseDto> createPaymentIntent(@RequestBody PaymentIntentRequestDto paymentRequest) {
        // Implement the logic to create a payment intent using Stripe API
        // You can use the Stripe Java library to create the payment intent
        // and return the client secret to the frontend for further processing.
        PaymentIntentResponseDto response = iPaymentService.createPaymentIntent(paymentRequest);
        return ResponseEntity.ok(response);
    }
    

}
