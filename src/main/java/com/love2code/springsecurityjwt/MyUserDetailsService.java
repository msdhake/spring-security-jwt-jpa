package com.love2code.springsecurityjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.love2code.springsecurityjwt.models.UserDetailModel;
import com.love2code.springsecurityjwt.service.UserDetailModelService;
import com.love2code.springsecurityjwt.utils.EncryptDecryptUtils;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailModelService userDetailModelService;

    @Override
    public UserDetails loadUserByUsername(String strUsername) throws UsernameNotFoundException {
    	UserDetailModel userDetailModelObj= userDetailModelService.getUserByUserName(strUsername);
    	System.out.println( EncryptDecryptUtils.decrypt(userDetailModelObj.getPassword()));
        return new User(userDetailModelObj.getName(), EncryptDecryptUtils.decrypt(userDetailModelObj.getPassword()),
                new ArrayList<>());
    }
}