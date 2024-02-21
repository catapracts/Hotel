package com.hotel.Hotel.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.hotel.Hotel.Base.Role;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberSecurityService implements UserDetailsService
{
	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String mid) throws UsernameNotFoundException 
	{
		Optional<Member> member = memberRepository.findByMid(mid);
		
		if(member.isEmpty())
		{
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		}
		
		Member m = member.get();
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		System.out.println("mid --> " + mid );
		System.out.println("Member --> " + m.getEmail());
		
		
		
		if("admin".equals(m.getRole()))
		{
			authorities.add (new SimpleGrantedAuthority(Role.ADMIN.getValue()));
		}
		
		else
		{
			authorities.add (new SimpleGrantedAuthority(Role.USER.getValue()));
		}
		
		return new User(m.getMid(), m.getPassword(),authorities);
	}


}
