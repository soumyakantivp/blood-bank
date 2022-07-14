package com.booking.blood.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.blood.bank.dao.BloodBankRepo;
import com.booking.blood.bank.model.Bloodbank;

@Service
public class BloodBankService {
	
	@Autowired
	BloodBankRepo repo;
	
	public List<Bloodbank> getBloodBanks() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void addBloodBank(Bloodbank newBloodBank) {
		repo.save(newBloodBank);
	}

	public Optional<Bloodbank> getBloodBankById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public void updateBloodBank(int id, Bloodbank newBloodBank) {
		// TODO Auto-generated method stub
		Optional<Bloodbank> oBloodBank = repo.findById(id);
		
		if(oBloodBank.isPresent()) {
			Bloodbank BloodBank = oBloodBank.get();
			BloodBank.setName(newBloodBank.getName());
			BloodBank.setAddress(newBloodBank.getAddress());
			BloodBank.setBloodStoreMap(newBloodBank.getBloodStoreMap());
			repo.save(BloodBank);
		}
		else {
			System.out.println("update failed! no bloodbank found with id: "+id);
		}
		
	}

	public void deleteById(int BloodBank_id) {
		// TODO Auto-generated method stub
		repo.deleteById(BloodBank_id);
	}
}
