package com.love2code.springsecurityjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BRANCH")
public class Branch {

	@Id
    @GeneratedValue
	private int id;
	private String location;
	private String bCode;
	private int totalEmployee;
	
	@Column(name="USER_NAME")
	private String username;

	public Branch() {
		// TODO Auto-generated constructor stub
	}
	
	public Branch(int id, String location, String bCode, int totalEmployee, AccountHolder accountHolder) {
		this.location = location;
		this.bCode = bCode;
		this.totalEmployee = totalEmployee;
	}
	
	public int getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getbCode() {
		return bCode;
	}
	public void setbCode(String bCode) {
		this.bCode = bCode;
	}
	public int getTotalEmployee() {
		return totalEmployee;
	}
	public void setTotalEmployee(int totalEmployee) {
		this.totalEmployee = totalEmployee;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Branch [id=" + id + ", location=" + location + ", bCode=" + bCode + ", totalEmployee=" + totalEmployee
				+ ", username=" + username + "]";
	}	
}
