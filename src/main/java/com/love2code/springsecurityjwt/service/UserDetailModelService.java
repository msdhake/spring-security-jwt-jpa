package com.love2code.springsecurityjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.love2code.springsecurityjwt.exception.UserException;
import com.love2code.springsecurityjwt.irepository.UserDetailModelRepository;
import com.love2code.springsecurityjwt.models.AccountHolder;
import com.love2code.springsecurityjwt.models.UserDetailModel;
import com.love2code.springsecurityjwt.utils.EncryptDecryptUtils;

@Service
public class UserDetailModelService {
    
	@Autowired
    private UserDetailModelRepository userDetailModelRepository;

    public ResponseEntity<String> saveUserDetails(UserDetailModel userDetailModel) {
    	UserDetailModel userDetailModelCheckObj = userDetailModelRepository.findByName(userDetailModel.getName());
    	if(null == userDetailModelCheckObj) {
        	userDetailModel.setPassword(EncryptDecryptUtils.encrypt(userDetailModel.getPassword()));
            userDetailModelRepository.save(userDetailModel);
            return new ResponseEntity<String>("username is successfully created: "+userDetailModel.getName(),HttpStatus.CREATED);
    	} else {
    		throw new UserException("User is already present.");
    	}
    }

    public UserDetailModel getUserByUserName(String strUserName) {
        return userDetailModelRepository.findByName(strUserName);
    }

    public String deleteUserByName(String strUserName) {
    	UserDetailModel userDetailModelObj = userDetailModelRepository.findByName(strUserName);
    	userDetailModelRepository.delete(userDetailModelObj);;
        return "UserDetails removed !! " + userDetailModelObj.getName();
    }

    public UserDetailModel updateUserDetail(UserDetailModel userDetailModel) {
    	UserDetailModel userDetailModelObj = userDetailModelRepository.findById(userDetailModel.getId()).orElse(null);
    	userDetailModelObj.setName(userDetailModel.getName());
    	userDetailModelObj.setPassword(EncryptDecryptUtils.encrypt(userDetailModel.getPassword()));
        return userDetailModelRepository.save(userDetailModelObj);
    }


}
