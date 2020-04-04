package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchName(String searchName);

	public void deleteMultipleCustomer(int[] theIds);

	public List<Customer> searchByEmail(String searchEmail);

}
