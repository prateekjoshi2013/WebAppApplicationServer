package org.prateek.demoproject.demoproject.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReviewerTip {


	String BUSINESS_ID;
	String NAME;
	String TEXT;
	float STARS;
	Date TIP_DATE;
	
	public ReviewerTip(){}

	public ReviewerTip(String bUSINESS_ID, String nAME, String tEXT, float sTARS, Date tIP_DATE) {
		super();
		BUSINESS_ID = bUSINESS_ID;
		NAME = nAME;
		TEXT = tEXT;
		STARS = sTARS;
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

	public Date getTIP_DATE() {
		return TIP_DATE;
	}

	public void setTIP_DATE(Date tIP_DATE) {
		TIP_DATE = tIP_DATE;
	}
	
	
}
