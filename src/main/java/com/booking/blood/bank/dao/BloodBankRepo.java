package com.booking.blood.bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.blood.bank.model.Bloodbank;

@Repository
public interface BloodBankRepo extends JpaRepository<Bloodbank, Integer>{

}