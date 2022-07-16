package com.booking.blood.bank.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.booking.blood.bank.dao.BloodBankRepo;
import com.booking.blood.bank.dao.BookingsRepo;
import com.booking.blood.bank.model.BloodPriceMap;
import com.booking.blood.bank.model.BloodStoreMap;
import com.booking.blood.bank.model.Bloodbank;
import com.booking.blood.bank.model.Bookings;

@Service
public class BookingService {
	@Autowired
	BookingsRepo booking_repo;

	@Autowired
	BloodBankRepo bloodbank_repo;
	
	@Autowired
	BloodPriceMap bloodPriceMap;

	public List<Bookings> getAllBookings() {
		// TODO Auto-generated method stub
		return booking_repo.findAll();
	}

	public boolean createNewBooking(Bookings booking) {
		// TODO Auto-generated method stub
		booking.setUseraddress(booking.getUser().getAddress());
		booking.setUseremail(booking.getUser().getUsername());
		booking.setBloodbankaddress(booking.getBloodbank().getAddress());
		booking.setBloodbankname(booking.getBloodbank().getName());
		booking.setStatus("requested");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		booking.setOrderdate(formatter.format(date));
		String type = booking.getType();
		Bloodbank bank = bloodbank_repo.findById(booking.getBloodbank().getId()).get();
		System.out.println(bloodPriceMap.getAplus());
		if (bank == null)
			return false;
		BloodStoreMap bloodStoreMap = bank.getBloodStoreMap();
		if (type.equalsIgnoreCase("a+")) {
			double updatedAmount = bloodStoreMap.getAplus() - booking.getAmount();
			if (updatedAmount < 0)
				return false;
			booking.setPrice(bloodPriceMap.getAplus()*booking.getAmount());
			bloodStoreMap.setAplus(updatedAmount);
		} else if (type.equalsIgnoreCase("a-")) {
			double updatedAmount = bloodStoreMap.getAminus() - booking.getAmount();
			if (updatedAmount < 0)
				return false;
			booking.setPrice(bloodPriceMap.getAminus()*booking.getAmount());
			bloodStoreMap.setAminus(updatedAmount);
		} else if (type.equalsIgnoreCase("b+")) {
			double updatedAmount = bloodStoreMap.getBplus() - booking.getAmount();
			if (updatedAmount < 0)
				return false;
			booking.setPrice(bloodPriceMap.getBplus()*booking.getAmount());
			bloodStoreMap.setBplus(updatedAmount);
		} else if (type.equalsIgnoreCase("b-")) {
			double updatedAmount = bloodStoreMap.getBminus() - booking.getAmount();
			if (updatedAmount < 0)
				return false;
			booking.setPrice(bloodPriceMap.getBminus()*booking.getAmount());
			bloodStoreMap.setBminus(updatedAmount);
		} else if (type.equalsIgnoreCase("ab+")) {
			double updatedAmount = bloodStoreMap.getAbplus() - booking.getAmount();
			if (updatedAmount < 0)
				return false;
			booking.setPrice(bloodPriceMap.getAbplus()*booking.getAmount());
			bloodStoreMap.setAbplus(updatedAmount);
		} else if (type.equalsIgnoreCase("ab-")) {
			double updatedAmount = bloodStoreMap.getAbminus() - booking.getAmount();
			if (updatedAmount < 0)
				return false;
			booking.setPrice(bloodPriceMap.getAbminus()*booking.getAmount());
			bloodStoreMap.setAbminus(updatedAmount);
		} else if (type.equalsIgnoreCase("o+")) {
			double updatedAmount = bloodStoreMap.getOplus() - booking.getAmount();
			if (updatedAmount < 0)
				return false;
			booking.setPrice(bloodPriceMap.getOplus()*booking.getAmount());
			bloodStoreMap.setOplus(updatedAmount);
		} else if (type.equalsIgnoreCase("o-")) {
			double updatedAmount = bloodStoreMap.getOminus() - booking.getAmount();
			if (updatedAmount < 0)
				return false;
			booking.setPrice(bloodPriceMap.getOminus()*booking.getAmount());
			bloodStoreMap.setOminus(updatedAmount);
		} else {
			return false;
		}
		bank.setBloodStoreMap(bloodStoreMap);
		bloodbank_repo.save(bank);
		booking_repo.save(booking);
		return true;
	}

	public boolean approveBloodRequest(int id) {
		// TODO Auto-generated method stub

		try {
			Bookings booking = booking_repo.findById(id).get();
			booking.setStatus("approved");
			booking_repo.save(booking);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
