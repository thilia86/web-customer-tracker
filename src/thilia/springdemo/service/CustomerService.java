package thilia.springdemo.service;

import java.util.List;

import thilia.springdemo.entity.Customer;

public interface CustomerService {
	
	List <Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	Customer getCustomer(int customerid);

	void deleteCustomer(int customerid);
	
	public List<Customer> searchCustomers(String theSearchName);

}
