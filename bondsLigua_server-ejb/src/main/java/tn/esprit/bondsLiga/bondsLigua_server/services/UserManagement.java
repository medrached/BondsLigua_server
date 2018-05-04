

package tn.esprit.bondsLiga.bondsLigua_server.services;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Session;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;




import tn.esprit.bondsLiga.bondsLigua_server.persistence.Administrator;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Client;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Trader;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.User;

import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;





@Stateless
@LocalBean
public class UserManagement implements IUserManagementRemote {
	
	@PersistenceContext(unitName="BONDSLIGA-ejb")
	private EntityManager em;

	@Override
	public void createAdmin(Administrator admin) {
		em.persist(admin);
		em.refresh(admin);	
		
	}

	
	
	
	
	@Override
	public List<Administrator> findAll(int userid) {
		
	
		String select = "select ua From Administrator ua where NOT ua.userId=:userid";
		Query query = em.createQuery(select);
		query.setParameter("userid",userid );
		return query.getResultList();
		
		
		
		
		
	}

	@Override
	public void deleteAdmin(Integer id) {
		em.remove(em.find(Administrator.class,id));		
	}

	@Override
	public void updateAdmin(Administrator admin) {
		
		em.merge(admin);

		
	}

	@Override
	public Administrator findAdminById(Integer id) {
		Administrator admin=em.find(Administrator.class,id);
		return admin;
	}

	@Override
	public void createTrader(Trader trader) {
		
	}

	@Override
	public List<Trader> findAllTraders() {
		return null;
	}

	@Override
	public void deleteTrader(Integer id) {
		
	}

	@Override
	public void updateTrader(Integer id) {

		
	}

	@Override
	public Trader findTraderById(Integer id) {
	
		return null;
	}

	@Override
	public void createClient(Client client) {
		em.persist(client);
		em.refresh(client);	
		
	}

	@Override
	public List<Client> findAllClients() {

		String select = "select ua From Client ua";
		Query query = em.createQuery(select);
		return query.getResultList();
		
		
	}

	@Override
	public int addAmount(int lastAmount,int amountToAdd) {
		
		return lastAmount+amountToAdd;
	}



	@Override
	public void deleteClient(Integer id) {
		
		
	}

	@Override
	public void updateClient(tn.esprit.bondsLiga.bondsLigua_server.persistence.Client c) {
		
		
		em.merge(c);
	}
	
	
	
	

	@Override
	public Map<String, Float> getDocumentXMLfromURL(String url) {
		
		Map<String,Float> curmap=new HashMap<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        try {
        	
        
        
        	Document  doc = factory.newDocumentBuilder().parse(new URL(url).openStream());        	
            doc.getDocumentElement().normalize();
            
          System.out.println(doc.toString());
        	
        	
        	
        	/*
        	NodeList nList = doc.getElementsByTagName("Cube");
        	for (int temp = 0; temp < nList.getLength(); temp++) {
        		Node nNode = nList.item(temp);
        		
        		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

        			Element eElement = (Element) nNode;
        			curmap.put(eElement.getAttribute("currency"),Float.parseFloat( eElement.getAttribute("rate")));
        			
        			
        			}
        	}
        	*/
        
        	return curmap;
        	
        	
        } catch (SAXException | IOException | ParserConfigurationException e) {
			
			e.printStackTrace();
		}
        
        return null;
		
	}



	@Override
	public Trader findClientById(Integer id) {
		return null;
	}

	@Override
	public boolean adminExists(String login, String pwd) {
		
		
		boolean b=false;
		String select = "SELECT ad FROM Administrator ad WHERE ad.username=:userName and ad.pwd=:password";
		Query query = em.createQuery(select);
		query.setParameter("userName", login);
		query.setParameter("password", pwd);
		List<User> lu=query.getResultList();
		if(!lu.isEmpty())
	{
		b=true;
		}
		return b;
		
	}


