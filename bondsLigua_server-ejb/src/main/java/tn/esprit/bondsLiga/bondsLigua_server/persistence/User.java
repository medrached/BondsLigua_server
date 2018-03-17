package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;
import java.sql.Date;

import javax.enterprise.context.Destroyed;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	
	private String username;
	private String pwd;
	private String first_name;
	private String last_name;
	private String nationality;
	@Temporal(TemporalType.DATE)
	private java.util.Date birthDate;
	@Temporal(TemporalType.DATE)
	private java.util.Date inscription_date;
	private String email;
	
	
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	
	public java.util.Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(java.util.Date birthDate) {
		this.birthDate = birthDate;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
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
	
	
	
	
	public java.util.Date getInscription_date() {
		return inscription_date;
	}
	public void setInscription_date(java.util.Date inscription_date) {
		this.inscription_date = inscription_date;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", pwd=" + pwd + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", nationality=" + nationality + ", birthDate=" + birthDate
				+ ", inscription_date=" + inscription_date + ", email=" + email + "]";
	}
	
	
	
	
	

	

	


}	
