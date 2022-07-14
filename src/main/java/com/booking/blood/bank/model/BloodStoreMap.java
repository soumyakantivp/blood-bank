package com.booking.blood.bank.model;

import javax.persistence.Embeddable;

@Embeddable
public class BloodStoreMap {
	// to store quatity of blood available in litres
	private double oplus;
	private double ominus;
	private double aplus;
	private double aminus;
	private double bplus;
	private double bminus;
	private double abplus;
	private double abminus;
	public double getOplus() {
		return oplus;
	}
	public void setOplus(double oplus) {
		this.oplus = oplus;
	}
	public double getOminus() {
		return ominus;
	}
	public void setOminus(double ominus) {
		this.ominus = ominus;
	}
	public double getAplus() {
		return aplus;
	}
	public void setAplus(double aplus) {
		this.aplus = aplus;
	}
	public double getAminus() {
		return aminus;
	}
	public void setAminus(double aminus) {
		this.aminus = aminus;
	}
	public double getBplus() {
		return bplus;
	}
	public void setBplus(double bplus) {
		this.bplus = bplus;
	}
	public double getBminus() {
		return bminus;
	}
	public void setBminus(double bminus) {
		this.bminus = bminus;
	}
	public double getAbplus() {
		return abplus;
	}
	public void setAbplus(double abplus) {
		this.abplus = abplus;
	}
	public double getAbminus() {
		return abminus;
	}
	public void setAbminus(double abminus) {
		this.abminus = abminus;
	}
	public BloodStoreMap(double oplus, double ominus, double aplus, double aminus, double bplus, double bminus,
			double abplus, double abminus) {
		super();
		this.oplus = oplus;
		this.ominus = ominus;
		this.aplus = aplus;
		this.aminus = aminus;
		this.bplus = bplus;
		this.bminus = bminus;
		this.abplus = abplus;
		this.abminus = abminus;
	}
	public BloodStoreMap() {
		super();
	}
	@Override
	public String toString() {
		return "BloodStoreMap [oplus=" + oplus + ", ominus=" + ominus + ", aplus=" + aplus + ", aminus=" + aminus
				+ ", bplus=" + bplus + ", bminus=" + bminus + ", abplus=" + abplus + ", abminus=" + abminus + "]";
	}
	
	
}
