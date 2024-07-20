package com.project.main;

import java.util.Scanner;

public class MainMenu {
	enum EmainMenu{
		EXIT,CUSTOMER,VEHICLE,DEFAULT
	}
	public static EmainMenu mainMenuOption() {
		
		System.out.println("0. Exit");
		System.out.println("1. Customer");
		System.out.println("2. Vehicle");
		System.out.print("Enter your choice = ");
		int choice=new Scanner(System.in).nextInt();
		if (choice <0 || choice >2) 
			return EmainMenu.values()[2];	
		else
		return EmainMenu.values()[choice];
		
	}
	public static void main(String[] args) {
		EmainMenu choice ;
		while ((choice =mainMenuOption())!=EmainMenu.EXIT) {
			switch (choice) {
			case CUSTOMER:
				SubMenu.customerMain();
				break;
			case VEHICLE:
				SubMenu.vehicleMain();
				break;
			
			default:
				System.out.println("Wrong choice....:(");
				break;
			}
		}
	}
}
