package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.prateek.demoproject.demoproject.model.BusinessRatingDistribution;


public class BusinessRatingDistributionService {


	public ArrayList<BusinessRatingDistribution> getBusinessRatingDistribution(String businessId) throws SQLException{
		ArrayList <BusinessRatingDistribution> BusinessRatingDistributionList=new ArrayList<BusinessRatingDistribution>();

		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 String queryString="select business_id,stars,count(*) count from ARAVI.REVIEWS"
+" where business_id='"+businessId+"' group by business_id,stars order by stars desc ";
//System.out.println(queryString);
		 ResultSet rset = stmt.executeQuery (queryString);
		 BusinessRatingDistributionList = createBusinessRatingDistribution(rset);
		 conn.close(); // ** IMPORTANT : Close connections when done **}
		 return BusinessRatingDistributionList;


	}


	private ArrayList<BusinessRatingDistribution> createBusinessRatingDistribution(ResultSet rset) throws SQLException{
		ArrayList <BusinessRatingDistribution> BusinessRatingDistributionList=new ArrayList<BusinessRatingDistribution>();
		while(rset.next()){
			BusinessRatingDistributionList.add(new BusinessRatingDistribution(rset.getString("business_id"), rset.getInt("COUNT"), rset.getFloat("STARS")));
		}

		return BusinessRatingDistributionList ;

	}
}
