package com.koria.api.reservation.controllers;


import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koria.api.reservation.models.Flight;
import com.koria.api.reservation.service.FlightService;

@Controller
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/findFlight")
	public String findFlightForm() {
		return "flight/search";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/flighs")
	public String showFlights(@RequestParam("departureCity") String departureCity,@RequestParam("arrivalCity") String arrivalCity,@RequestParam("dateOfDeparture")@DateTimeFormat(pattern = "MM-dd-yyyy") Date dateOfDeparture,ModelMap modelMap) {
		List<Flight> flights = flightService.findFlights(departureCity, arrivalCity, dateOfDeparture);
		modelMap.addAttribute("flights",flights);
		return "flight/flights";
	}
	
	
	@GetMapping(path = "/addFlight")
	public String addFlightForm() {
		return "flight/add";
	}
}
