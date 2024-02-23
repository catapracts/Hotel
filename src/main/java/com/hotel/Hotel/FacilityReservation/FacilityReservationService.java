package com.hotel.Hotel.FacilityReservation;

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


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FacilityReservationService 
{
	public final FacilityReservationRepository facilityReservationRepository;
 	public final FacilityRepository facilityRepository;
 	public final MemberRepository memberRepository;
	
	//room의 정보를 요청해서 가져오는 method를 따로 구현
 	public Facility getFacility(int fid)
 	{
 		Facility facility = facilityRepository.findById(fid).get();
 		return facility;
 	}
 	

 	//예약 생성
 	public FacilityReservation createFacilityReservation
 	(
		 Member member, int fid,
		 Date date,
		 int cnt
 	)
 	{
 		
 		FacilityReservation facilityReservation = new FacilityReservation();
 		facilityReservation.setFmember(member);
 		facilityReservation.setFfacility(getFacility(fid));
 		facilityReservation.setDate(date);
 		facilityReservation.setCnt(cnt);
	 
 		return facilityReservationRepository.save(facilityReservation);
 	}
 

 	// Reservation테이블의 모든 레코드를 가져와서 리턴
 	// 페이징 처리되지 않는 모든 레코드를 출력
 	// 리스트 페이지 - 예약 전체 조회
 	public List<FacilityReservation> getFacilityReservationList()
 	{
 		return facilityReservationRepository.findAll();
 	}
 
 
 	//상세 페이지 - 예약 1개 조회
 	public FacilityReservation getFacilityReservation(int seq)
 	{
 		return facilityReservationRepository.findById(seq).get();
 	}
 
 
 	//예약 수정
 	public FacilityReservation updateFacilityReservation
 	(
 		FacilityReservation facilityReservation,
		 int fid,
		 Date date,
		 int cnt
 	)
 	{
 		facilityReservation.setFfacility(getFacility(fid));
 		facilityReservation.setDate(date);
 		facilityReservation.setCnt(cnt);
	 
 		return facilityReservationRepository.save(facilityReservation);
 	}
 
 
 	//예약 삭제
 	public void deleteFacilityReservation(FacilityReservation facilityReservation)
 	{
 		facilityReservationRepository.delete(facilityReservation);
 	}
 
	// 요청할 페이지 번호를 매개변수로 입력 : 
	public Page<FacilityReservation> getList(Integer page, String kw) 
	{
		
		// page : 요청하는 페이지 번호, 10 : 한페이지에서 출력 하는 레코드 갯수 
		// Sort : 정렬을 위한 객체 
		List<Sort.Order> sorts = new ArrayList<>(); 
		sorts.add(Sort.Order.desc("seq")); 
		
		
		Pageable pageable = PageRequest.of(page, 110, Sort.by(sorts)); 
					
		return facilityReservationRepository.findAll(pageable); 
	}
}
