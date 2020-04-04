package com.cognizant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.CustomerDAO;
import com.cognizant.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// inject customer dao
	@Autowired
	private CustomerDAO customerDAO ;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers() ;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return  customerDAO.getCustomer(theId);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchName(String searchName) {
		
		return customerDAO.searchName(searchName);
	}
	
	@Override
	@Transactional
	public List<Customer> searchByEmail(String searchEmail) {
		return customerDAO.searchByEmail(searchEmail);
	}
	
	
	@Override
	@Transactional
	public void deleteMultipleCustomer(int[] theIds) {
		System.out.println("deleteSelected deleteSelected");

		customerDAO.deleteMultipleCustomer(theIds);
	}

	
	
	
	
}
