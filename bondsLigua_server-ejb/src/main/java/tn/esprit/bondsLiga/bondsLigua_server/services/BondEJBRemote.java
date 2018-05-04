package tn.esprit.bondsLiga.bondsLigua_server.services;

import java.util.List;

import javax.ejb.Remote;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Bond;


@Remote
public interface BondEJBRemote {
	public void addBond(Bond bond);
	public void updateBond(Bond bond);
	public void deleteBond(int a);
	public List<Bond> displayAll(int idIssuer);
	public List<Bond> displayOffers(int idInvester);
	public List<Bond> displayNegotiated(int idIssuer);
	public List<Bond> displayConfirmed(int idIssuer);
	
}
