package com.booking.blood.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.blood.bank.model.Bloodbank;
import com.booking.blood.bank.service.BloodBankService;

@RestController
public class BloodBankController {
	@Autowired
	BloodBankService service;

	
	@RequestMapping(value = "/bloodbank/all",method =RequestMethod.GET)
	public List<Bloodbank> getBloodBanks(){
		List<Bloodbank> list = new ArrayList<Bloodbank>();
		list = service.getBloodBanks();
		return list;
	}

}
