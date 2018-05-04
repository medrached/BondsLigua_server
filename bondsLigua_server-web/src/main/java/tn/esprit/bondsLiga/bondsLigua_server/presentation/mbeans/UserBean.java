package tn.esprit.bondsLiga.bondsLigua_server.presentation.mbeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tn.esprit.bondsLiga.bondsLigua_server.persistence.Administrator;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Client;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Portfolio;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Trader;
import tn.esprit.bondsLiga.bondsLigua_server.services.UserManagement;

@ManagedBean
@SessionScoped
public class UserBean {

	boolean loggedIn;
	
	private Client client;
	private Administrator admin;
	private Trader trader;
	//user
	private int userId;
	
	private String username;
	private String pwd;
	private String firstName;
	private String lastName;
	private String nationality;
	private java.util.Date birthDate;
	private java.util.Date inscriptionDate;
	private String email;
	
	
	
	//trader
	private int cin;
	private int scoring;
	private Portfolio portfolio;
	
	//client
	private double currentMoneyAccount;
	private double moneyInvested;
	private int cardNumber;
	
	@EJB
	UserManagement userManagement;
	
	public void ajouterAdmin(Administrator admin )
	{
		userManagement.createAdmin(admin);
	}
	
	public void ajouterTrader()
	{
		Trader t=new Trader();
	
		
	}
	
	
	
	


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public java.util.Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(java.util.Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public int getScoring() {
		return scoring;
	}

	public void setScoring(int scoring) {
		this.scoring = scoring;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public double getCurrentMoneyAccount() {
		return currentMoneyAccount;
	}

	public void setCurrentMoneyAccount(double currentMoneyAccount) {
		this.currentMoneyAccount = currentMoneyAccount;
	}

	public double getMoneyInvested() {
		return moneyInvested;
	}

	public void setMoneyInvested(double moneyInvested) {
		this.moneyInvested = moneyInvested;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public UserManagement getUserManagement() {
		return userManagement;
	}

	public void setUserManagement(UserManagement userManagement) {
		this.userManagement = userManagement;
	}
	
	
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public String ajouterClient()
	{
		String redirect="login.jsf?faces-redirect=true";
		Client c =new Client();
		 c.setUserName(username);
			c.setLastName(lastName);
			c.setFirstName(firstName);
			c.setNationality(nationality);
			c.setPwd(pwd);
			c.setEmail(email);
			c.setBirthDate(birthDate);
			c.setInscriptionDate(new Date());
		userManagement.createClient(c);
		
		
		
	return redirect;
		
	}
	
	
	public String login(){
		
			String redirect="";
		if(userManagement.clientExists(username, pwd)){
			
			
		     redirect = "portfolio1.jsf?faces-redirect=true";
		
		    
		    this.client=userManagement.returnClientConnected(username, pwd);
		    
		    this.setUsername(client.getUsername());
		    this.setUserId(client.getUserId());
		    this.setBirthDate(client.getBirthDate());
		    this.setInscriptionDate(client.getInscriptionDate());
		    this.setMoneyInvested(client.getMoneyInvested());
		    this.setCardNumber(client.getCardNumber());
		    this.setMoneyInvested(client.getMoneyInvested());
		    this.setCurrentMoneyAccount(client.getCurrentMoneyAccount());
		    loggedIn=true;
		    
		}
		
		else if(userManagement.adminExists(username, pwd))
		{
			loggedIn=true; 
		}
		else if(userManagement.traderExists(username, pwd)){
			//redirection trader
			loggedIn=true; 

		}
		
	
		return redirect;
		
		
	}
	
	
	
	public boolean isLoggedIn(){
		
		return loggedIn;
	}
	
	public String deconnexion(){
		client=null;
		admin=null;
		trader=null;
		loggedIn=false;
		return "login.jsf?faces-redirect=true";
	}

	
}