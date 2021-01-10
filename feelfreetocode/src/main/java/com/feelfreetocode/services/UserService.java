package com.feelfreetocode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.feelfreetocode.models.User;

@Service(value = "UserService")
public interface UserService {
	public User saveUser(User user);
	public List<User> getAllUsers();
	public Optional<User> getUserById(Long userId);
	public void deleteUser(Long userId);
}



