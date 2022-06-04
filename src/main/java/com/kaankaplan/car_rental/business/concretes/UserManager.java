package com.kaankaplan.car_rental.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kaankaplan.car_rental.business.abstracts.UserService;
import com.kaankaplan.car_rental.dataAccess.UserDao;
import com.kaankaplan.car_rental.entity.User;

@Service
public class UserManager implements UserService {

	private final UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> getallUsers(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return this.userDao.findAll(pageable).getContent();
	}

	@Override
	public User getUserByEmail(String email) {
		
		return this.userDao.findByEmail(email);
	}

	@Override
	public User getUserById(int userId) {
		
		return this.userDao.getById(userId);
	}

	@Override
	public void deleteById(int userId) {
		
		this.userDao.deleteById(userId);
		
	}

	
}
