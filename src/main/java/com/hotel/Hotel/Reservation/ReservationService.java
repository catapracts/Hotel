package com.hotel.Hotel.Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
 
 //예약 생성
 public Reservation createReservation
 (
		 Member member, Room room, Facility facility,
		 Date sdate,Date edate,
		 int cnt
 )
 {
	 Reservation reservation = new Reservation();
	 reservation.setMember(member);
	 reservation.setRoom(room);
	 reservation.setFacility(facility);
	 reservation.setSdate(sdate);
	 reservation.setEdate(edate);
	 reservation.setCnt(cnt);
	 
	 return reservationRepository.save(reservation);
 }
 

 // Reservation테이블의 모든 레코드를 가져와서 리턴 
 // 리스트 페이지
 // 페이징 처리되지 않는 모든 레코드를 출력
 //예약 전체 조회
 public List<Reservation> getReservationList()
 {
	 return reservationRepository.findAll();
 }
 
 
 //상세 페이지 
 //예약 1개 조회
 public Reservation getReservation(int seq)
 {
	 return reservationRepository.findById(seq).get();
 }
 
 
 //예약 수정
 public Reservation updateReservation
 (
		 int seq,
		 Room room, Facility facility,
		 Date sdate,Date edate,
		 int cnt
		 )
 {
	 Reservation reservation = reservationRepository.findById(seq).get();
	 reservation.setRoom(room);
	 reservation.setFacility(facility);
	 reservation.setSdate(sdate);
	 reservation.setEdate(edate);
	 reservation.setCnt(cnt);
	 
	 return reservationRepository.save(reservation);
 }
 
 
 //예약 삭제
 public void deleteReservation(String mid)
 {
	 Optional<Reservation> op = reservationRepository.findByMid(mid);
	 Reservation reservation = null;
	 
		if (op.isPresent()) 
		{
			reservation = op.get(); 
		}
		
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
