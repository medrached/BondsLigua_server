package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.xml.registry.infomodel.User;
@Entity
public class Administrator extends tn.esprit.bondsLiga.bondsLigua_server.persistence.User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String privileges;
	private int validation_level;
	

	public String getPrivileges() {
		return privileges;
	}	

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	public int getValidation_level() {
		return validation_level;
	}

	public void setValidation_level(int validation_level) {
		this.validation_level = validation_level;
	}

	@Override
	public String toString() {
		return super.toString()+"privileges=" + privileges + ", validation_level=" + validation_level + "]";
	}
	
	
	
	
	
	
}
