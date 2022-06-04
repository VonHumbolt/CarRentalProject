package com.kaankaplan.car_rental.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaankaplan.car_rental.business.abstracts.AuthService;
import com.kaankaplan.car_rental.entity.Company;
import com.kaankaplan.car_rental.entity.Customer;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin
public class AuthController {

	private final AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("register/company")
	public ResponseEntity<String> register(@RequestBody Company company) {
		
		this.authService.register(company);
		
		return new ResponseEntity<String>("Hesabınız oluşturuldu", HttpStatus.CREATED);
		
	}
	
	@PostMapping("register/customer")
	public ResponseEntity<String> register(@RequestBody Customer customer) {
		
		this.authService.register(customer);
		
		return new ResponseEntity<String>("Hesabınız oluşturuldu", HttpStatus.CREATED);
		
	}
}
