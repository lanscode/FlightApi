package com.koria.api.reservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koria.api.reservation.dto.ReservationRequest;
import com.koria.api.reservation.models.Reservation;
import com.koria.api.reservation.service.FlightService;
import com.koria.api.reservation.service.ReservationService;


@Controller
public class ReservationController {
	@Autowired
	private FlightService flightService;
	@Autowired
	private ReservationService resService;
	@RequestMapping(method = RequestMethod.GET,value = "/reservation")
	public String getReservationForm(@RequestParam("id") Long id,ModelMap modelMap) {
		modelMap.addAttribute("flight", flightService.find(id));
		return "reservation/reservation";
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/reservation")
	public String completeReservation(@ModelAttribute("reservationRequest") ReservationRequest reservationRequest ,ModelMap modelMap) {
        Reservation reservation = resService.bookingFlight(reservationRequest);
		modelMap.addAttribute("msg", "Reservation Saved with id: "+reservation.getId());
		return "reservation/confirmation";
		
	}

}
