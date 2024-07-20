package com.project.main;

import java.sql.SQLException;


import java.util.List;
import java.util.Scanner;


import com.project.dao.CustomerDao;
import com.project.entity.Customer;
import com.project.services.CustomerService;
import com.project.services.VehicleService;

public class SubMenu {

	enum EcustomerMenu {
		BACK, ADD_CUSTOMER, DISPLAY_ALL_CUSTOMER, DISPLAY_SPECIFIC, EDIT, DELETE, DEFAULT
	}

	enum EvehicleMenu {
		BACK, ADD_VEHICLE, DIPLAY_ALL_VEHICLES, DIPLAY_CUSTOMER_VEHICLES, EDIT, DELETE, DEFAULT
	}


	public static EcustomerMenu customerMenu() {
		System.out.println("0. Back ");
		System.out.println("1. Add customer");
		System.out.println("2. Display All Customers");
		System.out.println("3. Display Specific Customer Details ");
		System.out.println("4. Edit Customer ");
		System.out.println("5. Delete Customer");
		System.out.print("Enter your choice =  ");
		int choice = new Scanner(System.in).nextInt();
		if (choice < 0 || choice > 6)
			return EcustomerMenu.values()[6];
		else
			return EcustomerMenu.values()[choice];
	}
	public static void customerMain() {
		EcustomerMenu choice;
		while ((choice = customerMenu()) != EcustomerMenu.BACK) {
			switch (choice) {
			case ADD_CUSTOMER:
				CustomerService.addCustomer();
				break;
			case DISPLAY_ALL_CUSTOMER:
				CustomerService.getAllCustomer();

				break;
			case DISPLAY_SPECIFIC:
				System.out.println(CustomerService.getSpecificCustomer());
				break;
			case EDIT:
				CustomerService.updateCustomer();
				break;
			case DELETE:
				CustomerService.deleteCustomer();
				break;

			default:
				System.out.println("Wrong choice ...:(");
				break;
			}
		}
	}

	public static EvehicleMenu vehicleMenu() {
		System.out.println("0. Back");
		System.out.println("1. Add Vehicle ");
		System.out.println("2. Display All Vehicles ");
		System.out.println("3. Display Customer Vehicles ");
		System.out.println("4. Edit Vehicle ");
		System.out.println("5. Delete Vehicle ");
		System.out.print("Enter your Choice = ");

		int choice = new Scanner(System.in).nextInt();
		if (choice < 0 || choice > 6)
			return EvehicleMenu.values()[6];
		else
			return EvehicleMenu.values()[choice];
	}

	public static void vehicleMain() {
		EvehicleMenu choice;
		while ((choice = vehicleMenu()) != EvehicleMenu.BACK) {
			switch (choice) {
			case ADD_VEHICLE:
				VehicleService.addVehicle();
				break;
			case DIPLAY_ALL_VEHICLES:
				VehicleService.getAllVehicle();
				break;
			case DIPLAY_CUSTOMER_VEHICLES:
				Customer cust = CustomerService.getSpecificCustomer();
				VehicleService.getSpecificVehicles(cust);
				break;
			case EDIT:
				VehicleService.updateVehicle();
				break;
			case DELETE:
				VehicleService.deleteVehicle();
				break;
			default:
				System.out.println("Wrong choice ...:(");
				break;
			}
		}
	}


}
