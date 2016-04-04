package org.prateek.demoproject.demoproject.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReviewerReview {

	//a.business_id,a.name,b.text,b.stars,b.REVIEW_DATE
	
	String BUSINESS_ID;
	String NAME;
	String TEXT;
	float STARS;
	Date REVIEW_DATE;
	
	public ReviewerReview(){}

	public ReviewerReview(String bUSINESS_ID, String nAME, String tEXT, float sTARS, Date rEVIEW_DATE) {
		super();
		BUSINESS_ID = bUSINESS_ID;
		NAME = nAME;
		TEXT = tEXT;
		STARS = sTARS;
		REVIEW_DATE = rEVIEW_DATE;
	}

	public String getBUSINESS_ID() {
		return BUSINESS_ID;
	}

	public void setBUSINESS_ID(String bUSINESS_ID) {
		BUSINESS_ID = bUSINESS_ID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getTEXT() {
		return TEXT;
	}

	public void setTEXT(String tEXT) {
		TEXT = tEXT;
	}

	public float getSTARS() {
		return STARS;
	}

	public void setSTARS(float sTARS) {
		STARS = sTARS;
	}

	public Date getREVIEW_DATE() {
		return REVIEW_DATE;
	}

	public void setREVIEW_DATE(Date rEVIEW_DATE) {
		REVIEW_DATE = rEVIEW_DATE;
	}
	
	
}
