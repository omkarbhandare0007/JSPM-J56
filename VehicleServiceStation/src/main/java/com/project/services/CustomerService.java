package com.project.services;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.project.dao.CustomerDao;
import com.project.entity.Customer;

public class CustomerService {

	public static void addCustomer() {
		Scanner choice = new Scanner(System.in);
		System.out.println("Enter Customer id  =");
		int id = choice.nextInt();
		System.out.println("Enter Customer name =");
		String name = choice.next();
		System.out.println("Enter Customer mobile =");
		String mobile = choice.next();
		System.out.println("Enter Customer email =");
		String email = choice.next();
		System.out.println("Enter Customer address =");
		String address = choice.next();
		Customer customer = new Customer(id, name, mobile, email, address);
		try (CustomerDao customerDao = new CustomerDao()) {
			if (customerDao.addCustomer(customer) > 0)
				System.out.println("####Customer Details Inserted Successfully####");
			else
				System.out.println("Customer Details not Inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// display all Customers
	public static void getAllCustomer() {
		List<Customer> customerList = new ArrayList<>();
		try (CustomerDao customerDao = new CustomerDao()) {
			customerDao.getAllCustomer(customerList);
			for (Customer customer : customerList) {
				System.out.println(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	// display Specific Customer
	public static Customer getSpecificCustomer() {
		System.out.println("Enter Customer mobile Number for get details = ");
		String mobile = new Scanner(System.in).next();

		try (CustomerDao customerDao = new CustomerDao()) {
			return customerDao.getSpecificCustomer(mobile);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void updateCustomer() {
		Scanner choice = new Scanner(System.in);
		System.out.println("Enter Customer id for edit customer Details = ");
		int id = choice.nextInt();
		System.out.println("Enter Customer mobile for Edit = ");
		String mobile = choice.next();
		System.out.println("Enter Customer address for Edit = ");
		String address = choice.next();
		System.out.println("Enter Customer name to edit: ");
		String name=choice.next();
		try (CustomerDao customerDao = new CustomerDao()) {
			if (customerDao.updateCustomer(id, mobile, address,name) > 0) {
				System.out.println("Customer data updated successfully...");
			} else {
				System.out.println("Customer Not  found .....");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void deleteCustomer() {
		System.out.print("Enter Customr id to detele details for customer = ");
		int id = new Scanner(System.in).nextInt();
		try {
			CustomerDao customerDao = new CustomerDao();
			if (customerDao.deleteCustomer(id) > 0) {
				System.out.println("Customer data deleted successfully....!!!");
			}else {
				System.out.println("Customer data not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
