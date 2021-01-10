package com.feelfreetocode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feelfreetocode.dao.UserDao;
import com.feelfreetocode.models.User;

@Service("UserServiceImplStringName")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public Optional<User> getUserById(Long userId) {
		return userDao.findById(userId);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userDao.deleteById(userId);
	}
	
	
	

}
