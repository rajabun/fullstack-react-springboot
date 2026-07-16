package com.eazybytes.eazystore.controller;

import com.eazybytes.eazystore.dto.ContactInfoDto;
import com.eazybytes.eazystore.dto.ContactRequestDto;
import com.eazybytes.eazystore.service.IContactService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final IContactService iContactService;
    private final ContactInfoDto contactInfoDto;
    
    @PostMapping
    public ResponseEntity<String> saveContact(@Valid @RequestBody ContactRequestDto contactRequestDto) { //DTO Pattern
        iContactService.saveContact(contactRequestDto);
        // throw new RuntimeException("Oops something bad happened"); //testing global exception handler
        return ResponseEntity.status(HttpStatus.CREATED).body("Request processed successfully");
    }

    @GetMapping
    public ResponseEntity<ContactInfoDto> getContactInfo() {
        return ResponseEntity.ok(contactInfoDto);
    }    
}
