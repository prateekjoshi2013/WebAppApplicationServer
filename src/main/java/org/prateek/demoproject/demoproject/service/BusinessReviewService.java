package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.prateek.demoproject.demoproject.model.BusinessReview;

public class BusinessReviewService {

	public List<BusinessReview> getBusinessReviews(String businessId) throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();


		 ResultSet rset = stmt.executeQuery ("select a.user_id,a.name,a.friends,a.review_count,b.stars,b.review_date,b.text from NTIWARE.REVIEWER a join ARAVI.REVIEWS b on a.user_id=b.user_id where b.business_id='"+businessId+"'");
		 List<BusinessReview> businessReviewList=new ArrayList<BusinessReview>();
		 
		 while (rset.next ()){

			 BusinessReview businessreview=new BusinessReview(
					 rset.getString("USER_ID"),
					 rset.getString("NAME"),
					 rset.getString("FRIENDS"),
					 rset.getInt("REVIEW_COUNT"),
					 Float.parseFloat(rset.getString("STARS")),
					 rset.getDate("REVIEW_DATE"),
					 rset.getString("TEXT"));
			 businessReviewList.add(businessreview);

		 }
		 conn.close();
		 
		 return businessReviewList;
		
		
	}

}
