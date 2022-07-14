package com.booking.blood.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.blood.bank.model.Bookings;

public interface BookingsRepo extends JpaRepository<Bookings, Integer>{

}
