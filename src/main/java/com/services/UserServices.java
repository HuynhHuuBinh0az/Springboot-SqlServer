package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.*;
import com.repository.UserRepository;

@Service
public class UserServices {
	@Autowired 
	private UserRepository userRepository;
	
	public List<Users> listAll() {
		return userRepository.findAll();
	}
	
	public Users findByID(Long id) {
		return userRepository.findById(id).get();
	}
	
	public void save(Users user) {
		userRepository.save(user);
	}
	
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
