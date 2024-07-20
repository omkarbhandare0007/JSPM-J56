package testCases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.project.dao.CustomerDao;
import com.project.entity.Customer;

public class CustomerDaoTest {

	//test case for add customer 
	@Test
	public void testaddCustomer() {
		CustomerDao customerDao;
		try {
			customerDao =new CustomerDao();
			System.out.println(customerDao.addCustomer(new Customer( "akash","9898989898", "Akash@gmail.com", "Kolhapur")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// test case for get all customers
	@Test
	public void testGetAllCustomer() {
	CustomerDao customerDao;
	try {
		customerDao=new CustomerDao();
		List<Customer> customerList=new ArrayList<>();
		customerDao.getAllCustomer(customerList); 
		customerList.forEach(System.out::println);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	// test case for get specific customer
	@Test
	public void testGetspecificCustomer() {
		CustomerDao customerDao;
		try {
			customerDao =new CustomerDao();
			customerDao.getSpecificCustomer("9518331190");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// test case for update customer details
	@Test
	public void testUpdateCustomer() {
		CustomerDao customerDao;
		try {
			customerDao =new CustomerDao();
			customerDao.updateCustomer(17, "7020680295", "PIMPALGAON","vishal");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testDeleteCustomer() {
		CustomerDao customerDao;
		try {
			customerDao=new CustomerDao();
			customerDao.deleteCustomer(17);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
	

