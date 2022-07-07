package com.koria.api.reservation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koria.api.reservation.models.Flight;
import com.koria.api.reservation.repos.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
	private FlightRepository repository;
	@Override
	public List<Flight> findFlights(String cityFrom, String cityTo, Date dateOfDeparture) {
		return repository.findByDepartureCityAndArrivalCityAndDateOfDeparture(cityFrom,cityTo,dateOfDeparture);
	}
	@Override
	public Flight find(Long id) {
		return repository.getById(id);
	}

}
