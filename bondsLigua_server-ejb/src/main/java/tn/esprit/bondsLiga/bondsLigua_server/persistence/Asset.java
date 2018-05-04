package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Asset implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reference;
	private String type;
	private float value;
	private float amortization;
	@ManyToOne
	private Client client;
	@Temporal(TemporalType.DATE)
	private Date FirstUseDate;
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public float getAmortization() {
		return amortization;
	}
	public void setAmortization(float amortization) {
		this.amortization = amortization;
	}
	public Date getFirstUseDate() {
		return FirstUseDate;
	}
	public void setFirstUseDate(Date firstUseDate) {
		FirstUseDate = firstUseDate;
	}
	

public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}




	
	

}
