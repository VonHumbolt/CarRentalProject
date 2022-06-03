package com.kaankaplan.car_rental.core.security.filter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaankaplan.car_rental.entity.dto.LoginRequestDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	@Autowired
	public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			LoginRequestDto loginDto = new ObjectMapper().readValue(request.getInputStream(), LoginRequestDto.class);
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
			
			return authenticationManager.authenticate(authentication);
			
			
		} catch (IOException e) {
			
			throw new RuntimeException("Authentication is failed");
		}
				
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		String key = "secret_keysecret_keysecret_keysecret_keysecret_key";
		
		String token = Jwts.builder()
				.claim("authorities", authResult.getAuthorities())
				.setSubject(authResult.getName())
				.setIssuedAt(new Date())
				.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
				.signWith(Keys.hmacShaKeyFor(key.getBytes()))
				.compact();
		
		response.addHeader("Authorization", "Bearer " + token);
	}
	
}
