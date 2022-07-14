package com.booking.blood.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String type;
	private double amount;
	@ManyToOne
	private Bloodbank bloodbank;
	@ManyToOne
	private Users user;
	private double price;
	private String status;
	
	
	public Bookings() {
		super();
	}

	public Bookings(int id, String type, double amount, Bloodbank bloodbank, Users user, double price, String status) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.bloodbank = bloodbank;
		this.user = user;
		this.price = price;
		this.status = status;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Bloodbank getBloodbank() {
		return bloodbank;
	}


	public void setBloodbank(Bloodbank bloodbank) {
		this.bloodbank = bloodbank;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bookings [id=" + id + ", type=" + type + ", amount=" + amount + ", bloodbank=" + bloodbank + ", user="
				+ user + ", price=" + price + ", status=" + status + "]";
	}
}
