package org.prateek.demoproject.demoproject.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusinessReview {

	//a.user_id,a.name,a.friends,a.review_count,b.stars,b.review_date
	 String USER_ID;
	 String NAME;
	 String FRIENDS;
	 int REVIEW_COUNT;
	 float STARS;
	 Date REVIEW_DATE;
	 String TEXT;
	 
	 public BusinessReview(){}

	public BusinessReview(String uSER_ID, String nAME, String fRIENDS, int rEVIEW_COUNT, float sTARS, Date rEVIEW_DATE,
			String tEXT) {
		super();
		USER_ID = uSER_ID;
		NAME = nAME;
		FRIENDS = fRIENDS;
		REVIEW_COUNT = rEVIEW_COUNT;
		STARS = sTARS;
		REVIEW_DATE = rEVIEW_DATE;
		TEXT = tEXT;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getFRIENDS() {
		return FRIENDS;
	}

	public void setFRIENDS(String fRIENDS) {
		FRIENDS = fRIENDS;
	}

	public int getREVIEW_COUNT() {
		return REVIEW_COUNT;
	}

	public void setREVIEW_COUNT(int rEVIEW_COUNT) {
		REVIEW_COUNT = rEVIEW_COUNT;
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

	public String getTEXT() {
		return TEXT;
	}

	public void setTEXT(String tEXT) {
		TEXT = tEXT;
	}

	
	 
	 
}
