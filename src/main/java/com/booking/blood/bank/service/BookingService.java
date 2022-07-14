package com.booking.blood.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.blood.bank.dao.BookingsRepo;
import com.booking.blood.bank.model.Bookings;

@Service
public class BookingService {
	@Autowired
	BookingsRepo repo;
	
	public List<Bookings> getAllBookings() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	public void createNewBooking(Bookings booking) {
		// TODO Auto-generated method stub
		repo.save(booking);
	}
}
