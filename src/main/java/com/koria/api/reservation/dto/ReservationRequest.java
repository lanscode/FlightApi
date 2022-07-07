package com.koria.api.reservation.dto;

import lombok.Getter;
import lombok.Setter;

public class ReservationRequest {
	@Getter @Setter
	private Long flightId;
	@Getter @Setter
	private String firstName;
	@Getter @Setter
	private String lastName;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String phone;

}
