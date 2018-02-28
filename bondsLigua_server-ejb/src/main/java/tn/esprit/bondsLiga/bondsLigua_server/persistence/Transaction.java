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
	
	@ManyToOne
	private  Portfolio portfolio;
	
	public Portfolio getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	
	@OneToMany(mappedBy="transaction")
	private List<Share> shares;

	public List<Share> getShares() {
		return shares;
	}
	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	
	
	
}
