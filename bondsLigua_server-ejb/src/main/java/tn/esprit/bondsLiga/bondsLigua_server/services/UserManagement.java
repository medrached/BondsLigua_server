package tn.esprit.bondsLiga.bondsLigua_server.services;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.bondsLiga.bondsLigua_server.persistence.Administrator;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Client;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Trader;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.User;

@Stateless
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Trader> findAllTraders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTrader(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTrader(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Trader findTraderById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createClient(Client client) {
		em.persist(client);
		em.refresh(client);	
		
	}

	@Override
	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteClient(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClient(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Trader findClientById(Integer id) {
		// TODO Auto-generated method stub
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




                     
	
	
	
}
