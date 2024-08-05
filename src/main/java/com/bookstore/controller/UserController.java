package com.bookstore.controller;

import com.bookstore.common.APIResponse;
import com.bookstore.dto.LoginRequestDto;
import com.bookstore.dto.SignupRequestDto;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<APIResponse> signup(@RequestBody SignupRequestDto signupRequestDto) {
        APIResponse apiResponse = userService.signUpUser(signupRequestDto);
        return  ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }

    @GetMapping("/user")
    public ResponseEntity<APIResponse> getUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> loginUser(@RequestBody  LoginRequestDto loginRequestDto){
        APIResponse apiResponse = userService.checkLoginDetails(loginRequestDto);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

}
