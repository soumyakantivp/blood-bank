package com.booking.blood.bank.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.blood.bank.model.Users;

public interface UserRepo  extends JpaRepository<Users, Integer>{
	Optional<Users> findByusername(String username);
}
