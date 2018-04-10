package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Annual Annuities")
public class BondAnnualAnnuities extends Bond implements Serializable {
	
	private int numberOfCouponsPaid;
	private int numberOfCouponsToPay;
	private double couponValue;
	
	
	
	public BondAnnualAnnuities() {
		super();
	}
	public BondAnnualAnnuities(int numberOfCouponsPaid, int numberOfCouponsToPay, double couponValue) {
		super();
		this.numberOfCouponsPaid = numberOfCouponsPaid;
		this.numberOfCouponsToPay = numberOfCouponsToPay;
		this.couponValue = couponValue;
	}
	public int getNumberOfCouponsPaid() {
		return numberOfCouponsPaid;
	}
	public void setNumberOfCouponsPaid(int numberOfCouponsPaid) {
		this.numberOfCouponsPaid = numberOfCouponsPaid;
	}
	public int getNumberOfCouponsToPay() {
		return numberOfCouponsToPay;
	}
	public void setNumberOfCouponsToPay(int numberOfCouponsToPay) {
		this.numberOfCouponsToPay = numberOfCouponsToPay;
	}
	public double getCouponValue() {
		return couponValue;
	}
	public void setCouponValue(double couponValue) {
		this.couponValue = couponValue;
	}
	
	

}
