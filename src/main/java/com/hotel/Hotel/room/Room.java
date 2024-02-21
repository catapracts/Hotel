package com.hotel.Hotel.room;

import java.util.ArrayList;
import java.util.List;

import com.hotel.Hotel.Reservation.Reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "room")
@Getter @Setter
@ToString
@Entity
public class Room 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rid; //방 번호 PK
	
	private String rname; //방 이름
	
	private String rtype; //방 유형
	
	private int cnt;// 방 갯수?
	
	@OneToMany(mappedBy = "room")
	private List<Reservation> room = new ArrayList<>();

}
