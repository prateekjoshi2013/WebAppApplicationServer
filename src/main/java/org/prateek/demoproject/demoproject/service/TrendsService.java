package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.prateek.demoproject.demoproject.model.ReviewTrend;
import org.prateek.demoproject.demoproject.model.TopReviewer;

public class TrendsService {


	public ArrayList<ReviewTrend>getReviewTrends(String city,String category) throws SQLException{

		ArrayList<ReviewTrend> rtrendList=new ArrayList();
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 String queryString="select to_char(a1.REVIEW_DATE,'MM-YY') as month,to_char(a1.REVIEW_DATE,'YY') as year,count(*) as reviewCount from (select a.review_date from ARAVI.REVIEWS a "
		 +"join sharshar.business b on a.business_id=b.business_id "+"where b.categories like '%"+category+"%' AND b.city = '"+city+"') a1 "+
				 " group by to_char(a1.REVIEW_DATE,'MM-YY'),to_char(a1.REVIEW_DATE,'YY')";

		 System.out.println(queryString);
		 ResultSet rset = stmt.executeQuery (queryString);
		 while(rset.next()){
			 rtrendList.add(new ReviewTrend(rset.getString("MONTH"), rset.getString("YEAR"), rset.getInt("REVIEWCOUNT")));
			}

		return rtrendList;



	}


}
