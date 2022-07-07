package com.koria.api.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koria.api.reservation.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
