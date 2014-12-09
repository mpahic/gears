package com.cloudcog.gears.model.user;

public class User {
	private String username;
	private String firstName;
	private String lastName;
	private String address;
	private Boolean gender;
	private Integer role;

	public User(String username, String firstName, String lastname, String address, Boolean gender){
		this.username=username;
		this.firstName=firstName;
		this.lastName=lastname;
		this.address=address;
		this.gender=gender;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public Boolean isMale() {
		return gender;
	}

	public Boolean isFemale() {
		return !gender;
	}

	//TODO: 
	public Boolean isAdmin() {
		return true;
	}
}
