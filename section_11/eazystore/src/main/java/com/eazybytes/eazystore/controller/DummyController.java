package com.eazybytes.eazystore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

    /* can't use default value in pathVariable
    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable(name = "userId") String id) {
            System.out.print(id);
            return "Searching for user: " + id;
    }
    */

    @GetMapping({"/user/{userId}/posts/{postId}", "/user/{userId}"})
    public String getUserMultiplePath(
        @PathVariable(name = "userId") String id,
        @PathVariable(required = false) String postId) {
            String actualId = id + " and post: " + postId;
            System.out.print(actualId);
            return "Searching for user: " + actualId;
    }

    @GetMapping({"/user/map/{userId}/posts/{postId}", "/user/map/{userId}"})
    public String getUserWithMap(@PathVariable Map<String,String> pathVariables) {
            String actualId = pathVariables.get("userId") + " and post: " + pathVariables.get("postId");
            System.out.print(actualId);
            return "Searching for user: " + actualId;
    }

    @GetMapping("/headers")
    public String readHeaders(
        @RequestHeader(name = "User-Agent") String userAgent,
        @RequestHeader(name = "User-Location", required = false) String userLocation) {
            String actualHeaders = userAgent + ", " + userLocation;
            System.out.print(actualHeaders);
            return "Received headers with value: " + actualHeaders;
    }

    @GetMapping("/headers-map")
    public String readHeadersWithMap(@RequestHeader Map<String,String> headers) {
            String actualHeaders = headers.toString();
            System.out.print(actualHeaders);
            return "Received headers with value: " + actualHeaders;
    }

    @GetMapping("/headers-http")
    public String readHeadersWithMap(@RequestHeader HttpHeaders headers) {
    // public String readHeadersWithMap(@RequestHeader HttpServletRequest headers) {
        // String location = headers.getHeader("User-Location");
        List<String> location = headers.get("User-Location");
        System.out.print(location);
        return "Received headers with value: " + location;
    }

    @PostMapping("/request-entity")
    public String createUserWithEntity(RequestEntity<UserDto> requestEntity) {
        HttpHeaders header = requestEntity.getHeaders(); //RequestHeader is better approach
        UserDto userDto = requestEntity.getBody(); //RequestBody is better approach
        String queryString = requestEntity.getUrl().getQuery(); //RequestParam is better approach
        String path = requestEntity.getUrl().getPath(); //PathVariable is better approach
        return "User created successfully";
    }
}
