package org.prateek.demoproject.demoproject.model;

public class TopEliteReviewer {

	//a3.user_id,a3.name,a3.usercount,b3.friends,b3.REVIEW_COUNT,b3.elite
	String USER_ID;
	String NAME;
	int USERCOUNT;
	String FRIENDS;
	int REVIEW_COUNT;
	String ELITE;


	/**
	 *
	 */
	public TopEliteReviewer() {}
	/**
	 * @param uSER_ID
	 * @param nAME
	 * @param uSERCOUNT
	 * @param fRIENDS
	 * @param rEVIEW_COUNT
	 * @param eLITE
	 */
	public TopEliteReviewer(String uSER_ID, String nAME, int uSERCOUNT, String fRIENDS, int rEVIEW_COUNT,
			String eLITE) {
		super();
		USER_ID = uSER_ID;
		NAME = nAME;
		USERCOUNT = uSERCOUNT;
		FRIENDS = fRIENDS;
		REVIEW_COUNT = rEVIEW_COUNT;
		ELITE = eLITE;
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
	public int getUSERCOUNT() {
		return USERCOUNT;
	}
	public void setUSERCOUNT(int uSERCOUNT) {
		USERCOUNT = uSERCOUNT;
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
	public String getELITE() {
		return ELITE;
	}
	public void setELITE(String eLITE) {
		ELITE = eLITE;
	}


}
