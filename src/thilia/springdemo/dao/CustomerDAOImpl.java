package thilia.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thilia.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		//get the  current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();

		//create a query sort by lastname
		Query<Customer> theQuery=
				currentSession.createQuery("from Customer order by lastName",
						Customer.class);

		//execute query
		List<Customer> customers=theQuery.getResultList();

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int customerid) {

		Session currenrSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currenrSession.get(Customer.class,customerid);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int customerid) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");

		theQuery.setParameter("customerId",customerid);

		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		}
		else {
			// theSearchName is empty ... so just get all customers
			theQuery =currentSession.createQuery("from Customer", Customer.class);            
		}

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results        
		return customers;

	}


}


