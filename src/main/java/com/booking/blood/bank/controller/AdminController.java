package com.booking.blood.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.blood.bank.model.Bloodbank;
import com.booking.blood.bank.model.Bookings;
import com.booking.blood.bank.model.Users;
import com.booking.blood.bank.security.CustomUserDetails;
import com.booking.blood.bank.service.BloodBankService;
import com.booking.blood.bank.service.BookingService;
import com.booking.blood.bank.service.UserService;

@RestController
public class AdminController {
	@Autowired
	UserService service;
	
	@Autowired
	BloodBankService BloodBank_service;

	@Autowired
	BookingService bookings_service;
	
	@RequestMapping(value = "/admin/bloodbank/add", method = RequestMethod.POST)
	public Bloodbank createNewBloodBank(@RequestBody Bloodbank newBloodBank) {
		BloodBank_service.addBloodBank(newBloodBank);
		System.out.println(newBloodBank);
		return newBloodBank;
	}

	@RequestMapping(value = "/admin/bloodbank/update", method = RequestMethod.POST)
	public boolean updateBloodBank(@RequestBody Bloodbank updatedBloodBank) {
		try {
			int bloodBank_id = updatedBloodBank.getId();
			Optional<Bloodbank> bloodBank = BloodBank_service.getBloodBankById(bloodBank_id);

			if (bloodBank.isPresent()) {
				BloodBank_service.updateBloodBank(bloodBank_id, updatedBloodBank);
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

	@RequestMapping(value = "/admin/bloodbank/delete/{bloodBank_id}", method = RequestMethod.POST)
	public Bloodbank deleteBloodBank(@PathVariable int bloodBank_id) {
		Optional<Bloodbank> bloodBank = BloodBank_service.getBloodBankById(bloodBank_id);

		if (bloodBank.isPresent()) {
			BloodBank_service.deleteById(bloodBank_id);
			return bloodBank.get();
		}
		return null;
	}
	
	@RequestMapping(value = "/admin/blood/request/all", method = RequestMethod.GET)
	public List<Bookings> getAllBloodRequests() {
		return bookings_service.getAllBookings();
	}
	
	@RequestMapping(value = "/admin/blood/request/approve/{id}", method = RequestMethod.GET)
	public boolean createNewBloodBank(@PathVariable("id") int id) {
		return bookings_service.approveBloodRequest(id);
	}
	
	@RequestMapping(value = "/admin/register", method = RequestMethod.POST)
	public int register(@RequestBody Users user) {
		if(service.getUserByEmail(user.getUsername()) != null)
			return 400;
		Users newUser = new Users(user.getUsername(), user.getPassword(), user.getAddress(), true, "ADMIN");
		if (service.addUser(newUser)) {
			return 200;
		}
		return 401;
	}
	
	private int getLoggedInUserId(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof CustomUserDetails) {
			return ((CustomUserDetails) principal).getId();
		}
		System.out.println("loggedin userid: " + principal.toString());
		return -1;
	}
}
