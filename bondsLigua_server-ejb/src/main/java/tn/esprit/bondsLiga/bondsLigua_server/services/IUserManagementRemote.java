package tn.esprit.bondsLiga.bondsLigua_server.services;


import java.util.Map;
import java.util.*;
import javax.ejb.Remote;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Administrator;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Client;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Trader;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.User;




@Remote
public interface IUserManagementRemote {
	
	
	public void createAdmin(Administrator admin);
	public java.util.List<Administrator> findAll( int userid);
	public java.util.List<Administrator> searchAdmins(String s,int myId);
	public void deleteAdmin(Integer id);
	public void upgradePrivilege(Integer id);
	public void validateAdmin(Integer id);
	public void banAcountAdmin(Integer id);
	public void updateAdmin(Administrator admin);
	public Administrator findAdminById(Integer id);
	public int addAmount(int lastAmount,int amountToAdd);

	
	
	public void createTrader(Trader trader);
	public java.util.List<Trader> findAllTraders();
	public void deleteTrader(Integer id);
	public void updateTrader(Integer id);
	public Trader findTraderById(Integer id);

	
	public void createClient(tn.esprit.bondsLiga.bondsLigua_server.persistence.Client client);
	public java.util.List<tn.esprit.bondsLiga.bondsLigua_server.persistence.Client> findAllClients();
	public void deleteClient(Integer id);
	public void updateClient(Client c);
	public Trader findClientById(Integer id);
	public int generateBankingCode();
	
	public Map<String,Float> getDocumentXMLfromURL(String url);
	
	public Administrator returnAdminConnected(String login,String pwd);
	public  Trader returnTraderConnected(String login,String pwd);
	public  tn.esprit.bondsLiga.bondsLigua_server.persistence.Client returnClientConnected(String login,String pwd);


	public boolean adminExists(String login,String pwd);
	public boolean traderExists(String login,String pwd);
	public boolean clientExists(String login ,String pwd);

	

	public java.util.List<Float> statisticsOfTheCurrency(String s);
	public Map<String,Float> actualCurrencies();
	public double investMOney(double startingMoney,List<Integer> money,List<Double> rate);
	public double myNewMoneyAccount(List<Double> rates,List<Integer>amounts); 
	public Map<String,Float> clientStatsMoneyInvested();
	public Map<String,Float> clientStatsCurrentMoney();
	public Map<String,Integer> adminStatsRole();
	
	
	
	



}



