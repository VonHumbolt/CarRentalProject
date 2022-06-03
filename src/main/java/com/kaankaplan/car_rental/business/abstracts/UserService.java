package com.kaankaplan.car_rental.business.abstracts;

import java.util.List;

import com.kaankaplan.car_rental.entity.User;

public interface UserService {

	List<User> getallUsers(int pageNo, int pageSize);
	
	User getUserByEmail(String email);
		
	User getUserById(int userId);
	
	void deleteById(int userId);
}
