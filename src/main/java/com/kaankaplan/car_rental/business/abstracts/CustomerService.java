package com.kaankaplan.car_rental.business.abstracts;

import java.util.List;

import com.kaankaplan.car_rental.entity.Customer;

public interface CustomerService {

	List<Customer> getallCustomers(int pageNo, int pageSize);
		
	Customer getCustomerById(int userId);
	
	void add(Customer customer);
	
	void deleteById(int customerId);
}
