package com.kaankaplan.car_rental.business.abstracts;

import com.kaankaplan.car_rental.entity.Company;
import com.kaankaplan.car_rental.entity.Customer;

public interface AuthService {

	void register(Company company);
	
	void register(Customer customer);
	
}
