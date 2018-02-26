package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
}
