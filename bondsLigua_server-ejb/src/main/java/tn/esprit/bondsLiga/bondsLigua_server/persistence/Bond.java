package tn.esprit.bondsLiga.bondsLigua_server.persistence;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import tn.esprit.bondsLiga.bondsLigua_server.persistence.Trader;




@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="bondType")
public class Bond implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reference;
	private int idIssuer;
	
	private String startingDate;
	private String maturityDate;
	private double amount;
	private double price;
	private int paymentPeriod;
	@ManyToOne
	private Trader trader;
	
	public Bond() {
		super();
	}

	public Bond(int reference, int idIssuer, String startingDate, String maturityDate, double amount, double price,
			int paymentPeriod, Trader trader) {
		super();
		this.reference = reference;
		this.idIssuer = idIssuer;
		this.startingDate = startingDate;
		this.maturityDate = maturityDate;
		this.amount = amount;
		this.price = price;
		this.paymentPeriod = paymentPeriod;
		this.trader = trader;
	}

	public Bond(int idIssuer, String startingDate, String maturityDate, double amount, double price, int paymentPeriod,
			Trader trader) {
		super();
		this.idIssuer = idIssuer;
		this.startingDate = startingDate;
		this.maturityDate = maturityDate;
		this.amount = amount;
		this.price = price;
		this.paymentPeriod = paymentPeriod;
		this.trader = trader;
	}
	
	

	public Bond(int reference, int idIssuer, String startingDate, String maturityDate, double amount, double price,
			int paymentPeriod) {
		super();
		this.reference = reference;
		this.idIssuer = idIssuer;
		this.startingDate = startingDate;
		this.maturityDate = maturityDate;
		this.amount = amount;
		this.price = price;
		this.paymentPeriod = paymentPeriod;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public int getIdIssuer() {
		return idIssuer;
	}

	public void setIdIssuer(int idIssuer) {
		this.idIssuer = idIssuer;
	}

	public String getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public String getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPaymentPeriod() {
		return paymentPeriod;
	}

	public void setPaymentPeriod(int paymentPeriod) {
		this.paymentPeriod = paymentPeriod;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	
	
	

}
