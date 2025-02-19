package com.project.entity;

public class Customer {
	private int id;
	private String name;
	private String mobile;
	private String email;
	private String address;

	public Customer (){
		
	}
	public Customer( String name, String mobile, String email, String address) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}
	
	 
	public Customer(int id, String name, String mobile, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", address="
				+ address + "]";
	}



}
