package com.bookstore.controller;

import com.bookstore.common.APIResponse;
import com.bookstore.common.AccessDeniedException;
import com.bookstore.dto.LoginRequestDto;
import com.bookstore.dto.RequestMeta;
import com.bookstore.dto.SignupRequestDto;
import com.bookstore.service.UserService;
import com.bookstore.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

//    @Autowired
//    JwtUtils jwtUtils;

    @Autowired
    RequestMeta requestMeta;

    @PostMapping("/signup")
    public ResponseEntity<APIResponse> signup(@RequestBody SignupRequestDto signupRequestDto) {
        APIResponse apiResponse = userService.signUpUser(signupRequestDto);
        return  ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }

    @GetMapping("/user")
    public ResponseEntity<APIResponse> getUser() {
        System.out.println(requestMeta.getEmailId());
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> loginUser(@RequestBody  LoginRequestDto loginRequestDto){
        APIResponse apiResponse = userService.checkLoginDetails(loginRequestDto);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @PostMapping("/privateapi")
    public ResponseEntity<APIResponse>
    privateApi(@RequestHeader(value="authorization",defaultValue = "") String auth) {
        APIResponse apiResponse = new APIResponse();

//        jwtUtils.verify(auth);
        apiResponse.setStatus(200);
        apiResponse.setData("called private api");

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

}
