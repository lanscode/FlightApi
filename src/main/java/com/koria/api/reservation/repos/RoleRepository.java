package com.koria.api.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koria.api.reservation.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
