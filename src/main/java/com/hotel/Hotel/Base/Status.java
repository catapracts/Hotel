package com.hotel.Hotel.Base;

import lombok.Getter;

@Getter
public enum Status 
{
	AVAILIABLE("Reservation_AVAILIABLE")
	, DENIED("Reservation_DENIED") ; 

	private String value;
	
	Status(String value) {
		this.value = value ; 
	}
}
