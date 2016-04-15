package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.prateek.demoproject.demoproject.model.DayPieChart;
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
				 hourPieList.add(new HourPieChart(categories[i],rset.getInt("hourCheckinCount")));
				}
		 }
		 
		 conn.close();
		 return hourPieList;
		 //String queryString = "select sum(checkin_info_"+hour+"_"+day+") as hourCheckinCount from sharshar.business a join sharshar.check_in b on a.business_id=b.business_id where a.categories like '%"+category+"%' AND b.checkin_info_"+hour+"_"+day+" is not NULL AND a.city = '"+city+"'";
	
}
	
	public ArrayList<DayPieChart>getDayPieChartData(String city,int day) throws SQLException{
		
		ArrayList<DayPieChart> dayPieList=new ArrayList<DayPieChart>();
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 String[] categories ={"Food","Restaurants","Shopping","Active Life","Arts and Entertainment","Automotive","Beauty and Spas","Education","Event Planning and Services","Health and Medical","Home Services","Local Services"};
		 for(int i=0; i<categories.length;i++){
			 String queryString = "select (sum(a.checkin_info_0_"+day+") + sum(a.checkin_info_1_"+day+") + sum(a.checkin_info_2_"+day+") + sum(a.checkin_info_3_"+day+") + sum(a.checkin_info_4_"+day+") + sum(a.checkin_info_5_"+day+") + sum(a.checkin_info_6_"+day+") + sum(a.checkin_info_7_"+day+") + sum(a.checkin_info_8_"+day+") + sum(a.checkin_info_9_"+day+") + sum(a.checkin_info_10_"+day+") + sum(a.checkin_info_11_"+day+") + sum(a.checkin_info_12_"+day+") + sum(a.checkin_info_13_"+day+") + sum(a.checkin_info_14_"+day+") + sum(a.checkin_info_15_"+day+") + sum(a.checkin_info_16_"+day+") + sum(a.checkin_info_17_"+day+") + sum(a.checkin_info_18_"+day+") + sum(a.checkin_info_19_"+day+") + sum(a.checkin_info_20_"+day+") + sum(a.checkin_info_21_"+day+") + sum(a.checkin_info_22_"+day+") + sum(a.checkin_info_23_"+day+")) as dayCheckinCount  from sharshar.business b join sharshar.check_in a on a.business_id=b.business_id where b.categories like '%"+categories[i]+"%' AND b.city = '"+city+"'";
			 
			 ResultSet rset = stmt.executeQuery (queryString);
			 while(rset.next()){
				 dayPieList.add(new DayPieChart(categories[i],rset.getInt("dayCheckinCount")));
				}
		 }
		 
		 conn.close();
		 return dayPieList;
		 //String queryString = "select sum(checkin_info_"+hour+"_"+day+") as hourCheckinCount from sharshar.business a join sharshar.check_in b on a.business_id=b.business_id where a.categories like '%"+category+"%' AND b.checkin_info_"+hour+"_"+day+" is not NULL AND a.city = '"+city+"'";
	
}
	
	
	
	
}
