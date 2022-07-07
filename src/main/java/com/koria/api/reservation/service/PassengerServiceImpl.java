package com.koria.api.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koria.api.reservation.models.Passenger;
import com.koria.api.reservation.repos.PassengerRepository;

@Service 
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository repository;
	@Override
	public Passenger save(Passenger p) {
		// TODO Auto-generated method stub
		return repository.save(p);
	}

}
