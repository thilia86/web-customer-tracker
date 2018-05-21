package thilia.springdemo.dao;

import java.util.List;

import thilia.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int customerid);

	public void deleteCustomer(int customerid);
	
	public List<Customer> searchCustomers(String theSearchName);
		



	


	

}
