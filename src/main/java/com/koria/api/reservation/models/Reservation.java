package com.koria.api.reservation.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "UK_Flight_Reservation" , columnNames = { "flight_id" })})
public class Reservation extends AbstractEntity {

	@Column(name = "CHECKED_IN")
	private Boolean checkedIn;
	@Column(name="NUMBER_OF_BAGS")
	private int numberOfBags;
    @OneToOne
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
	private Passenger passenger;
	@OneToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
	private Flight flight;
	@CreationTimestamp
	private Date created;
	
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumberOfBags() {
		return numberOfBags;
	}
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

}
