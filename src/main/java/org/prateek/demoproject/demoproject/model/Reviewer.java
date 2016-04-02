package org.prateek.demoproject.demoproject.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Reviewer {
	String REVIEWING_SINCE;
    int COMPLIMENTS_PLAIN;
    int REVIEW_COUNT ;
    String FRIENDS;
    int COMPLIMENTS_CUTE;
    int COMPLIMENTS_WRITER;
    int FANS;
    int COMPLIMENTS_NOTE;
    int COMPLIMENTS_HOT;
    int COMPLIMENTS_COOL;
    int COMPLIMENTS_PROFILE;
    float AVERAGE_STARS;
    int COMPLIMENTS_MORE;
    String ELITE;
    String NAME;
    String USER_ID;
    int VOTES_COOL;
    int COMPLIMENTS_LIST;
    int VOTES_FUNNY;
    int COMPLIMENTS_PHOTOS;
    int COMPLIMENTS_FUNNY;
    int VOTES_USEFUL;
	/**
	 * @param rEVIEWING_SINCE
	 * @param cOMPLIMENTS_PLAIN
	 * @param rEVIEW_COUNT
	 * @param fRIENDS
	 * @param cOMPLIMENTS_CUTE
	 * @param cOMPLIMENTS_WRITER
	 * @param fANS
	 * @param cOMPLIMENTS_NOTE
	 * @param cOMPLIMENTS_HOT
	 * @param cOMPLIMENTS_COOL
	 * @param cOMPLIMENTS_PROFILE
	 * @param aVERAGE_STARS
	 * @param cOMPLIMENTS_MORE
	 * @param eLITE
	 * @param nAME
	 * @param uSER_ID
	 * @param vOTES_COOL
	 * @param cOMPLIMENTS_LIST
	 * @param vOTES_FUNNY
	 * @param cOMPLIMENTS_PHOTOS
	 * @param cOMPLIMENTS_FUNNY
	 * @param vOTES_USEFUL
	 */

    public Reviewer(){};
	public Reviewer(String rEVIEWING_SINCE, int cOMPLIMENTS_PLAIN, int rEVIEW_COUNT, String fRIENDS, int cOMPLIMENTS_CUTE,
			int cOMPLIMENTS_WRITER, int fANS, int cOMPLIMENTS_NOTE, int cOMPLIMENTS_HOT, int cOMPLIMENTS_COOL,
			int cOMPLIMENTS_PROFILE, float aVERAGE_STARS, int cOMPLIMENTS_MORE, String eLITE, String nAME,
			String uSER_ID, int vOTES_COOL, int cOMPLIMENTS_LIST, int vOTES_FUNNY, int cOMPLIMENTS_PHOTOS,
			int cOMPLIMENTS_FUNNY, int vOTES_USEFUL) {
		super();
		REVIEWING_SINCE = rEVIEWING_SINCE;
		COMPLIMENTS_PLAIN = cOMPLIMENTS_PLAIN;
		REVIEW_COUNT = rEVIEW_COUNT;
		FRIENDS = fRIENDS;
		COMPLIMENTS_CUTE = cOMPLIMENTS_CUTE;
		COMPLIMENTS_WRITER = cOMPLIMENTS_WRITER;
		FANS = fANS;
		COMPLIMENTS_NOTE = cOMPLIMENTS_NOTE;
		COMPLIMENTS_HOT = cOMPLIMENTS_HOT;
		COMPLIMENTS_COOL = cOMPLIMENTS_COOL;
		COMPLIMENTS_PROFILE = cOMPLIMENTS_PROFILE;
		AVERAGE_STARS = aVERAGE_STARS;
		COMPLIMENTS_MORE = cOMPLIMENTS_MORE;
		ELITE = eLITE;
		NAME = nAME;
		USER_ID = uSER_ID;
		VOTES_COOL = vOTES_COOL;
		COMPLIMENTS_LIST = cOMPLIMENTS_LIST;
		VOTES_FUNNY = vOTES_FUNNY;
		COMPLIMENTS_PHOTOS = cOMPLIMENTS_PHOTOS;
		COMPLIMENTS_FUNNY = cOMPLIMENTS_FUNNY;
		VOTES_USEFUL = vOTES_USEFUL;
	}
	public String getREVIEWING_SINCE() {
		return REVIEWING_SINCE;
	}
	public void setREVIEWING_SINCE(String rEVIEWING_SINCE) {
		REVIEWING_SINCE = rEVIEWING_SINCE;
	}
	public int getCOMPLIMENTS_PLAIN() {
		return COMPLIMENTS_PLAIN;
	}
	public void setCOMPLIMENTS_PLAIN(int cOMPLIMENTS_PLAIN) {
		COMPLIMENTS_PLAIN = cOMPLIMENTS_PLAIN;
	}
	public int getREVIEW_COUNT() {
		return REVIEW_COUNT;
	}
	public void setREVIEW_COUNT(int rEVIEW_COUNT) {
		REVIEW_COUNT = rEVIEW_COUNT;
	}
	public String getFRIENDS() {
		return FRIENDS;
	}
	public void setFRIENDS(String fRIENDS) {
		FRIENDS = fRIENDS;
	}
	public int getCOMPLIMENTS_CUTE() {
		return COMPLIMENTS_CUTE;
	}
	public void setCOMPLIMENTS_CUTE(int cOMPLIMENTS_CUTE) {
		COMPLIMENTS_CUTE = cOMPLIMENTS_CUTE;
	}
	public int getCOMPLIMENTS_WRITER() {
		return COMPLIMENTS_WRITER;
	}
	public void setCOMPLIMENTS_WRITER(int cOMPLIMENTS_WRITER) {
		COMPLIMENTS_WRITER = cOMPLIMENTS_WRITER;
	}
	public int getFANS() {
		return FANS;
	}
	public void setFANS(int fANS) {
		FANS = fANS;
	}
	public int getCOMPLIMENTS_NOTE() {
		return COMPLIMENTS_NOTE;
	}
	public void setCOMPLIMENTS_NOTE(int cOMPLIMENTS_NOTE) {
		COMPLIMENTS_NOTE = cOMPLIMENTS_NOTE;
	}
	public int getCOMPLIMENTS_HOT() {
		return COMPLIMENTS_HOT;
	}
	public void setCOMPLIMENTS_HOT(int cOMPLIMENTS_HOT) {
		COMPLIMENTS_HOT = cOMPLIMENTS_HOT;
	}
	public int getCOMPLIMENTS_COOL() {
		return COMPLIMENTS_COOL;
	}
	public void setCOMPLIMENTS_COOL(int cOMPLIMENTS_COOL) {
		COMPLIMENTS_COOL = cOMPLIMENTS_COOL;
	}
	public int getCOMPLIMENTS_PROFILE() {
		return COMPLIMENTS_PROFILE;
	}
	public void setCOMPLIMENTS_PROFILE(int cOMPLIMENTS_PROFILE) {
		COMPLIMENTS_PROFILE = cOMPLIMENTS_PROFILE;
	}
	public float getAVERAGE_STARS() {
		return AVERAGE_STARS;
	}
	public void setAVERAGE_STARS(float aVERAGE_STARS) {
		AVERAGE_STARS = aVERAGE_STARS;
	}
	public int getCOMPLIMENTS_MORE() {
		return COMPLIMENTS_MORE;
	}
	public void setCOMPLIMENTS_MORE(int cOMPLIMENTS_MORE) {
		COMPLIMENTS_MORE = cOMPLIMENTS_MORE;
	}
	public String getELITE() {
		return ELITE;
	}
	public void setELITE(String eLITE) {
		ELITE = eLITE;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public int getVOTES_COOL() {
		return VOTES_COOL;
	}
	public void setVOTES_COOL(int vOTES_COOL) {
		VOTES_COOL = vOTES_COOL;
	}
	public int getCOMPLIMENTS_LIST() {
		return COMPLIMENTS_LIST;
	}
	public void setCOMPLIMENTS_LIST(int cOMPLIMENTS_LIST) {
		COMPLIMENTS_LIST = cOMPLIMENTS_LIST;
	}
	public int getVOTES_FUNNY() {
		return VOTES_FUNNY;
	}
	public void setVOTES_FUNNY(int vOTES_FUNNY) {
		VOTES_FUNNY = vOTES_FUNNY;
	}
	public int getCOMPLIMENTS_PHOTOS() {
		return COMPLIMENTS_PHOTOS;
	}
	public void setCOMPLIMENTS_PHOTOS(int cOMPLIMENTS_PHOTOS) {
		COMPLIMENTS_PHOTOS = cOMPLIMENTS_PHOTOS;
	}
	public int getCOMPLIMENTS_FUNNY() {
		return COMPLIMENTS_FUNNY;
	}
	public void setCOMPLIMENTS_FUNNY(int cOMPLIMENTS_FUNNY) {
		COMPLIMENTS_FUNNY = cOMPLIMENTS_FUNNY;
	}
	public int getVOTES_USEFUL() {
		return VOTES_USEFUL;
	}
	public void setVOTES_USEFUL(int vOTES_USEFUL) {
		VOTES_USEFUL = vOTES_USEFUL;
	}


}
