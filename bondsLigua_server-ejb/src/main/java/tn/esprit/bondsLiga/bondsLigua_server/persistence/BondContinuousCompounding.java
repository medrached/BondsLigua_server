package tn.esprit.bondsLiga.bondsLigua_server.persistence;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Continuous Compounding")
public class BondContinuousCompounding extends Bond implements Serializable {
	
	private double actualValue;
	
	

	public BondContinuousCompounding() {
		super();
	}

	public BondContinuousCompounding(double actualValue) {
		super();
		this.actualValue = actualValue;
	}

	public double getActualValue() {
		return actualValue;
	}

	public void setActualValue(double actualValue) {
		this.actualValue = actualValue;
	}
	
	

}
