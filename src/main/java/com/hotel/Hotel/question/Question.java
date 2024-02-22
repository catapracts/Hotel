package com.hotel.Hotel.question;

import java.time.LocalDateTime;

import com.hotel.Hotel.member.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer qid;
	
	@Column(length=200)
	private String title;
	
	@Column(length=20000)
	private String content;
	
	private LocalDateTime regdate;
	private LocalDateTime modifyDate;
	
	//FK : member_mid
	@ManyToOne
	@JoinColumn(name = "mid")
	private Member member;
	
//	@ManyToMany
//	private Set<Member> voter;
}
