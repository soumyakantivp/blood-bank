package com.booking.blood.bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.blood.bank.dao.BookingsRepo;
import com.booking.blood.bank.dao.UserRepo;
import com.booking.blood.bank.model.Bookings;
import com.booking.blood.bank.model.Users;

@Service
public class UserService {
	
	@Autowired
	UserRepo repo;
	
	@Autowired 
	BookingsRepo booking_repo;
	
	public boolean addUser(Users newUser) {
		// TODO Auto-generated method stub
		if(repo.findByusername(newUser.getUsername()).equals(Optional.empty())) {
			repo.save(newUser);
			return true;
		}
		return false;
	}

	public void addBookings(Bookings newBooking) {
		// TODO Auto-generated method stub
		booking_repo.save(newBooking);
	}
	
	
	
}
