package com.love2code.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.love2code.springsecurityjwt.models.UserDetailModel;
import com.love2code.springsecurityjwt.service.UserDetailModelService;


@RestController
@RequestMapping("/user")
public class UserDetailController {

    @Autowired
    private UserDetailModelService userDetailModelService;

    @PostMapping("/register")
    public ResponseEntity<String>  addProduct(@RequestBody UserDetailModel userDetailModel) {
        return userDetailModelService.saveUserDetails(userDetailModel);
    }
    
    @PutMapping("/update")
    public UserDetailModel updateProduct(@RequestBody UserDetailModel userDetailModel) {
        return userDetailModelService.updateUserDetail(userDetailModel);
    }

    @DeleteMapping("/delete/{name}")
    public String deleteProduct(@PathVariable String name) {
        return userDetailModelService.deleteUserByName(name);
    }
}
