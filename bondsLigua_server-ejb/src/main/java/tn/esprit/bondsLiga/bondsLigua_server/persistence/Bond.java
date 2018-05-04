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
	protected String issuer;
	private String startingDate;
	private String maturityDate;
	private double amount;
	private double price;
	private int paymentPeriod;
	private String confirmation;
	private String invester;
	private int idInvester;
	@ManyToOne
	private User user;
	private int link;
	
	public Bond() {
		super();
	}

	public Bond(int reference, int idIssuer,String issuer, String startingDate, String maturityDate, double amount, double price,
			int paymentPeriod, String confirmation, String invester,int idInvester, User user,int link) {
		super();
		this.reference = reference;
		this.idIssuer = idIssuer;
		this.issuer = issuer;
		this.startingDate = startingDate;
		this.maturityDate = maturityDate;
		this.amount = amount;
		this.price = price;
		this.paymentPeriod = paymentPeriod;
		this.confirmation = confirmation;
		this.invester = invester;
		this.idInvester=idInvester;
		this.user = user;
		this.link=link;
	}

	public Bond(int idIssuer,String issuer, String startingDate, String maturityDate, double amount, double price, int paymentPeriod,
			String confirmation, String invester,int idInvester, User user,int link) {
		super();
		this.idIssuer = idIssuer;
		this.issuer = issuer;
		this.startingDate = startingDate;
		this.maturityDate = maturityDate;
		this.amount = amount;
		this.price = price;
		this.paymentPeriod = paymentPeriod;
		this.confirmation = confirmation;
		this.invester = invester;
		this.idInvester=idInvester;
		this.user = user;
		this.link=link;
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

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public String getInvester() {
		return invester;
	}

	public void setInvester(String invester) {
		this.invester = invester;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getIdInvester() {
		return idInvester;
	}

	public void setIdInvester(int idInvester) {
		this.idInvester = idInvester;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}


	
	


	
	
	

}
