package org.prateek.demoproject.demoproject.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReviewerRatingDistribution {

	//user_id,stars,count(*) count
	String USER_ID;
	int COUNT;
	float STARS;
	/**
	 *
	 */
	public ReviewerRatingDistribution() {}
	/**
	 * @param uSER_ID
	 * @param cOUNT
	 * @param sTARS
	 */
	public ReviewerRatingDistribution(String uSER_ID, int cOUNT, float sTARS) {
		super();
		USER_ID = uSER_ID;
		COUNT = cOUNT;
		STARS = sTARS;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
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
