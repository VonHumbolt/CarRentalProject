package com.kaankaplan.car_rental.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kaankaplan.car_rental.business.abstracts.CustomerService;
import com.kaankaplan.car_rental.business.abstracts.OperationClaimService;
import com.kaankaplan.car_rental.dataAccess.CustomerDao;
import com.kaankaplan.car_rental.entity.Customer;
import com.kaankaplan.car_rental.entity.OperationClaim;

@Service
public class CustomerManager implements CustomerService {

	private final CustomerDao customerDao;
	private final PasswordEncoder passwordEncoder;
	private final OperationClaimService operationClaimService;
	
	@Autowired
	public CustomerManager(CustomerDao customerDao, PasswordEncoder passwordEncoder,
			OperationClaimService operationClaimService) {
		super();
		this.customerDao = customerDao;
		this.passwordEncoder = passwordEncoder;
		this.operationClaimService = operationClaimService;
	}

	@Override
	public List<Customer> getallCustomers(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return this.customerDao.findAll(pageable).getContent();
	}

	@Override
	public Customer getCustomerById(int userId) {
		
		return this.customerDao.getById(userId);
	}

	@Override
	public void add(Customer customer) {
		
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		OperationClaim claim = operationClaimService.getClaimByClaimName("CUSTOMER");
		
		customer.setClaim(claim);
		
		this.customerDao.save(customer);
		
	}

	@Override
	public void deleteById(int customerId) {
		
		this.customerDao.deleteById(customerId);
		
	}
	
	
}
