package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Company implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int immatriculationNumber;
	private float operatingIncome;
	private int freeShareNumber;
	private int tokenSharesNUmber;
	public int getImmatriculationNumber() {
		return immatriculationNumber;
	}
	public void setImmatriculationNumber(int immatriculationNumber) {
		this.immatriculationNumber = immatriculationNumber;
	}
	public float getOperatingIncome() {
		return operatingIncome;
	}
	public void setOperatingIncome(float operatingIncome) {
		this.operatingIncome = operatingIncome;
	}
	public int getFreeShareNumber() {
		return freeShareNumber;
	}
	public void setFreeShareNumber(int freeShareNumber) {
		this.freeShareNumber = freeShareNumber;
	}
	public int getTokenSharesNUmber() {
		return tokenSharesNUmber;
	}
	public void setTokenSharesNUmber(int tokenSharesNUmber) {
		this.tokenSharesNUmber = tokenSharesNUmber;
	}
	
	@OneToMany(mappedBy="company")
	private  List<Share> shares;
	
	public List<Share> getShares() {
		return shares;
	}
	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	
	
	
	
}
