package com.booking.blood.bank.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="Bookings")
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String type; //group
	private double amount;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Bloodbank bloodbank;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Users user;
	private String useremail;
	private String useraddress;
	private String bloodbankname;
	private String bloodbankaddress;
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
		this.bloodbankname = bloodbank.getName();
		this.bloodbankaddress = bloodbank.getAddress();
		this.useremail = user.getUsername();
		this.useraddress = user.getAddress();
	}

	
	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getBloodbankname() {
		return bloodbankname;
	}

	public void setBloodbankname(String bloodbankname) {
		this.bloodbankname = bloodbankname;
	}

	public String getBloodbankaddress() {
		return bloodbankaddress;
	}

	public void setBloodbankaddress(String bloodbankaddress) {
		this.bloodbankaddress = bloodbankaddress;
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
				+ user + ", useremail=" + useremail + ", useraddress=" + useraddress + ", bloodbankname="
				+ bloodbankname + ", bloodbankaddress=" + bloodbankaddress + ", price=" + price + ", status=" + status
				+ "]";
	}

	
}
