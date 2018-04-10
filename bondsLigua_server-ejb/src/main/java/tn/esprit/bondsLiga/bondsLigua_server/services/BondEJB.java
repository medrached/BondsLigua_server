package tn.esprit.bondsLiga.bondsLigua_server.services;



import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.bondsLiga.bondsLigua_server.persistence.Bond;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.BondAnnualAnnuities;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.BondBiAnnualAnnuities;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.BondContinuousCompounding;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.BondZeroCoupon;

@Stateless
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
	public List<Bond> displayAll() {
		return em.createQuery("SELECT b FROM Bond b", Bond.class).getResultList();
	}

}
