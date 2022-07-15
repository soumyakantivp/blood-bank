package com.booking.blood.bank.service;

import java.util.List;
import java.util.Optional;

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
		booking.setUseraddress(booking.getUser().getAddress());
		booking.setUseremail(booking.getUser().getUsername());
		booking.setBloodbankaddress(booking.getBloodbank().getAddress());
		booking.setBloodbankname(booking.getBloodbank().getName());
		booking.setStatus("requested");
		repo.save(booking);
	}

	public boolean approveBloodRequest(int id) {
		// TODO Auto-generated method stub
		
		try {
			Bookings booking = repo.findById(id).get();
			booking.setStatus("approved");
			repo.save(booking);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
}
