package org.prateek.demoproject.demoproject.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReviewTrend {

	String MONTH;
	String YEAR;
	int REVIEWCOUNT;
	/**
	 *
	 */
	public ReviewTrend() {}
	/**
	 * @param mONTH
	 * @param yEAR
	 * @param rEVIEWCOUNT
	 */
	public ReviewTrend(String mONTH, String yEAR, int rEVIEWCOUNT) {
		super();
		MONTH = mONTH;
		YEAR = yEAR;
		REVIEWCOUNT = rEVIEWCOUNT;
	}
	public String getMONTH() {
		return MONTH;
	}
	public void setMONTH(String mONTH) {
		MONTH = mONTH;
	}
	public String getYEAR() {
		return YEAR;
	}
	public void setYEAR(String yEAR) {
		YEAR = yEAR;
	}
	public int getREVIEWCOUNT() {
		return REVIEWCOUNT;
	}
	public void setREVIEWCOUNT(int rEVIEWCOUNT) {
		REVIEWCOUNT = rEVIEWCOUNT;
	}


}
