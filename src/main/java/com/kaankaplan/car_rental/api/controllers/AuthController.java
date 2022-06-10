package com.kaankaplan.car_rental.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaankaplan.car_rental.business.abstracts.AuthService;
import com.kaankaplan.car_rental.entity.Company;
import com.kaankaplan.car_rental.entity.Customer;
import com.kaankaplan.car_rental.entity.User;

@Controller
@RequestMapping("/api/auth/")
@CrossOrigin
public class AuthController {

	private final AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@GetMapping("/login")
	public String showLoginForm(User user) {
		return "login";
	}
	
	
	@PostMapping("register/company")
	public String register(@Valid Company company,  BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "register";
		}
		
		this.authService.register(company);
		
		return "redirect:/api/auth/login";
		
	}
	
	
	// Customer Sign Up process
	
	@GetMapping("/signUp")
    public String showSignUpForm(Customer customer, Company company) {
        return "register";
    }
	
	@PostMapping("register/customer")
	public String register(@Valid Customer customer, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "register";
		}
		
		this.authService.register(customer);
		
		return "redirect:/api/auth/login";
		
	}
}