	@Override
	public boolean traderExists(String login, String pwdd) {
		
		
		boolean b=false;
		String select = "SELECT t FROM Trader t WHERE t.username=:userName and t.pwd=:password";
		Query query = em.createQuery(select);
		query.setParameter("userName", login);
		query.setParameter("password", pwdd);
		List<User> lu=query.getResultList();
		if(!lu.isEmpty())
	{
		b=true;
		}
		return b;
		
	}
	
	
	@Override
	public boolean clientExists(String login, String pwd) {
		
		
		boolean b=false;
		String select = "SELECT c FROM Client c WHERE c.username=:userName and c.pwd=:password";
		Query query = em.createQuery(select);
		query.setParameter("userName", login);
		query.setParameter("password", pwd);
		List<User> lu=query.getResultList();
		if(!lu.isEmpty())
	{
		b=true;
		}
		return b;
		
	}

	@Override
	public void upgradePrivilege(Integer id) {
		Administrator adminfound=em.find(Administrator.class,id);
		if(adminfound.getPrivileges().equals("Administrator")){
			adminfound.setPrivileges("Super admin");

		}
		else if(adminfound.getPrivileges().equals("Super admin"))
		{
			adminfound.setPrivileges("Supervisor");
		}
		else if(adminfound.getPrivileges().equals("Supervisor"))
		{		/*
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Upgrade not allawed");
	        alert.setHeaderText("This administrator account has already the best degree");
	        alert.show();
			*/
		}
			
		
		em.merge(adminfound);
		
	}



	@Override
	public void validateAdmin(Integer id) {
		Administrator adminfound=em.find(Administrator.class,id);
		if(adminfound.getValidationLevel()<2){
			adminfound.setValidationLevel(adminfound.getValidationLevel()+1);

		}
		
		else{
	       /* Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("This Administrator is already validate");
	        alert.setHeaderText("This administrator account has already the best degree");
	        alert.show();
	        */
		}
		
			
		
		em.merge(adminfound);
		
	}



	@Override
	public void banAcountAdmin(Integer id) {
		
		
		
		Administrator adminfound=em.find(Administrator.class,id);
		if(adminfound.getValidationLevel()!=0 ){
			adminfound.setValidationLevel(0);

		}
		
		else{
			/*
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Bann refused ");
	        alert.setHeaderText("This Administrator isn't active he can't be banned");
	        alert.show();
	        */
		}
		
			
		
		em.merge(adminfound);
		
	}



	@Override
	public List<Administrator> searchAdmins(String s, int myId) {
		

		String select = "SELECT ad FROM Administrator ad WHERE ( ad.username like :userName or ad.firstName like :firstName or ad.lastName like :lastName or ad.nationality like :nationality  ) AND  ad.userId<>:myId ";
		Query query = em.createQuery(select);
		query.setParameter("userName","%"+ s+"%");
		query.setParameter("firstName", "%"+ s+"%");
		query.setParameter("lastName", "%"+ s+"%");
		query.setParameter("nationality", "%"+ s+"%");
	//	query.setParameter("birthDate", "%"+ s+"%");
		query.setParameter("myId",myId);
		
		
		return query.getResultList();
	}



	@Override
	public Administrator returnAdminConnected(String login,String pwd) {
		String select = "SELECT ad FROM Administrator ad WHERE ad.username=:userName and ad.pwd=:password";
		Query query = em.createQuery(select);
		query.setParameter("userName", login);
		query.setParameter("password", pwd);
		return (Administrator)query.getSingleResult();
		
		
	}	



	@Override
	public Trader returnTraderConnected(String login,String pwd) {
		String select = "SELECT t FROM Trader t WHERE t.username=:userName and t.pwd=:password";
		Query query = em.createQuery(select);
		query.setParameter("userName", login);
		query.setParameter("password", pwd);
		return (Trader)query.getSingleResult();
	}



	@Override
	public Client returnClientConnected(String login,String pwd) {
		String select = "SELECT c FROM Client c WHERE c.username=:userName and c.pwd=:password";
		Query query = em.createQuery(select);
		query.setParameter("userName", login);
		query.setParameter("password", pwd);
		return (Client)query.getSingleResult();
		
		
	}



