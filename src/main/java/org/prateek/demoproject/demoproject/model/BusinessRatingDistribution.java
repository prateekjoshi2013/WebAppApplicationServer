package org.prateek.demoproject.demoproject.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusinessRatingDistribution {

	String BUSINESS_ID;
	int COUNT;
	float STARS;
	
	public BusinessRatingDistribution(){};
	
	public BusinessRatingDistribution(String bUSINESS_ID, int cOUNT, float sTARS) {
		super();
		BUSINESS_ID = bUSINESS_ID;
		COUNT = cOUNT;
		STARS = sTARS;
	}

	public String getBUSINESS_ID() {
		return BUSINESS_ID;
	}

	public void setBUSINESS_ID(String bUSINESS_ID) {
		BUSINESS_ID = bUSINESS_ID;
	}

	public int getCOUNT() {
		return COUNT;
	}

	public void setCOUNT(int cOUNT) {
		COUNT = cOUNT;
	}

	public float getSTARS() {
		return STARS;
	}

	public void setSTARS(float sTARS) {
		STARS = sTARS;
	}
	
	
	
}
