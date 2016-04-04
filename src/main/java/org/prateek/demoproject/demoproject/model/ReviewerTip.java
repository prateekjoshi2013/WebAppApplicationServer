package org.prateek.demoproject.demoproject.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReviewerTip {

	//a.business_id,a.name,a.stars,a.review_count,b.text,b.likes,b.tip_date

	String BUSINESS_ID;
	String NAME;
	float STARS;
	int REVIEW_COUNT;
	String TEXT;
	int LIKES;
	Date TIP_DATE;
	
	public ReviewerTip(){}

	public ReviewerTip(String bUSINESS_ID, String nAME, float sTARS, int rEVIEW_COUNT, String tEXT, int lIKES,
			Date tIP_DATE) {
		super();
		BUSINESS_ID = bUSINESS_ID;
		NAME = nAME;
		STARS = sTARS;
		REVIEW_COUNT = rEVIEW_COUNT;
		TEXT = tEXT;
		LIKES = lIKES;
		TIP_DATE = tIP_DATE;
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

	public float getSTARS() {
		return STARS;
	}

	public void setSTARS(float sTARS) {
		STARS = sTARS;
	}

	public int getREVIEW_COUNT() {
		return REVIEW_COUNT;
	}

	public void setREVIEW_COUNT(int rEVIEW_COUNT) {
		REVIEW_COUNT = rEVIEW_COUNT;
	}

	public String getTEXT() {
		return TEXT;
	}

	public void setTEXT(String tEXT) {
		TEXT = tEXT;
	}

	public int getLIKES() {
		return LIKES;
	}

	public void setLIKES(int lIKES) {
		LIKES = lIKES;
	}

	public Date getTIP_DATE() {
		return TIP_DATE;
	}

	public void setTIP_DATE(Date tIP_DATE) {
		TIP_DATE = tIP_DATE;
	}

	
	
	
}
