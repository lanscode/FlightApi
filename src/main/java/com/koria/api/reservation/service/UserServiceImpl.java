package com.koria.api.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koria.api.reservation.models.User;
import com.koria.api.reservation.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	@Override
	public User save(User user) {
		return repository.save(user);
	}
	@Override
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}

}
