package thilia.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thilia.springdemo.dao.CustomerDAO;
import thilia.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);

		}

	@Override
	@Transactional
	public Customer getCustomer(int customerid) {
		
		return customerDAO.getCustomer(customerid);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerid) {
		
		customerDAO.deleteCustomer(customerid);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		
		return customerDAO.searchCustomers(theSearchName);
	}

}
