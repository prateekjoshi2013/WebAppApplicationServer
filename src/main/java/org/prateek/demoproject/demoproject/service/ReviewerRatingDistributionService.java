package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.prateek.demoproject.demoproject.model.ReviewerRatingDistribution;
import org.prateek.demoproject.demoproject.model.TopReviewer;

public class ReviewerRatingDistributionService {

	///Reviewer/{user_id}/profile/rating_distribution

	public ArrayList<ReviewerRatingDistribution> getReviewerRatingDistribution(String userID) throws SQLException{
		ArrayList <ReviewerRatingDistribution> topReviewerRatingDistributionList=new ArrayList<ReviewerRatingDistribution>();

		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 String queryString="select user_id,stars,count(*) count from ARAVI.REVIEWS"
+" where user_id='"+userID+"' group by user_id,stars order by stars desc ";
//System.out.println(queryString);
		 ResultSet rset = stmt.executeQuery (queryString);
		 topReviewerRatingDistributionList = createReviewersRatingDistribution(rset);
		 conn.close(); // ** IMPORTANT : Close connections when done **}
		 return topReviewerRatingDistributionList;


	}
//	USER_ID = uSER_ID;
//	COUNT = cOUNT;
//	STARS = sTARS;

	private ArrayList<ReviewerRatingDistribution> createReviewersRatingDistribution(ResultSet rset) throws SQLException{
		ArrayList <ReviewerRatingDistribution> topReviewerRatingDistributionList=new ArrayList<ReviewerRatingDistribution>();
		while(rset.next()){
			topReviewerRatingDistributionList.add(new ReviewerRatingDistribution(rset.getString("user_id"), rset.getInt("COUNT"), rset.getFloat("STARS")));
		}

		return topReviewerRatingDistributionList ;

	}


}
