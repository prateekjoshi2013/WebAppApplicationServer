package org.prateek.demoproject.demoproject.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusinessMonthlyTrends {

	//select a.business_id,to_char(a.REVIEW_DATE,'MM-YY') month,to_char(a.REVIEW_DATE,'YY') year,avg(a.stars)
	
	String BUSINESS_ID;
	String MONTH_YEAR;
	String YEAR;
	float AVG_STARS;
	
	public BusinessMonthlyTrends(){}
	public BusinessMonthlyTrends(String bUSINESS_ID, String mONTH_YEAR, String yEAR, float aVG_STARS) {
		super();
		BUSINESS_ID = bUSINESS_ID;
		MONTH_YEAR = mONTH_YEAR;
		YEAR = yEAR;
		AVG_STARS = aVG_STARS;
	}
	public String getBUSINESS_ID() {
		return BUSINESS_ID;
	}
	public void setBUSINESS_ID(String bUSINESS_ID) {
		BUSINESS_ID = bUSINESS_ID;
	}
	public String getMONTH_YEAR() {
		return MONTH_YEAR;
	}
	public void setMONTH_YEAR(String mONTH_YEAR) {
		MONTH_YEAR = mONTH_YEAR;
	}
	public String getYEAR() {
		return YEAR;
	}
	public void setYEAR(String yEAR) {
		YEAR = yEAR;
	}
	public float getAVG_STARS() {
		return AVG_STARS;
	}
	public void setAVG_STARS(float aVG_STARS) {
		AVG_STARS = aVG_STARS;
	}
	
	
}
