package com.koria.api.reservation.service;

import com.koria.api.reservation.models.User;

public interface UserService {
	User save(User user);
	User findByEmail(String email);

}
