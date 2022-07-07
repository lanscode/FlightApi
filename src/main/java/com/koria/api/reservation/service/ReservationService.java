package com.koria.api.reservation.service;

import com.koria.api.reservation.dto.ReservationRequest;
import com.koria.api.reservation.models.Reservation;

public interface ReservationService {
  Reservation save(Reservation reservation);
  Reservation bookingFlight(ReservationRequest request) ;
}
