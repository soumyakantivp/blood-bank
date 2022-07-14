package com.booking.blood.bank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.blood.bank.model.BloodStoreMap;
import com.booking.blood.bank.model.Bloodbank;
import com.booking.blood.bank.security.CustomUserDetails;
import com.booking.blood.bank.service.BloodBankService;

@RestController
public class AdminController {
	@Autowired
	BloodBankService BloodBank_service;

	@RequestMapping(value = "/admin/bloodbank/add", method = RequestMethod.POST)
	public Bloodbank createNewBloodBank(@RequestBody Bloodbank newBloodBank) {
		BloodBank_service.addBloodBank(newBloodBank);
		System.out.println(newBloodBank);
		return newBloodBank;
	}

	@RequestMapping(value = "/admin/bloodbank/update/{bloodBank_id}", method = RequestMethod.GET)
	public Bloodbank updateBloodBank(@PathVariable("bloodBank_id") int bloodBank_id,
			@RequestBody Bloodbank updatedBloodBank) {
		Optional<Bloodbank> bloodBank = BloodBank_service.getBloodBankById(bloodBank_id);

		if (bloodBank.isPresent()) {
			BloodBank_service.updateBloodBank(bloodBank_id, updatedBloodBank);
			return updatedBloodBank;
		}
		return null;
	}

	@RequestMapping(value = "/admin/bloodbank/delete/{bloodBank_id}", method = RequestMethod.GET)
	public Bloodbank deleteBloodBank(@PathVariable int bloodBank_id) {
		Optional<Bloodbank> bloodBank = BloodBank_service.getBloodBankById(bloodBank_id);

		if (bloodBank.isPresent()) {
			BloodBank_service.deleteById(bloodBank_id);
			return bloodBank.get();
		}
		return null;
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
