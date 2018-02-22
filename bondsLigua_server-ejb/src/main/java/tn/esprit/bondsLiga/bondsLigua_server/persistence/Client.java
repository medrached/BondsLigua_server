package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="client")
public class Client extends User implements Serializable {

	private int current_money_account;
	private int card_number;
	public int getCurrent_money_account() {
		return current_money_account;
	}
	public void setCurrent_money_account(int current_money_account) {
		this.current_money_account = current_money_account;
	}
	public int getCard_number() {
		return card_number;
	}
	public void setCard_number(int card_number) {
		this.card_number = card_number;
	}
	
	
	
	
}
