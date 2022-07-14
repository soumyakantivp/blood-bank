package com.booking.marraigehall.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.booking.blood.bank.dao.BloodBankRepo;
import com.booking.blood.bank.model.Bloodbank;
import com.booking.blood.bank.service.BloodBankService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HallServiceTest {
	@Autowired
	BloodBankService service;
	
	
	
	
	@Test
	public void getHallsByIdTest() {
		// TODO Auto-generated method stub
		//Optional<BloodBank> findById = service.getHallById(1);
		//System.out.println("in test"+findById);
	}

	
}
