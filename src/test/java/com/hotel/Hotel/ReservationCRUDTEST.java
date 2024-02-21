package com.hotel.Hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotel.Hotel.Reservation.Reservation;
import com.hotel.Hotel.Reservation.ReservationService;

@SpringBootTest
public class ReservationCRUDTEST 
{
	@Autowired
	ReservationService reservationService;
	
	
	//생성
	//@Test
	void create()
	{
		//reservationService.createReservation(1, 1, 1, LocalDateTime.now(), LocalDateTime.now(), 1);
		//reservationService.createReservation(2, 2, 2, LocalDateTime.now(), LocalDateTime.now(), 2);
	}
	
	
	//전체 조회
	//@Test
	void getList()
	{
		List<Reservation> list = reservationService.getReservationList();
		
		// for 문을 사용해서 list의 Reservation 객체를 끄집어내서 출력 
		for ( int i = 0 ; i < list.size(); i++) 
		{
			System.out.println(list.get(i).getSeq());
		}
		
		assertEquals (2 , list.size());		
	}
	
	
	//1개 조회
	//@Test 
	void get()
	{
		//reservationService.getReservation("2");
	}
	
	
	//수정
	//@Test
	void update()
	{
		//reservationService.updateReservation(2, 3, 3, 3, LocalDateTime.now(), LocalDateTime.now(), 4);
		//reservationService.getReservation("2");
	}
	
	
	
	//삭제
	@Test
	void delete()
	{
		//reservationService.deleteReservation("1");
		//reservationService.deleteReservation("2");
	}
	
	
	
}
