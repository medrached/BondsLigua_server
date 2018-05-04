package tn.esprit.bondsLiga.bondsLigua_server.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.ManyToOne;

import tn.esprit.bondsLiga.bondsLigua_server.persistence.Bond;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.BondAnnualAnnuities;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.BondBiAnnualAnnuities;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.BondContinuousCompounding;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.BondZeroCoupon;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.User;
import tn.esprit.bondsLiga.bondsLigua_server.services.BondEJB;



@ManagedBean
@SessionScoped
public class BondOfferBean {
	private int reference;
	private int idIssuer;
	protected String issuer;
	private String startingDate;
	private String maturityDate;
	private double amount;
	private double price;
	private int paymentPeriod;
	private String confirmation;
	private String invester;
	private int idInvester;
	private User user;
	private int link;
	private double interestRate;
	private List<Bond> bonds;
	private List<Bond> offers;
	private List<Bond> pending;
	private List<Bond> negotiated;
	private List<Bond> confirmed;
	private Integer bondIdToBeUpdated;	
	private Integer bondIdToBeNegotiated;
	
	
	@EJB
	BondEJB bondEJB;
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	public void addBond() {
		System.out.println(bondEJB.displayAll(userBean.getUserId()));
		bondEJB.addBond(new BondZeroCoupon(reference, userBean.getUserId(),userBean.getUsername(), startingDate, maturityDate, amount, price, paymentPeriod,"Created",invester,idInvester, user,link, interestRate));
		
	}

	public void deleteBond(int bondId) {
	bondEJB.deleteBond(bondId);
	}


	public void updateBond(BondZeroCoupon bond) {
	this.setIdIssuer(bond.getIdIssuer());
	this.setIssuer(bond.getIssuer());
	this.setConfirmation(bond.getConfirmation());
	this.setIdInvester(bond.getIdInvester());
	this.setInvester(bond.getInvester());
	this.setUser(bond.getUser());
	this.setLink(bond.getLink());
	this.setAmount(bond.getAmount());	
	this.setStartingDate(bond.getStartingDate());
	this.setMaturityDate(bond.getMaturityDate());
	this.setPrice(bond.getPrice());
	this.setPaymentPeriod(bond.getPaymentPeriod());
	this.setInterestRate(bond.getInterestRate());
	this.setBondIdToBeUpdated(bond.getReference());

	}

	public void sendNeg() {
		System.out.println(bondIdToBeNegotiated);
		bondEJB.addBond(new BondZeroCoupon(reference, idIssuer,issuer, startingDate, maturityDate, amount, price, paymentPeriod,"Negotiated",userBean.getUsername(),userBean.getUserId(), user,bondIdToBeNegotiated, interestRate));
	}

	//public List<Bond> displayAll() {}
	
	public void confirmOffer(BondZeroCoupon bond)
	{
		bondEJB.updateBond(new BondZeroCoupon(bond.getReference(),bond.getIdIssuer(),bond.getIssuer(), bond.getStartingDate(), bond.getMaturityDate(), bond.getAmount(), bond.getPrice(), bond.getPaymentPeriod(),"Pending",userBean.getUsername(),userBean.getUserId(), bond.getUser(),bond.getLink(), bond.getInterestRate()));
	    

	}
	
