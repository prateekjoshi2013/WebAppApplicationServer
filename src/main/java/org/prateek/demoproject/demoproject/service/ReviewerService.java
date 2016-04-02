package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.prateek.demoproject.demoproject.model.Business;
import org.prateek.demoproject.demoproject.model.Reviewer;

public class ReviewerService {

	public Reviewer getReviewer(String reviewerId) throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =
			      DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 ResultSet rset = stmt.executeQuery ("select * from ntiware.reviewer where USER_ID='"+reviewerId+"'");
		 Reviewer result = createReviewersObj(rset);
		 conn.close(); // ** IMPORTANT : Close connections when done **}
		 return result;


	}

	private Reviewer createReviewersObj(ResultSet rset) throws SQLException {
		// TODO Auto-generated method stub
		Reviewer reviewer=null;


		while (rset.next()){
			//System.out.println(rset.getString("REVIEWING_SINCE"));
			reviewer=new Reviewer(
		rset.getString("REVIEWING_SINCE"),
	    rset.getInt("COMPLIMENTS_PLAIN"),
	    rset.getInt("REVIEW_COUNT") ,
	    rset.getString("FRIENDS"),
	    rset.getInt("COMPLIMENTS_CUTE"),
	    rset.getInt("COMPLIMENTS_WRITER"),
	    rset.getInt("FANS"),
	    rset.getInt("COMPLIMENTS_NOTE"),
	    rset.getInt("COMPLIMENTS_HOT"),
	    rset.getInt("COMPLIMENTS_COOL"),
	    rset.getInt("COMPLIMENTS_PROFILE"),
	    rset.getFloat("AVERAGE_STARS"),
	    rset.getInt("COMPLIMENTS_MORE"),
	    rset.getString("ELITE"),
	    rset.getString("NAME"),
	    rset.getString("USER_ID"),
	    rset.getInt("VOTES_COOL"),
	    rset.getInt("COMPLIMENTS_LIST"),
	    rset.getInt("VOTES_FUNNY"),
	    rset.getInt("COMPLIMENTS_PHOTOS"),
	    rset.getInt("COMPLIMENTS_FUNNY"),
	    rset.getInt("VOTES_USEFUL"));

		}
		return reviewer;

	}



}
