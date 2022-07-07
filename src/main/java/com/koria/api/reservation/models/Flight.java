package com.koria.api.reservation.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.ToString;

@Entity
@ToString
public class Flight extends AbstractEntity{
	
	@Column(name = "FLIGHT_NUMBER")
	private String flightNumber;  
	@Column(name = "OPERATING_AIRLINES")
	private String operatingAirlines;  
	@Column(name = "DEPARTURE_CITY")
	private String departureCity; 
	@Column(name = "ARRIVAL_CITY")
	private String arrivalCity; 
	@Column(name = "DATE_OF_DEPARTURE")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dateOfDeparture; 
	@Column(name = "ESTIMATED_DEPARTURE_TIME")
	private Timestamp estimatedDepartureTime;
	@OneToOne(mappedBy = "flight")
	private Reservation reservation;
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getOperatingAirlines() {
		return operatingAirlines;
	}
	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}
	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}
	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}  

}
