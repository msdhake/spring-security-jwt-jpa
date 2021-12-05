package com.love2code.springsecurityjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT_HOLDER")
public class AccountHolder {

	@Id
    @GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private int contactNumber;
	
	@OneToOne
    private Branch branch;
    
	public AccountHolder() {
		
	}

	public AccountHolder(String firstName, String lastName, String address, int contactNumber,
			Branch branch) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.branch = branch;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "AccountHolder [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", contactNumber=" + contactNumber + ", branch=" + branch + "]";
	}
	
	
}
