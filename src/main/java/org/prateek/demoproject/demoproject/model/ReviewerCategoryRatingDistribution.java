package org.prateek.demoproject.demoproject.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReviewerCategoryRatingDistribution {
String CATEGORY;
String USER_ID;
int COUNT;
/**
 * @param cATEGORY
 * @param uSER_ID
 * @param cOUNT
 */
public ReviewerCategoryRatingDistribution(String cATEGORY, String uSER_ID, int cOUNT) {
	super();
	CATEGORY = cATEGORY;
	USER_ID = uSER_ID;
	COUNT = cOUNT;
}
/**
 *
 */
public ReviewerCategoryRatingDistribution() {
}
public String getCATEGORY() {
	return CATEGORY;
}
public void setCATEGORY(String cATEGORY) {
	CATEGORY = cATEGORY;
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
}
