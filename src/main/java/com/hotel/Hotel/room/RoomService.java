package com.hotel.Hotel.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoomService 
{
	public final RoomRepository roomRepository;
	
	//방 생성
	public Room create(String rname, String rtype)
	{
		Room room = new Room();
		room.setRname(rname);
		room.setRtype(rtype);
		return roomRepository.save(room);
	}
	
	
	//방 정보 수정
	public Room update
	(
			int rid, String rname, String rtype
	)
	{
		Room room = roomRepository.findById(rid).get();
		room.setRname(rname);
		room.setRtype(rtype);
		return roomRepository.save(room);
	}
	
	//방 1개 출력
	public Room getRoom(int rid)
	{
		return roomRepository.findById(rid).get();
	}
	
	
	//방 전체 출력
	public List<Room> getRoomList()
	{
		return roomRepository.findAll();
	}
	
	
	//방 삭제
	public void delete(int rid)
	{
		Optional<Room> op = roomRepository.findById(rid);
		Room room = null;
		if(op.isPresent())
		{
			room = op.get();
		}
		
		roomRepository.delete(room);
		
	}

	// 요청할 페이지 번호를 매개변수로 입력 : 
	public Page<Room> getList(Integer page, String kw) 
	{
		
		// page : 요청하는 페이지 번호, 10 : 한페이지에서 출력 하는 레코드 갯수 
		// Sort : 정렬을 위한 객체 
		List<Sort.Order> sorts = new ArrayList<>(); 
		sorts.add(Sort.Order.desc("rid")); 
		
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts)); 
					
		return roomRepository.findAll(pageable); 
	}
}
