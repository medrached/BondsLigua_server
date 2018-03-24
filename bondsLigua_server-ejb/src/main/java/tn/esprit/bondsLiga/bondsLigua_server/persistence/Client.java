package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;
import javax.persistence.Entity;



@Entity
public class Client extends User implements Serializable {

	private int currentMoneyAccount;
	private int cardNumber;
	
	
	public int getCurrentMoneyAccount() {
		return currentMoneyAccount;
	}
	public void setCurrentMoneyAccount(int currentMoneyAccount) {
		this.currentMoneyAccount = currentMoneyAccount;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
	
	
}
