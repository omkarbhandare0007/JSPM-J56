package com.project.entity;

public class Vehicle {

	private int id;
	private String model;
	private String company;
	
	public Vehicle() {
		
	}
	
	public Vehicle(int id, String model, String company) {
		super();
		this.id = id;
		this.model = model;
		this.company = company;
	}

	public Vehicle(String company, String model) {
		super();
		this.model = model;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", company=" + company + "]";
	}
	
	
	
	
}
