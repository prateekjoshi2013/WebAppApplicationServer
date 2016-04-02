package org.prateek.demoproject.demoproject.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Review {
	 String USER_ID;
    String REVIEW_ID;
    String TEXT;
    int VOTES_COOL;
   String BUSINESS_ID ;
    int VOTES_FUNNY ;
    int REVIEW_STARS ;
   Date REVIEW_DATE ;
    int VOTES_USEFUL;

public Review(){}

/**
 * @param uSER_ID
 * @param rEVIEW_ID
 * @param tEXT
 * @param vOTES_COOL
 * @param bUSINESS_ID
 * @param vOTES_FUNNY
 * @param rEVIEW_STARS
 * @param rEVIEW_DATE
 * @param vOTES_USEFUL
 */
public Review(String uSER_ID, String rEVIEW_ID, String tEXT, int vOTES_COOL, String bUSINESS_ID, int vOTES_FUNNY,
		int rEVIEW_STARS, Date rEVIEW_DATE, int vOTES_USEFUL) {
	super();
	USER_ID = uSER_ID;
	REVIEW_ID = rEVIEW_ID;
	TEXT = tEXT;
	VOTES_COOL = vOTES_COOL;
	BUSINESS_ID = bUSINESS_ID;
	VOTES_FUNNY = vOTES_FUNNY;
	REVIEW_STARS = rEVIEW_STARS;
	REVIEW_DATE = rEVIEW_DATE;
	VOTES_USEFUL = vOTES_USEFUL;
}

public String getUSER_ID() {
	return USER_ID;
}

public void setUSER_ID(String uSER_ID) {
	USER_ID = uSER_ID;
}

public String getREVIEW_ID() {
	return REVIEW_ID;
}

public void setREVIEW_ID(String rEVIEW_ID) {
	REVIEW_ID = rEVIEW_ID;
}

public String getTEXT() {
	return TEXT;
}

public void setTEXT(String tEXT) {
	TEXT = tEXT;
}

public int getVOTES_COOL() {
	return VOTES_COOL;
}

public void setVOTES_COOL(int vOTES_COOL) {
	VOTES_COOL = vOTES_COOL;
}

public String getBUSINESS_ID() {
	return BUSINESS_ID;
}

public void setBUSINESS_ID(String bUSINESS_ID) {
	BUSINESS_ID = bUSINESS_ID;
}

public int getVOTES_FUNNY() {
	return VOTES_FUNNY;
}

public void setVOTES_FUNNY(int vOTES_FUNNY) {
	VOTES_FUNNY = vOTES_FUNNY;
}

public int getREVIEW_STARS() {
	return REVIEW_STARS;
}

public void setREVIEW_STARS(int rEVIEW_STARS) {
	REVIEW_STARS = rEVIEW_STARS;
}

public Date getREVIEW_DATE() {
	return REVIEW_DATE;
}

public void setREVIEW_DATE(Date rEVIEW_DATE) {
	REVIEW_DATE = rEVIEW_DATE;
}

public int getVOTES_USEFUL() {
	return VOTES_USEFUL;
}

public void setVOTES_USEFUL(int vOTES_USEFUL) {
	VOTES_USEFUL = vOTES_USEFUL;
};



}
