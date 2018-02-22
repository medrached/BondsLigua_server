package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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




}
