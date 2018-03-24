package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Administrator extends tn.esprit.bondsLiga.bondsLigua_server.persistence.User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String privileges;
	private int validationLevel;
	

	public String getPrivileges() {
		return privileges;
	}	

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	public int getValidationLevel() {
		return validationLevel;
	}

	public void setValidationLevel(int validationLevel) {
		this.validationLevel = validationLevel;
	}

	@Override
	public String toString() {
		return super.toString()+"privileges=" + privileges + ", validation_level=" + validationLevel + "]";
	}
	
	
	
	
	
	
}
