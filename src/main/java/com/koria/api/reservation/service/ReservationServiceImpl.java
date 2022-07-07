package com.koria.api.reservation.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.koria.api.reservation.dto.ReservationRequest;
import com.koria.api.reservation.models.Flight;
import com.koria.api.reservation.models.Passenger;
import com.koria.api.reservation.models.Reservation;
import com.koria.api.reservation.repos.ReservationRepository;
import com.koria.api.util.EmailUtil;
import com.koria.api.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository repository;
	@Autowired
	private FlightService flightService;
	@Autowired
	private PassengerService passengerService;
	@Autowired
	private EmailUtil emailUtil;
	@Autowired
	private PDFGenerator pdfGenerator;
	
	@Value("${com.koria.api.email.path}")
	private String DIR;
	
	private static Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	@Override
	public Reservation save(Reservation reservation) {
		// TODO Auto-generated method stub
		return repository.save(reservation);
	}
	@Transactional
	@Override
	public Reservation bookingFlight(ReservationRequest reservationRequest) {
		Passenger passenger = new Passenger();
		Flight f = flightService.find(reservationRequest.getFlightId());
		System.out.println("flight "+f.getOperatingAirlines());
		passenger.setEmail(reservationRequest.getEmail());
		passenger.setFirstName(reservationRequest.getFirstName());
		passenger.setLastName(reservationRequest.getLastName());
		passenger.setPhone(reservationRequest.getPhone());
		passenger = passengerService.save(passenger);
		Reservation reservation = new Reservation();
		reservation.setFlight(f);
		reservation.setPassenger(passenger);
		reservation.setCreated(new Date());
		reservation.setCheckedIn(false);
		reservation = repository.save(reservation);
		LOGGER.info("Reservation saved with id "+reservation.getId());
		//Generate the pdf 
		String path = DIR+"/reservation"+reservation.getId()+".pdf";
		LOGGER.info("File path is "+DIR);
		pdfGenerator.generateItinerary(reservation,path );
		LOGGER.info("Pdf Generated in the above directory");
		//Send a mail to the passenger
		emailUtil.sendEmail(passenger.getEmail(), path);
		LOGGER.info("An email has been sent to "+passenger.getEmail());

		return reservation;
	}

}
