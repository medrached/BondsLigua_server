package tn.esprit.bondsLiga.bondsLigua_server.services;

import java.util.ArrayList;

import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	public List<Administrator> findAll() {
		
		String select = "select ua From Administrator ua";
		Query query = em.createQuery(select);
		return query.getResultList();
		
		
		
		
		
		/*
	TypedQuery<Administrator> query = em.createQuery("SELECT ad  FROM ad", Administrator.class);
		return query.getResultList();
		
		*/
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
		// TODO Auto-generated method stub
		
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
	public boolean userExists(String login, String pwd) {
		
		
		boolean b=false;
		String select = "SELECT u FROM User u WHERE u.username=:userName and u.pwd=:password";
		Query query = em.createQuery(select);
		query.setParameter("userName", login);
		query.setParameter("password", pwd);
		List<User> lu=query.getResultList();
		if(lu.size()!=0)
	{
		b=true;
		}
		return b;
		
	}



	@Override
	public void upgradePrivilege(Integer id) {
		Administrator adminfound=em.find(Administrator.class,id);
		if(adminfound.getPrivileges().equals("admin")){
			adminfound.setPrivileges("super admin");

		}
		else if(adminfound.getPrivileges().equals("super admin"))
		{
			adminfound.setPrivileges("supervisor");
		}
		else if(adminfound.getPrivileges().equals("supervisor"))
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
		if(adminfound.getValidation_level()<2){
			adminfound.setValidation_level(adminfound.getValidation_level()+1);

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
		if(adminfound.getValidation_level()!=0 ){
			adminfound.setValidation_level(0);

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
	public List<Administrator> searchAdmins(String s) {

		String select = "SELECT u FROM User u WHERE u.username=:userName or u.pwd=:password";
		Query query = em.createQuery(select);
		query.setParameter("userName", s);
		query.setParameter("password", s);
		return query.getResultList();

		
	}




                     
	
	
	
}
