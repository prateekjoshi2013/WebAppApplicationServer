package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.prateek.demoproject.demoproject.model.ReviewerReview;
import org.prateek.demoproject.demoproject.model.ReviewerTip;

public class ReviewerReviewTipService {

	
	public List<ReviewerReview> getReviewerReviews(String userId) throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();


		 ResultSet rset = stmt.executeQuery ("select a.business_id,a.name,b.text,b.stars,b.REVIEW_DATE from sharshar.business a join ARAVI.REVIEWS b on a.business_id=b.business_id where b.user_id='"+userId+"'");
		 List<ReviewerReview> reviewerReviewList=new ArrayList<ReviewerReview>();
		 
		 while (rset.next ()){

			 ReviewerReview reviewerReview=new ReviewerReview(
					 rset.getString("BUSINESS_ID"),
					 rset.getString("NAME"),
					 rset.getString("TEXT"),
					 Float.parseFloat(rset.getString("STARS")),
					 rset.getDate("REVIEW_DATE")
					 );
			 reviewerReviewList.add(reviewerReview);

		 }
		 conn.close();
		 
		 return reviewerReviewList;
		
	}
	
	
	public List<ReviewerTip> getReviewerTips(String userId) throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();


		 ResultSet rset = stmt.executeQuery ("select a.business_id,a.name,b.text,b.stars,b.REVIEW_DATE from sharshar.business a join ARAVI.REVIEWS b on a.business_id=b.business_id where b.user_id='"+userId+"'");
		 List<ReviewerTip> reviewerTipList=new ArrayList<ReviewerTip>();
		 
		 while (rset.next ()){

			 ReviewerTip reviewerTip=new ReviewerTip(
					 rset.getString("BUSINESS_ID"),
					 rset.getString("NAME"),
					 rset.getString("TEXT"),
					 Float.parseFloat(rset.getString("STARS")),
					 rset.getDate("REVIEW_DATE")
					 );
			 reviewerTipList.add(reviewerTip);

		 }
		 conn.close();
		 
		 return reviewerTipList;
		
	}
}
