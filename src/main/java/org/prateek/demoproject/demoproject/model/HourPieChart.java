package org.prateek.demoproject.demoproject.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HourPieChart {

	String CATEGORY;
	int CHECKIN_COUNT;
	
	public HourPieChart(){};
	
	public HourPieChart(String cATEGORY, int cHECKIN_COUNT) {
		super();
		CATEGORY = cATEGORY;
		CHECKIN_COUNT = cHECKIN_COUNT;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public int getCHECKIN_COUNT() {
		return CHECKIN_COUNT;
	}

	public void setCHECKIN_COUNT(int cHECKIN_COUNT) {
		CHECKIN_COUNT = cHECKIN_COUNT;
	}
	
	
	
	
}
