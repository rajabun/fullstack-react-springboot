package com.eazybytes.eazystore.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.eazystore.dto.UserDto;

@RestController
@RequestMapping("api/v1/dummy")
public class DummyController {

    @PostMapping("/create-user")
    public String createUser(@RequestBody UserDto userDto) {
        System.out.print(userDto);
        return "User created successfully";
    }

    @GetMapping("/search")
    public String searchUser(
        @RequestParam(
        required = false,
        defaultValue = "Guest",
        name = "name")
        String userName) {
            System.out.print(userName);
            return "Searching for user: " + userName;
    }

    @GetMapping("/multiple-search")
    public String multipleSearch(
        @RequestParam String firstName,
        @RequestParam String lastName) {
            String actualName = firstName + " " + lastName;
            System.out.print(actualName);
            return "Searching for user: " + actualName;
    }

    @GetMapping("/multiple-search-map")
    public String multipleSearchWithMap(@RequestParam Map<String,String> params) {
            String actualName = params.get("firstName") + " " + params.get("lastName") + " Map";
            System.out.print(actualName);
            return "Searching for user: " + actualName;
    }

}
