package com.project.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project.entity.Customer;
import com.project.util.DBUtil;

public class CustomerDao implements AutoCloseable{
	
	private Connection connection;
	 public CustomerDao() throws SQLException {
		 this.connection=DBUtil.getConnection();
	 } 	 
	
	 public int addCustomer (Customer customer) throws SQLException {
		 String sql="INSERT INTO customer (id,name,mobile,email,address) VALUES(?,?,?,?,?)";
		 try (PreparedStatement addCustomer=this.connection.prepareStatement(sql)){
			 addCustomer.setInt(1, customer.getId());
			 addCustomer.setString(2, customer.getName());
			 addCustomer.setString(3, customer.getMobile());
			 addCustomer.setString(4, customer.getEmail());
			 addCustomer.setString(5, customer.getAddress());
			return addCustomer.executeUpdate();
			
		} 
	 }

	
	 public void getAllCustomer(List<Customer>customerList) throws SQLException {
		 	String sql="SELECT * FROM customer";
		 	try(PreparedStatement getAllCustomer=this.connection.prepareStatement(sql)){
		 		ResultSet rs=getAllCustomer.executeQuery();
		 		while (rs.next()) {
					Customer customer=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
					customerList.add(customer);
					}
		 	}
	 }
	
	 public Customer getSpecificCustomer(String mobile) throws SQLException {
			String sql="SELECT * FROM  customer WHERE mobile =? ";
			try(PreparedStatement getSpecificCustomer =this.connection.prepareStatement(sql)) {
				getSpecificCustomer.setString(1 ,mobile);
				ResultSet  rs =getSpecificCustomer.executeQuery();
				if (rs.next()) 
					return new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				
				}
			return null;
		}
	public int updateCustomer (int id,String mobile,String address, String name) throws SQLException{
		String sql="UPDATE customer SET mobile =? ,address=?,name=? WHERE id=? ";
		try (PreparedStatement updateCustomer =this.connection.prepareStatement(sql)){
			updateCustomer.setInt(4, id);
			updateCustomer.setString(1, mobile);
			updateCustomer.setString(2, address);
			updateCustomer.setString(3, name);
			return updateCustomer.executeUpdate();
		} 
	}
	public int deleteCustomer(int id) throws SQLException{
		String sql="DELETE FROM customer WHERE id = ?";
		try (PreparedStatement deleteCustomer=this.connection.prepareStatement(sql)){
			deleteCustomer.setInt(1, id);
			return deleteCustomer.executeUpdate();
		}
	}
	
	@Override
	public void close() throws SQLException {
			this.connection.close();
	}
}
