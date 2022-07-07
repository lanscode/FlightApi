package com.koria.api.reservation.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koria.api.reservation.models.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	List<Flight> findByDepartureCityAndArrivalCityAndDateOfDeparture(String cityFrom, String cityTo,
			Date dateOfDeparture);

}
