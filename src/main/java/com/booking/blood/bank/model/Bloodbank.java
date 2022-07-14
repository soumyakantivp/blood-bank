package com.booking.blood.bank.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bloodbank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	@Embedded
	private BloodStoreMap bloodStoreMap;
	@OneToMany(mappedBy="bloodbank")
	private List<Bookings> bookings;
	
	public Bloodbank() {
		super();
	}
	
	public Bloodbank(String name, String address, BloodStoreMap bloodStoreMap) {
		super();
		this.name = name;
		this.address = address;
		this.bloodStoreMap = bloodStoreMap;
	}

	public Bloodbank(int id, String name, String address, BloodStoreMap bloodStoreMap) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.bloodStoreMap = bloodStoreMap;
	}


	
	public List<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public BloodStoreMap getBloodStoreMap() {
		return bloodStoreMap;
	}



	public void setBloodStoreMap(BloodStoreMap bloodStoreMap) {
		this.bloodStoreMap = bloodStoreMap;
	}



	@Override
	public String toString() {
		return "BloodBank [id=" + id + ", name=" + name + ", address=" + address + ", bloodStoreMap=" + bloodStoreMap
				+ "]";
	}


	
}
