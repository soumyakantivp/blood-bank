package com.booking.blood.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.blood.bank.model.Bookings;

@Repository
public interface BookingsRepo extends JpaRepository<Bookings, Integer>{

}
