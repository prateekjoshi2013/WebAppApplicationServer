package org.prateek.demoproject.demoproject.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusinessCategoryRatingDistribution {


	String CATEGORIES;
	float STARS;


	/**
	 *
	 */
	public BusinessCategoryRatingDistribution() {
	}
	/**
	 * @param cATEGORIES
	 * @param sTARS
	 */
	public BusinessCategoryRatingDistribution(String cATEGORIES, float sTARS) {
		super();
		CATEGORIES = cATEGORIES;
		STARS = sTARS;
	}
	public String getCATEGORIES() {
		return CATEGORIES;
	}
	public void setCATEGORIES(String cATEGORIES) {
		CATEGORIES = cATEGORIES;
	}
	public float getSTARS() {
		return STARS;
	}
	public void setSTARS(float sTARS) {
		STARS = sTARS;
	}



}
