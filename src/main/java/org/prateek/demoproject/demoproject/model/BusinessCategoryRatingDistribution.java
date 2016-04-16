package org.prateek.demoproject.demoproject.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusinessCategoryRatingDistribution {

	/**
	 *
	 */
	public BusinessCategoryRatingDistribution() {
		super();
	}
	float STARS;
	/**
	 * @param sTARS
	 * @param cOUNT
	 */
	public BusinessCategoryRatingDistribution(float sTARS, int cOUNT) {
		STARS = sTARS;
		COUNT = cOUNT;
	}
	int COUNT;
	public float getSTARS() {
		return STARS;
	}
	public void setSTARS(float sTARS) {
		STARS = sTARS;
	}
	public int getCOUNT() {
		return COUNT;
	}
	public void setCOUNT(int cOUNT) {
		COUNT = cOUNT;
	}


}
