package com.hotel.Hotel.Reservation;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReservationForm 
{
	private int rid;
	
	private int fid;
	
	@NotEmpty(message="시작 날짜는 필수 입력 사항입니다.")
	private Date sdate; //예약 시작일
	
	@NotEmpty(message="종료 날짜는 필수 입력 사항입니다.")
	private Date edate; //예약 종료일
	
	@NotEmpty(message="인원 수는 필수 입력 사항입니다.")
	private int cnt; //예약 인원 수

}
