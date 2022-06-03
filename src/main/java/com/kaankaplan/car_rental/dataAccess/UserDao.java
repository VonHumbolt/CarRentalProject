package com.kaankaplan.car_rental.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaankaplan.car_rental.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	
}
