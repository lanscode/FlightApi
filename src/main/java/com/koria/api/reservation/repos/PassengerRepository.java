package com.koria.api.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koria.api.reservation.models.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
