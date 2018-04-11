package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import tn.esprit.bondsLiga.bondsLigua_server.persistence.Trader;

@Entity
@DiscriminatorValue(value="Zero Coupon")
public class BondZeroCoupon extends Bond implements Serializable {
	private double interestRate;
	
	

	public BondZeroCoupon() {
		super();
	}

	public BondZeroCoupon(double interestRate) {
		super();
		this.interestRate = interestRate;
	}
	
	



	public BondZeroCoupon(int reference, int idIssuer, String startingDate, String maturityDate, double amount,
			double price, int paymentPeriod,boolean confirmation,int idInvester, User user,double interestRate) {
		super(reference, idIssuer, startingDate, maturityDate, amount, price, paymentPeriod,confirmation,idInvester, user);
		this.interestRate = interestRate;
	}

	public BondZeroCoupon(int idIssuer, String startingDate, String maturityDate, double amount, double price,
			int paymentPeriod,boolean confirmation,int idInvester, User user,double interestRate) {
		super(idIssuer, startingDate, maturityDate, amount, price, paymentPeriod,confirmation,idInvester, user);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	

}