	public void negotiateBond(BondZeroCoupon bond){
		this.setIdIssuer(bond.getIdIssuer());
		this.setIssuer(bond.getIssuer());
		this.setConfirmation(bond.getConfirmation());
		this.setIdInvester(bond.getIdInvester());
		this.setInvester(bond.getInvester());
		this.setUser(bond.getUser());
		this.setLink(bond.getLink());
		this.setAmount(bond.getAmount());	
		this.setStartingDate(bond.getStartingDate());
		this.setMaturityDate(bond.getMaturityDate());
		this.setPrice(bond.getPrice());
		this.setPaymentPeriod(bond.getPaymentPeriod());
		this.setInterestRate(bond.getInterestRate());
		this.setBondIdToBeNegotiated(bond.getReference());

		}
	
	
	public void mettreAjourBond() {
		System.out.println(bondIdToBeUpdated);
		bondEJB.updateBond(new BondZeroCoupon(bondIdToBeUpdated, idIssuer,issuer, startingDate, maturityDate, amount, price, paymentPeriod,confirmation,invester,idInvester, user,link, interestRate));
	}

	
	public void confirmNeg(BondZeroCoupon bond){
		
		bondEJB.updateBond(new BondZeroCoupon(bond.getReference(),bond.getIdIssuer(),bond.getIssuer(), bond.getStartingDate(), bond.getMaturityDate(), bond.getAmount(), bond.getPrice(), bond.getPaymentPeriod(),"Confirmed",bond.getInvester(),bond.getIdInvester(), bond.getUser(),bond.getLink(), bond.getInterestRate()));
		if(bond.getLink()!=0)
		{
	    	bondEJB.deleteBond(bond.getLink());
	    }
	}
	
	public void declineNeg(BondZeroCoupon bond){
		bondEJB.updateBond(new BondZeroCoupon(bond.getReference(),bond.getIdIssuer(),bond.getIssuer(), bond.getStartingDate(), bond.getMaturityDate(), bond.getAmount(), bond.getPrice(), bond.getPaymentPeriod(),"Created","",0, bond.getUser(),0, bond.getInterestRate()));
		
	}
	
	
	public int getReference() {
		return reference;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public int getIdIssuer() {
		return idIssuer;
	}

	public void setIdIssuer(int idIssuer) {
		this.idIssuer = idIssuer;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public String getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPaymentPeriod() {
		return paymentPeriod;
	}

	public void setPaymentPeriod(int paymentPeriod) {
		this.paymentPeriod = paymentPeriod;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public String getInvester() {
		return invester;
	}

	public void setInvester(String invester) {
		this.invester = invester;
	}

	public int getIdInvester() {
		return idInvester;
	}

	public void setIdInvester(int idInvester) {
		this.idInvester = idInvester;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public List<Bond> getBonds() {
		bonds=bondEJB.displayAll(userBean.getUserId());
		return bonds;
	}

	public void setBonds(List<Bond> bonds) {
		this.bonds = bonds;
	}

	public Integer getBondIdToBeUpdated() {
		return bondIdToBeUpdated;
	}

	public void setBondIdToBeUpdated(Integer bondIdToBeUpdated) {
		this.bondIdToBeUpdated = bondIdToBeUpdated;
	}

	public BondEJB getBondEJB() {
		return bondEJB;
	}

	public void setBondEJB(BondEJB bondEJB) {
		this.bondEJB = bondEJB;
	}

	public List<Bond> getOffers() {
		bonds=bondEJB.displayOffers(userBean.getUserId());
		return bonds;
	}

	public void setOffers(List<Bond> offers) {
		this.offers = offers;
	}

	public List<Bond> getPending() {
		bonds=bondEJB.displayPending(userBean.getUserId());
		return bonds;
	}

	public void setPending(List<Bond> pending) {
		this.pending = pending;
	}

	public Integer getBondIdToBeNegotiated() {
		return bondIdToBeNegotiated;
	}

	public void setBondIdToBeNegotiated(Integer bondIdToBeNegotiated) {
		this.bondIdToBeNegotiated = bondIdToBeNegotiated;
	}

	public List<Bond> getNegotiated() {
		bonds=bondEJB.displayNegotiated(userBean.getUserId());
		return bonds;
	}

	public void setNegotiated(List<Bond> negotiated) {
		this.negotiated = negotiated;
	}

	public List<Bond> getConfirmed() {
		bonds=bondEJB.displayConfirmed(userBean.getUserId());
		return bonds;
	}

	public void setConfirmed(List<Bond> confirmed) {
		this.confirmed = confirmed;
	}
	
	
	

	
	
	
}
