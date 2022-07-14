package com.booking.blood.bank.security;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.booking.blood.bank.dao.UserRepo;
import com.booking.blood.bank.model.Users;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Users> user = userRepository.findByusername(username);
		
		user.orElseThrow(()->
			new UsernameNotFoundException("User not Found :: "+username)
		);
		
		return new CustomUserDetails(user.get());
		
		//return null;
	}

}
