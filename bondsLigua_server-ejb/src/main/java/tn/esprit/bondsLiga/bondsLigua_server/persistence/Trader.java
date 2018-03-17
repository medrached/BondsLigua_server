package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class Trader extends User implements Serializable {

private int cin;
private int scoring;
private Portfolio portfolio;

@OneToMany(mappedBy="trader")
private List<Asset> assets;
public int getScoring() {
	return scoring;
}

public void setScoring(int scoring) {
	this.scoring = scoring;
}





public int getCin() {
	return cin;
}

public void setCin(int cin) {
	this.cin = cin;
}







public List<Asset> getAssets() {
	return assets;
}


public void setAssets(List<Asset> assets) {
	this.assets = assets;
}




}
