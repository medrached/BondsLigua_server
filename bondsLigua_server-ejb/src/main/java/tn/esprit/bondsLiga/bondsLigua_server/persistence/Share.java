package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Share implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reference;
	private float price;
	private float PotentialFluctuationState;
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getPotentialFluctuationState() {
		return PotentialFluctuationState;
	}
	public void setPotentialFluctuationState(float potentialFluctuationState) {
		PotentialFluctuationState = potentialFluctuationState;
	}
	
	@ManyToOne
	private Transaction transaction;
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	@ManyToOne
	private Company company;
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	

	
}
