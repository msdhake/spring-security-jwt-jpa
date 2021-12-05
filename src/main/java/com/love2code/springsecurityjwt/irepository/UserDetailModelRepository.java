package com.love2code.springsecurityjwt.irepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.love2code.springsecurityjwt.models.UserDetailModel;


public interface UserDetailModelRepository extends JpaRepository<UserDetailModel,Integer> {
	UserDetailModel findByName(String name);
}

