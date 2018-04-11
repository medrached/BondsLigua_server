package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	private String username;
	private String pwd;
	private String firstName;
	private String lastName;
	private String nationality;
	@Temporal(TemporalType.DATE)
	private java.util.Date birthDate;
	@Temporal(TemporalType.DATE)
	private java.util.Date inscriptionDate;
	private String email;
	
	/*private List <Bond> bonds;
	
	@OneToMany(mappedBy="user")
	private List<Bond> getBonds()
	{
		return bonds;
	}
	
	private void setBonds(List<Bond> bonds)
	{
		this.bonds=bonds;
	}*/
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUserName(String username) {
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	public java.util.Date getInscriptionDate() {
		return inscriptionDate;
	}
	public void setInscriptionDate(java.util.Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", pwd=" + pwd + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", nationality=" + nationality + ", birthDate=" + birthDate
				+ ", inscriptionDate=" + inscriptionDate + ", email=" + email + "]";
	}

	
	
	
	
	
	

	

	


}	
