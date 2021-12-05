package com.love2code.springsecurityjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USER_DETAILS")
public class UserDetailModel {

    @Id
    @GeneratedValue
    private int id;
    
    @Column(name="USER_NAME")
    private String name;
    
    @Column(name="PASSWORD")
	private String password;
	
	public UserDetailModel() {
	
	}

	public UserDetailModel(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String username) {
		this.name = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetailModel [id=" + id + ", username=" + name + ", password=" + password + "]";
	}
}
