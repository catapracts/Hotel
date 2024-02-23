package com.hotel.Hotel.RoomReservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hotel.Hotel.member.Member;
import com.hotel.Hotel.member.MemberRepository;
import com.hotel.Hotel.room.Room;
import com.hotel.Hotel.room.RoomRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoomReservationService 
{
	public final RoomReservationRepository roomReservationRepository;
 	public final RoomRepository roomRepository;
 	public final MemberRepository memberRepository;
 	
 	
	//room의 정보를 요청해서 가져오는 method를 따로 구현
 	public Room getRoom(int rid)
 	{
 		Room room = roomRepository.findById(rid).get();
 		return room;
 	}
 	

 	//예약 생성
 	public RoomReservation createRoomReservation
 	(
		 Member member, int rid,
		 Date sdate,Date edate,
		 int cnt
 	)
 	{
 		
 		RoomReservation roomReservation = new RoomReservation();
 		roomReservation.setRmember(member);
 		roomReservation.setRroom(getRoom(rid));
 		roomReservation.setSdate(sdate);
 		roomReservation.setEdate(edate);
 		roomReservation.setCnt(cnt);
	 
 		return roomReservationRepository.save(roomReservation);
 	}
 

 	// Reservation테이블의 모든 레코드를 가져와서 리턴
 	// 페이징 처리되지 않는 모든 레코드를 출력
 	// 리스트 페이지 - 예약 전체 조회
 	public List<RoomReservation> getRoomReservationList()
 	{
 		return roomReservationRepository.findAll();
 	}
 
 
 	//상세 페이지 - 예약 1개 조회
 	public RoomReservation getRoomReservation(int seq)
 	{
 		return roomReservationRepository.findById(seq).get();
 	}
 
 
 	//예약 수정
 	public RoomReservation updateRoomReservation
 	(
		 RoomReservation roomReservation,
		 int rid,
		 Date sdate,Date edate,
		 int cnt
 	)
 	{
 		roomReservation.setRroom(getRoom(rid));
 		roomReservation.setSdate(sdate);
 		roomReservation.setEdate(edate);
 		roomReservation.setCnt(cnt);
	 
 		return roomReservationRepository.save(roomReservation);
 	}
 
 
 	//예약 삭제
 	public void deleteRoomReservation(RoomReservation roomReservation)
 	{
 		roomReservationRepository.delete(roomReservation);
 	}
 
	// 요청할 페이지 번호를 매개변수로 입력 : 
	public Page<RoomReservation> getList(Integer page, String kw) 
	{
		
		// page : 요청하는 페이지 번호, 10 : 한페이지에서 출력 하는 레코드 갯수 
		// Sort : 정렬을 위한 객체 
		List<Sort.Order> sorts = new ArrayList<>(); 
		sorts.add(Sort.Order.desc("seq")); 
		
		
		Pageable pageable = PageRequest.of(page, 110, Sort.by(sorts)); 
					
		return roomReservationRepository.findAll(pageable); 
	}	
}
