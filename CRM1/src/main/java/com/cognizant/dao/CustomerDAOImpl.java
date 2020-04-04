package com.cognizant.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Customer;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory ;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query .... sort by First Name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by firstName", 
						Customer.class);
		
		
		//execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		// return the list
		return customers ;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer in database
		currentSession.saveOrUpdate(theCustomer);
		
	}


	@Override
	public Customer getCustomer(int theId) {
	// get current hibernate session
	Session currentSession = sessionFactory.getCurrentSession();
	// now retrieve/read from database using customer id for updates
	Customer customer = currentSession.get(Customer.class, theId);
	
	
	return customer;
	}


	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
	
		Query theQuery= currentSession.createQuery("delete from Customer where id=:abc");
		theQuery.setParameter("abc", theId);
		theQuery.executeUpdate();
	}


	
	@Override
	public List<Customer> searchName(String searchName) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// now retrieve/read from database using customer id for updates
		// create query .... 
		if(searchName !=null && searchName.trim().length()>0) {
				Query<Customer> theQuery = 
						currentSession.createQuery("from Customer where first_name"
								+ " like:sname "
								,Customer.class);
				//searchName+="%";
				theQuery.setParameter("sname", searchName+"%");
				//execute query and get result list
				List<Customer> customers = theQuery.getResultList();
		return customers;
		}
		else {
			Query<Customer> theQuery = 
					currentSession.createQuery("from Customer order by firstName", 
							Customer.class);
			//execute query and get result list
			List<Customer> customers = theQuery.getResultList();
			// return the list
			return customers ;
		}
	}

	@Override
	public List<Customer> searchByEmail(String searchEmail) {

		//get current hibernate session from sessionFactory
		Session session = sessionFactory.getCurrentSession();
		// write query
		if(searchEmail != null && searchEmail.trim().length()>0) {
			Query<Customer> searchEmailQuery = 
					session.createQuery("from Customer where email like:semail" , Customer.class);
			searchEmailQuery.setParameter("semail", searchEmail+"%");
			// execute query
			List<Customer> customers = searchEmailQuery.getResultList();
			// return list
			return customers;
		}
		else {
			return null;
		}
		
	}
	
	@Override
	public void deleteMultipleCustomer(int[] theIds) {
		for (int i = 0; i < theIds.length; i++) {
			System.out.println("deleteSelected deleteSelected");

					Session currentSession = sessionFactory.getCurrentSession();
					Query theQuery= currentSession.createQuery("delete from Customer where id=:abc");
					theQuery.setParameter("abc", theIds[i]);
					theQuery.executeUpdate();
		}
		
		
	}


	
	
	

}
