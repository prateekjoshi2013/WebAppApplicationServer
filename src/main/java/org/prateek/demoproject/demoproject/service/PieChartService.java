package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.prateek.demoproject.demoproject.model.HourPieChart;



public class PieChartService {

	public ArrayList<HourPieChart>getHourPieChartData(String city,int day, int hour) throws SQLException{
		
		ArrayList<HourPieChart> hourPieList=new ArrayList<HourPieChart>();
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 String[] categories ={"Food","Restaurants","Shopping","Active Life","Arts and Entertainment","Automotive","Beauty and Spas","Education","Event Planning and Services","Health and Medical","Home Services","Local Services"};
		 for(int i=0; i<categories.length;i++){
			 String queryString = "select sum(checkin_info_"+hour+"_"+day+") as hourCheckinCount from sharshar.business a join sharshar.check_in b on a.business_id=b.business_id where a.categories like '%"+categories[i]+"%' AND b.checkin_info_"+hour+"_"+day+" is not NULL AND a.city = '"+city+"'";
			 
			 ResultSet rset = stmt.executeQuery (queryString);
			 while(rset.next()){
				 hourPieList.add(new HourPieChart(categories[0],rset.getInt("hourCheckinCount")));
				}
		 }
		 
		 conn.close();
		 return hourPieList;
		 //String queryString = "select sum(checkin_info_"+hour+"_"+day+") as hourCheckinCount from sharshar.business a join sharshar.check_in b on a.business_id=b.business_id where a.categories like '%"+category+"%' AND b.checkin_info_"+hour+"_"+day+" is not NULL AND a.city = '"+city+"'";
	
}
}
