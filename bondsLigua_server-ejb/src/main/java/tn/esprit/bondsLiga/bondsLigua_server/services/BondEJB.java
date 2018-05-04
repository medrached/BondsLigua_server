package tn.esprit.bondsLiga.bondsLigua_server.services;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.bondsLiga.bondsLigua_server.persistence.Bond;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.BondAnnualAnnuities;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.BondBiAnnualAnnuities;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.BondContinuousCompounding;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.BondZeroCoupon;

@Stateless
@LocalBean
public class BondEJB implements BondEJBRemote  {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void addBond(Bond bond) {
		if (bond instanceof BondAnnualAnnuities) {
			BondAnnualAnnuities bondAA = (BondAnnualAnnuities) bond;
			em.merge(bondAA);
		} else if (bond instanceof BondBiAnnualAnnuities) {
			BondBiAnnualAnnuities bondBAA = (BondBiAnnualAnnuities) bond;
			em.merge(bondBAA);
		} else if (bond instanceof BondContinuousCompounding) {
			BondContinuousCompounding bondCC = (BondContinuousCompounding) bond;
			em.merge(bondCC);
		} else if (bond instanceof BondZeroCoupon) {
			BondZeroCoupon bondZC = (BondZeroCoupon) bond;
			em.merge(bondZC);
		}
		
	}



	@Override
	public void deleteBond(int a) {
		em.remove(em.find(Bond.class,a));	
	}



	@Override
	public void updateBond(Bond bond) {
		em.merge(bond);
		
	}



	@Override
	public List<Bond> displayAll(int idIssuer) {
		TypedQuery<Bond> query=em.createQuery("select e from Bond "
				+ "e where e.idIssuer=:id and e.link=0",Bond.class);
		query.setParameter("id", idIssuer);
		List<Bond> b=query.getResultList();
				
		return b;
	}
	
	public List<Bond> displayOffers(int idIssuer){
		TypedQuery<Bond> query=em.createQuery("select e from Bond "
				+ "e where e.idIssuer <> :i and e.confirmation=:c ",Bond.class);
		query.setParameter("i", idIssuer);
		query.setParameter("c", "Created");
		List<Bond> b=query.getResultList();
				
		return b;
		
	}
	
	public List<Bond> displayPending(int idInvester){
		TypedQuery<Bond> query=em.createQuery("select e from Bond "
				+ "e where e.idInvester = :i and( e.confirmation=:p or e.confirmation=:n )",Bond.class);
		query.setParameter("i", idInvester);
		query.setParameter("p", "Pending");
		query.setParameter("n", "Negotiated");
		List<Bond> b=query.getResultList();
				
		return b;
		
	}
	
	public List<Bond> displayNegotiated(int idIssuer){
		TypedQuery<Bond> query=em.createQuery("select e from Bond "
				+ "e where e.idIssuer = :i and  (e.confirmation=:p or e.confirmation=:n ) ",Bond.class);
		query.setParameter("i", idIssuer);
		query.setParameter("p", "Pending");
		query.setParameter("n", "Negotiated");
		List<Bond> b=query.getResultList();
				
		return b;
		
	}
	
	public List<Bond> displayConfirmed(int idIssuer){
		TypedQuery<Bond> query=em.createQuery("select e from Bond "
				+ "e where (e.idIssuer = :i or e.idIssuer = :i) and e.confirmation=:c ",Bond.class);
		query.setParameter("i", idIssuer);
		query.setParameter("c", "Confirmed");
		List<Bond> b=query.getResultList();
				
		return b;
		
	}
	

}
