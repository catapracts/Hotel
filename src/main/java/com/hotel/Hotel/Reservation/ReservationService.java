package com.hotel.Hotel.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hotel.Hotel.facility.Facility;
import com.hotel.Hotel.facility.FacilityRepository;
import com.hotel.Hotel.member.Member;
import com.hotel.Hotel.member.MemberRepository;
import com.hotel.Hotel.room.Room;
import com.hotel.Hotel.room.RoomRepository;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReservationService
{
	public final ReservationRepository reservationRepository;
 	public final RoomRepository roomRepository;
 	public final FacilityRepository facilityRepository;
 	public final MemberRepository memberRepository;
 	
 	
	//room이랑 facility의 정보를 요청해서 가져오는 method를 따로 구현
 	public Room getRoom(int rid)
 	{
 		Room room = roomRepository.findById(rid).get();
 		return room;
 	}
 	
 	public Facility getFacility(int fid)
 	{
 		Facility facility = facilityRepository.findById(fid).get();
 		return facility;
 	}
 	

 	//예약 생성
 	public Reservation createReservation
 	(
		 Member member, int rid, int fid,
		 Date sdate,Date edate,
		 int cnt
 	)
 	{
 		
 		Reservation reservation = new Reservation();
 		reservation.setMember(member);
 		reservation.setRoom(getRoom(rid));
 		reservation.setFacility(getFacility(fid));
 		reservation.setSdate(sdate);
 		reservation.setEdate(edate);
 		reservation.setCnt(cnt);
	 
 		return reservationRepository.save(reservation);
 	}
 

 	// Reservation테이블의 모든 레코드를 가져와서 리턴
 	// 페이징 처리되지 않는 모든 레코드를 출력
 	// 리스트 페이지 - 예약 전체 조회
 	public List<Reservation> getReservationList()
 	{
 		return reservationRepository.findAll();
 	}
 
 
 	//상세 페이지 - 예약 1개 조회
 	public Reservation getReservation(int seq)
 	{
 		return reservationRepository.findById(seq).get();
 	}
 
 
 	//예약 수정
 	public Reservation updateReservation
 	(
		 Reservation reservation,
		 int rid, int fid,
		 Date sdate,Date edate,
		 int cnt
 	)
 	{
 		reservation.setRoom(getRoom(rid));
 		reservation.setFacility(getFacility(fid));
 		reservation.setSdate(sdate);
 		reservation.setEdate(edate);
 		reservation.setCnt(cnt);
	 
 		return reservationRepository.save(reservation);
 	}
 
 
 	//예약 삭제
 	public void deleteReservation(Reservation reservation)
 	{
		reservationRepository.delete(reservation);
 	}
 
	// 요청할 페이지 번호를 매개변수로 입력 : 
	public Page<Reservation> getList(Integer page, String kw) 
	{
		
		// page : 요청하는 페이지 번호, 10 : 한페이지에서 출력 하는 레코드 갯수 
		// Sort : 정렬을 위한 객체 
		List<Sort.Order> sorts = new ArrayList<>(); 
		sorts.add(Sort.Order.desc("seq")); 
		
		
		Pageable pageable = PageRequest.of(page, 110, Sort.by(sorts)); 
					
		return reservationRepository.findAll(pageable); 
	}	
}
