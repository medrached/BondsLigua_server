package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;



@Entity
public class Client extends User implements Serializable {

	private double currentMoneyAccount;
	private double moneyInvested;
	private int cardNumber;
	
	@OneToMany(mappedBy="client")
	private List<Asset> listOfAssets;
	
	public double getCurrentMoneyAccount() {
		return currentMoneyAccount;
	}
	public void setCurrentMoneyAccount(double currentMoneyAccount) {
		this.currentMoneyAccount = currentMoneyAccount;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public double getMoneyInvested() {
		return moneyInvested;
	}
	public void setMoneyInvested(double moneyInvested) {
		this.moneyInvested = moneyInvested;
	}
	public List<Asset> getListOfAssets() {
		return listOfAssets;
	}
	public void setListOfAssets(List<Asset> listOfAssets) {
		this.listOfAssets = listOfAssets;
	}
	
	
	

	
	
	
	
	
	
	
}
