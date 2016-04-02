
package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.prateek.demoproject.demoproject.model.Business;
import org.prateek.demoproject.demoproject.model.Review;

public class ReviewService {

	public Review getReview(String reviewId) throws SQLException
	{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =
			      DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 ResultSet rset = stmt.executeQuery ("select * from aravi.reviews where REVIEW_ID='"+reviewId+"'");
		 Review result = createReviewObj(rset);
		 conn.close(); // ** IMPORTANT : Close connections when done **}
		 return result;

	}

	private Review createReviewObj(ResultSet rset) throws SQLException {
		// TODO Auto-generated method stub
////		String uSER_ID,
//		String rEVIEW_ID,
//		String tEXT,
//		int vOTES_COOL,
//		String bUSINESS_ID,
//		int vOTES_FUNNY,
////		int rEVIEW_STARS,
//		Date rEVIEW_DATE,
//		int vOTES_USEFUL
////
		Review review=null;
		while(rset.next()){
					review =new Review(
					rset.getString("USER_ID"),
					rset.getString("REVIEW_ID"),
					rset.getString("TEXT"),
					rset.getInt("VOTES_COOL"),
					rset.getString("BUSINESS_ID"),
					rset.getInt("VOTES_FUNNY"),
					rset.getInt("STARS"),
					rset.getDate("REVIEW_DATE"),
					rset.getInt("VOTES_USEFUL")
					);

		}



		return review;
	}



}
