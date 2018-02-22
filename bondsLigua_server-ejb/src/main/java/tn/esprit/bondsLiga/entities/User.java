package tn.esprit.bondsLiga.entities;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
	
	private String user_id;
	private String first_name;
	private String last_name;
	private Date inscription_date;
	
	
	
	
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	
	
	
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	
	
	
	public Date getInscription_date() {
		return inscription_date;
	}
	public void setInscription_date(Date inscription_date) {
		this.inscription_date = inscription_date;
	}
	
	

	


}	
