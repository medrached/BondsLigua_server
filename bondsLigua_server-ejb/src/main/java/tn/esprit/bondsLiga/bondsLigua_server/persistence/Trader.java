package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue(value="trader")
public class Trader extends User implements Serializable {

private int scoring;

public int getScoring() {
	return scoring;
}

public void setScoring(int scoring) {
	this.scoring = scoring;
}


@OneToMany(mappedBy="trader")
private List<Asset> assets;

public List<Asset> getAssets() {
	return assets;
}

public void setAssets(List<Asset> assets) {
	this.assets = assets;
}




}