	@Override
	public int generateBankingCode() {
		tn.esprit.bondsLiga.bondsLigua_server.util.CreditCardNumberGenerator cd=new tn.esprit.bondsLiga.bondsLigua_server.util.CreditCardNumberGenerator();
		return	Integer.parseInt(cd.generate("456", 5));
	
		
	}



	@Override
	public List<Float> statisticsOfTheCurrency(String s) {

		List<Float> liste=new ArrayList();
		if(s.equals("USD"))
		{
			liste.add(new Float(1.2));
			liste.add(new Float(1.5));
			liste.add(new Float(0.7));
			liste.add(new Float(2.6));
			liste.add(new Float(0.2));
		}
		else if(s.equals("EUR"))
		{
			liste.add(new Float(5.1));
			liste.add(new Float(2.2));
			liste.add(new Float(0.2));
			liste.add(new Float(5.3));
		}
		return liste;
	}


	
	



	@Override
	public Map<String,Float> actualCurrencies(){

		  
		
	
		Map<String,Float> map=new HashMap();
		map.put("USD", new Float(1.2));
		map.put("EUR",new Float(3.2));
		map.put("GBP", new Float(1.2));
		map.put("INR",new Float(3.2));
		map.put("AUD", new Float(1.2));
		map.put("CAD",new Float(3.2));
		map.put("SGD", new Float(1.2));
		map.put("CHF",new Float(3.2));
		map.put("MYR", new Float(1.2));
		map.put("JPY",new Float(3.2));
		map.put("CNY", new Float(1.2));
		
		
		return map;
	
	}
	
	
	





	@Override
	public double investMOney(double startingMoney,List<Integer> money, List<Double> rate) {
		
		double res=startingMoney;
		for(int i=0;i<money.size();i++)
		{
			res=res-money.get(i)*(double)rate.get(i);
			
		}
		return res;
	}
	
	
	@Override
	public double myNewMoneyAccount(List<Double> rates,List<Integer> amounts){
			double total=0;
			for(int j=0;j<rates.size();j++){
				total=total+rates.get(j)*amounts.get(j);
			}
		
		return total;
	}





	@Override
	public Map<String, Float> clientStatsMoneyInvested() {
		
		Map<String,Float> map=new HashMap();
		
		String select = "select ua From Client ua ";
		Query query = em.createQuery(select);
		List<Client> cl=query.getResultList();
		for(Client c : cl){
			map.put(c.getUsername(),Float.parseFloat(String.valueOf( c.getMoneyInvested())));
			
		}
		return map;
		
	}





	@Override
	public Map<String, Float> clientStatsCurrentMoney() {
		Map<String,Float> map=new HashMap();
		
		String select = "select ua From Client ua ";
		Query query = em.createQuery(select);
		List<Client> cl=query.getResultList();
		for(Client c : cl){
			map.put(c.getUsername(),Float.parseFloat(String.valueOf( c.getCurrentMoneyAccount())));
			
		}
		return map;
	}





	@Override
	public Map<String, Integer> adminStatsRole() {
		Map<String,Integer> map=new HashMap();
		
		String selectAdmin = "select count(*) from administrator where privileges='Administrator' ";
		Query query = em.createNativeQuery(selectAdmin);
		List<Integer> liste=query.getResultList();
		map.put("Administrator",Integer.parseInt(String.valueOf(liste.get(0))) );
		System.out.println(liste.get(0));
		
		String selectSuper = "select count(*) from administrator where privileges='Super admin'  ";
		Query query2 = em.createNativeQuery(selectSuper);
		List<Integer> liste2=query2.getResultList();
		map.put("Super admin", Integer.parseInt(String.valueOf(liste2.get(0))));
		System.out.println(liste2.get(0));

		
		String selectVisor = "select count(*) from administrator where privileges='Supervisor'  ";
		Query query3 = em.createNativeQuery(selectVisor);
		List<Integer> liste3=query3.getResultList();
		map.put("Supervisor", Integer.parseInt(String.valueOf(liste3.get(0))));
		System.out.println(liste3.get(0));

		
		return map;
		
	}

	
	
	
}
