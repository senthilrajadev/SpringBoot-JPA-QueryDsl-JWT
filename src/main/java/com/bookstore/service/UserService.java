package com.bookstore.service;

import com.bookstore.common.APIResponse;
import com.bookstore.dto.LoginRequestDto;
import com.bookstore.dto.SignupRequestDto;
import com.bookstore.entity.User;
import com.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public APIResponse signUpUser(SignupRequestDto signupRequestDto) {

        APIResponse apiResponse = new APIResponse();

        //validator

        //create user
        User user = new User();
        user.setName(signupRequestDto.getName());
        user.setPassword(signupRequestDto.getPassword());
        user.setEmailId(signupRequestDto.getEmailId());
        user.setGender(signupRequestDto.getGender());
        user.setPhoneNumber(signupRequestDto.getPhoneNumber());

        user = userRepository.save(user);

        apiResponse.setStatus(200);
        apiResponse.setData(signupRequestDto);
        return apiResponse;
    }

    public APIResponse getAllUser() {
        APIResponse apiResponse = new APIResponse();
        List<User> userlist = userRepository.findAll();
        apiResponse.setStatus(200);
        apiResponse.setData(userlist);
        return apiResponse;
    }

    public APIResponse checkLoginDetails(LoginRequestDto loginRequestDto) {
        APIResponse apiResponse =  new APIResponse();
        User user = userRepository
                .findOneByEmailIdIgnoreCaseAndPassword(loginRequestDto.getEmailId(),loginRequestDto.getPassword());
        if(user != null) {
            apiResponse.setStatus(200);
            apiResponse.setData(user);
        }else{
            apiResponse.setStatus(400);
            apiResponse.setData("User not found");
        }

        return apiResponse;
    }
}
