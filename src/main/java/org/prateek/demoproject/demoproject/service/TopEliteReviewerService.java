package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.prateek.demoproject.demoproject.model.TopEliteReviewer;
import org.prateek.demoproject.demoproject.model.TopReviewer;

public class TopEliteReviewerService {

	public ArrayList<TopEliteReviewer> getTopReviewer(String city,String category,int count) throws SQLException{
		ArrayList <TopEliteReviewer> topEliteReviewerList=new ArrayList<TopEliteReviewer>();

		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 String queryString="select * from (select a3.user_id,a3.name,a3.usercount,b3.friends,b3.REVIEW_COUNT,b3.elite from (select user_id,name,count(*) usercount from"
+" (select a1.user_id,a1.name,a1.friends,b1.city,b1.categories from NTIWARE.REVIEWER a1 "
+" join (select a.city,a.business_id,b.user_id,a.categories from sharshar.BUSINESS a "
+" join ARAVI.REVIEWS b on a.business_id=b.business_id"
+" where city='Las Vegas' AND categories like '%Restaurant%') b1"
+" on a1.USER_ID=b1.USER_ID where a1.elite not like '[]') group by USER_ID,name"
+" order by count(*) desc) a3 join NTIWARE.REVIEWER b3 on a3.user_id=b3.user_id"
+" order by a3.usercount desc,b3.REVIEW_COUNT desc) where rownum <"+ (count+1);
        // System.out.println(queryString);
		 ResultSet rset = stmt.executeQuery (queryString);
		  topEliteReviewerList = createTopEliteReviewersObj(rset);
		 conn.close(); // ** IMPORTANT : Close connections when done **}
		 return topEliteReviewerList;


	}

	private ArrayList<TopEliteReviewer> createTopEliteReviewersObj(ResultSet rset) throws SQLException{
		ArrayList <TopEliteReviewer> topEliteReviewerList=new ArrayList<TopEliteReviewer>();
		while(rset.next()){
			topEliteReviewerList.add(new TopEliteReviewer(rset.getString("user_id"), rset.getString("NAME"), rset.getInt("USERCOUNT"), rset.getString("FRIENDS"), rset.getInt("REVIEW_COUNT"),rset.getString("ELITE")));
		}

		return topEliteReviewerList ;

	}



}
