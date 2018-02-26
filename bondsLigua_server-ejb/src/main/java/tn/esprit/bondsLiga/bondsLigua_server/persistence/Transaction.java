package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transID;
	private float tranValue;
	private float transPrice;
	public int getTransID() {
		return transID;
	}
	public void setTransID(int transID) {
		this.transID = transID;
	}
	public float getTranValue() {
		return tranValue;
	}
	public void setTranValue(float tranValue) {
		this.tranValue = tranValue;
	}
	public float getTransPrice() {
		return transPrice;
	}
	public void setTransPrice(float transPrice) {
		this.transPrice = transPrice;
	}
	
	
}
