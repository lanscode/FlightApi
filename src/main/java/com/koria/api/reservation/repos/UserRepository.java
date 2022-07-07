package com.koria.api.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koria.api.reservation.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
   User findByEmail(String email);
}
