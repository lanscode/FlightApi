package com.koria.api.reservation.service;

import java.util.Date;
import java.util.List;

import com.koria.api.reservation.models.Flight;

public interface FlightService {

	List<Flight> findFlights(String cityFrom,String cityTo,Date dateOfDeparture);

	Flight find(Long id);
}
