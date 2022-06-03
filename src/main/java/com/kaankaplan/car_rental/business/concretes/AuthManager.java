package com.kaankaplan.car_rental.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.kaankaplan.car_rental.business.abstracts.AuthService;
import com.kaankaplan.car_rental.business.abstracts.CompanyService;
import com.kaankaplan.car_rental.business.abstracts.CustomerService;
import com.kaankaplan.car_rental.business.abstracts.UserService;
import com.kaankaplan.car_rental.entity.Company;
import com.kaankaplan.car_rental.entity.Customer;
import com.kaankaplan.car_rental.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthManager implements AuthService, UserDetailsService {

	private final UserService userService;
	private final CompanyService companyService;
	private final CustomerService customerService;
	
	@Autowired
	public AuthManager(UserService userService, CompanyService companyService, CustomerService customerService) {
		super();
		this.userService = userService;
		this.companyService = companyService;
		this.customerService = customerService;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = this.userService.getUserByEmail(email);
		
		if (user == null) {
			log.info("Kullanıcı kaydı bulunamadı");
			throw new UsernameNotFoundException("User not found");
		}
		
		String claim = user.getClaim().getClaimName();
		
		List<SimpleGrantedAuthority> authorities = Lists.newArrayList(new SimpleGrantedAuthority(claim));
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

	@Override
	public void register(Company company) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void register(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}
