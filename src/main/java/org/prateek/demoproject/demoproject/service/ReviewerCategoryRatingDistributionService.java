package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.prateek.demoproject.demoproject.model.ReviewerCategoryRatingDistribution;
import org.prateek.demoproject.demoproject.model.ReviewerRatingDistribution;

public class ReviewerCategoryRatingDistributionService {

	public ArrayList<ReviewerCategoryRatingDistribution> getReviewerCategoryRatingDistribution(String userID) throws SQLException{
		ArrayList<ReviewerCategoryRatingDistribution> ReviewerCategoryRatingDistributionList=new ArrayList<ReviewerCategoryRatingDistribution>();

		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();

		 String [] categories ={"Food","Restaurants","Shopping","Active Life","Arts and Entertainment","Automotive","Beauty and Spas","Event Planning and Services","Education","Health and Medical","Home and Medical","Home Services","Local Services"};

		 for(int i=0;i<categories.length;i++){
		 String queryString="select b.user_id,count(*) count from sharshar.business a"+
				 " join ARAVI.REVIEWS b on a.business_id=b.business_id"+
				  " where a.categories like '%"+categories[i]+"%' AND b.user_id='"+userID+"'group by b.user_id";


		 //System.out.println(queryString);
		 ResultSet rset = stmt.executeQuery (queryString);

		 ReviewerCategoryRatingDistribution rCRD=createReviewersCategoryRatingDistribution(rset,categories[i]);
		if(rCRD!=null)
		 ReviewerCategoryRatingDistributionList.add(rCRD);
		 }


		 String queryString1="select b.user_id,count(*) count from sharshar.business a"+
				 " join ARAVI.REVIEWS b on a.business_id=b.business_id"+
				  " where a.categories  not like '%Food%' and a.categories not like '%Restaurants%' and a.categories not like '%Shopping%' and a.categories not like '%Active Life%' and a.categories not like '%Arts and Entertainment%' and a.categories not like '%Automotive%' and a.categories not like '%Beauty and Spas%' and a.categories not like '%Event Planning and Services%' and a.categories not like '%Education%' and a.categories not like '%Health and Medical%'  and a.categories not like '%Home and Medical%' and a.categories not like '%Home Services%' and a.categories not like '%Local Services%' and b.user_id='"+userID+"'group by b.user_id";
         System.out.println(queryString1);
		 ResultSet rset = stmt.executeQuery (queryString1);

		 ReviewerCategoryRatingDistribution rCRD1=createReviewersCategoryRatingDistribution(rset,"Others");
		if(rCRD1!=null)
		 ReviewerCategoryRatingDistributionList.add(rCRD1);

		 conn.close(); // ** IMPORTANT : Close connections when done **}
		 return ReviewerCategoryRatingDistributionList;


	}
//	USER_ID = uSER_ID;
//	COUNT = cOUNT;
//	STARS = sTARS;

	private ReviewerCategoryRatingDistribution createReviewersCategoryRatingDistribution(ResultSet rset,String category) throws SQLException{
		ReviewerCategoryRatingDistribution newReviewerCategoryRatingDistribution=null;
while(rset.next())
{
	 newReviewerCategoryRatingDistribution=new ReviewerCategoryRatingDistribution(category,rset.getString("user_id"), rset.getInt("COUNT"));
//System.out.println(newReviewerCategoryRatingDistribution.getUSER_ID());
}

	return newReviewerCategoryRatingDistribution;
	}


}
