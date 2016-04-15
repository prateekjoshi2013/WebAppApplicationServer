package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.prateek.demoproject.demoproject.model.DailyCheckinTrends;
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
		 conn.close();
		return rtrendList;



	}

	public ArrayList<DailyCheckinTrends>getDailyCheckinTrends(String city,String category) throws SQLException{

		ArrayList<DailyCheckinTrends> dailyCheckinList=new ArrayList();
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
//		 String queryString0="select "+
//"avg(a.checkin_info_0_0) as h_0_0,avg(a.checkin_info_1_0) as h_1_0,avg(a.checkin_info_2_0) as h_2_0,"+
//"avg(a.checkin_info_3_0) as h_3_0,avg(a.checkin_info_4_0) as h_4_0,avg(a.checkin_info_5_0) as h_5_0,"+
//"avg(a.checkin_info_6_0) as h_6_0,avg(a.checkin_info_7_0) as h_7_0,avg(a.checkin_info_8_0) as h_8_0,"+
//"avg(a.checkin_info_9_0) as h_9_0,avg(a.checkin_info_10_0) as h_10_0,avg(a.checkin_info_11_0) as h_11_0,"+
//"avg(a.checkin_info_12_0) as h_12_0,avg(a.checkin_info_13_0) as h_13_0,avg(a.checkin_info_14_0) as h_14_0,"+
//"avg(a.checkin_info_15_0) as h_15_0,avg(a.checkin_info_16_0) as h_16_0,avg(a.checkin_info_17_0) as h_17_0,"+
//"avg(a.checkin_info_18_0) as h_18_0,avg(a.checkin_info_19_0) as h_19_0,avg(a.checkin_info_20_0) as h_20_0,"+
//"avg(a.checkin_info_21_0) as h_21_0,avg(a.checkin_info_22_0) as h_22_0,avg(a.checkin_info_23_0) as h_23_0 from sharshar.check_in a "+
//" where a.business_id in (select business_id from sharshar.business "+
//" where categories like '%"+category+"%' AND city = '"+city+"');";
//
//		 String queryString1="select "+
//				 "avg(a.checkin_info_0_1) as h_0_1,avg(a.checkin_info_1_1) as h_1_1,avg(a.checkin_info_2_1) as h_2_1,"+
//				 "avg(a.checkin_info_3_1) as h_3_1,avg(a.checkin_info_4_1) as h_4_1,avg(a.checkin_info_5_1) as h_5_1,"+
//				 "avg(a.checkin_info_6_1) as h_6_1,avg(a.checkin_info_7_1) as h_7_1,avg(a.checkin_info_8_1) as h_8_1,"+
//				 "avg(a.checkin_info_9_1) as h_9_1,avg(a.checkin_info_10_1) as h_10_1,avg(a.checkin_info_11_1) as h_11_1,"+
//				 "avg(a.checkin_info_12_1) as h_12_1,avg(a.checkin_info_13_1) as h_13_1,avg(a.checkin_info_14_1) as h_14_1,"+
//				 "avg(a.checkin_info_15_1) as h_15_1,avg(a.checkin_info_16_1) as h_16_1,avg(a.checkin_info_17_1) as h_17_1,"+
//				 "avg(a.checkin_info_18_1) as h_18_1,avg(a.checkin_info_19_1) as h_19_1,avg(a.checkin_info_20_1) as h_20_1,"+
//				 "avg(a.checkin_info_21_1) as h_21_1,avg(a.checkin_info_22_1) as h_22_1,avg(a.checkin_info_23_1) as h_23_1 from sharshar.check_in a "+
//				 " where a.business_id in (select business_id from sharshar.business "+
//				 " where categories like '%"+category+"%' AND city = '"+city+"');";
//
//		 String queryString2="select "+
//				 "avg(a.checkin_info_0_2) as h_0_2,avg(a.checkin_info_1_2) as h_1_2,avg(a.checkin_info_2_2) as h_2_2,"+
//				 "avg(a.checkin_info_3_2) as h_3_2,avg(a.checkin_info_4_2) as h_4_2,avg(a.checkin_info_5_2) as h_5_2,"+
//				 "avg(a.checkin_info_6_2) as h_6_2,avg(a.checkin_info_7_2) as h_7_2,avg(a.checkin_info_8_2) as h_8_2,"+
//				 "avg(a.checkin_info_9_2) as h_9_2,avg(a.checkin_info_10_2) as h_10_2,avg(a.checkin_info_11_2) as h_11_2,"+
//				 "avg(a.checkin_info_12_2) as h_12_2,avg(a.checkin_info_13_2) as h_13_2,avg(a.checkin_info_14_2) as h_14_2,"+
//				 "avg(a.checkin_info_15_2) as h_15_2,avg(a.checkin_info_16_2) as h_16_2,avg(a.checkin_info_17_2) as h_17_2,"+
//				 "avg(a.checkin_info_18_2) as h_18_2,avg(a.checkin_info_19_2) as h_19_2,avg(a.checkin_info_20_2) as h_20_2,"+
//				 "avg(a.checkin_info_21_2) as h_21_2,avg(a.checkin_info_22_2) as h_22_2,avg(a.checkin_info_23_2) as h_23_2 from sharshar.check_in a "+
//				 " where a.business_id in (select business_id from sharshar.business "+
//				 " where categories like '%"+category+"%' AND city = '"+city+"');";
		 int day;
for( day=0;day<=6;day++)
		 {       String queryString="select "+
				 "avg(a.checkin_info_0_"+day+") as h_0_"+day+",avg(a.checkin_info_1_"+day+") as h_1_"+day+",avg(a.checkin_info_2_"+day+") as h_2_"+day+","+
				 "avg(a.checkin_info_3_"+day+") as h_3_"+day+",avg(a.checkin_info_4_"+day+") as h_4_"+day+",avg(a.checkin_info_5_"+day+") as h_5_"+day+","+
				 "avg(a.checkin_info_6_"+day+") as h_6_"+day+",avg(a.checkin_info_7_"+day+") as h_7_"+day+",avg(a.checkin_info_8_"+day+") as h_8_"+day+","+
				 "avg(a.checkin_info_9_"+day+") as h_9_"+day+",avg(a.checkin_info_10_"+day+") as h_10_"+day+",avg(a.checkin_info_11_"+day+") as h_11_"+day+","+
				 "avg(a.checkin_info_12_"+day+") as h_12_"+day+",avg(a.checkin_info_13_"+day+") as h_13_"+day+",avg(a.checkin_info_14_"+day+") as h_14_"+day+","+
				 "avg(a.checkin_info_15_"+day+") as h_15_"+day+",avg(a.checkin_info_16_"+day+") as h_16_"+day+",avg(a.checkin_info_17_"+day+") as h_17_"+day+","+
				 "avg(a.checkin_info_18_"+day+") as h_18_"+day+",avg(a.checkin_info_19_"+day+") as h_19_"+day+",avg(a.checkin_info_20_"+day+") as h_20_"+day+","+
				 "avg(a.checkin_info_21_"+day+") as h_21_"+day+",avg(a.checkin_info_22_"+day+") as h_22_"+day+",avg(a.checkin_info_23_"+day+") as h_23_"+day+" from sharshar.check_in a "+
				 " where a.business_id in (select business_id from sharshar.business "+
				 " where categories like '%"+category+"%' AND city = '"+city+"')";
		 System.out.println(queryString);
		 ResultSet rset = stmt.executeQuery (queryString);
		 while(rset.next()){
			 String days="";
			 if(day==0)
				 days="sunday";
			 else if(day==1)
				 days="monday";
			 else if(day==2)
				 days="tuesday";
			 else if(day==3)
				 days="wednesday";
			 else if(day==4)
				 days="thursday";
			 else if(day==5)
				 days="friday";
			 else if(day==6)
				 days="saturday";

			 dailyCheckinList.add(new DailyCheckinTrends(
					 rset.getFloat(1)
					 ,rset.getFloat(2)
					 ,rset.getFloat(3)
					 ,rset.getFloat(4)
					 ,rset.getFloat(5)
					 ,rset.getFloat(6)
					 ,rset.getFloat(7)
					 ,rset.getFloat(8)
					 ,rset.getFloat(9)
					 ,rset.getFloat(10)
					 ,rset.getFloat(11)
					 ,rset.getFloat(12)
					 ,rset.getFloat(13)
					 ,rset.getFloat(14)
					 ,rset.getFloat(15)
					 ,rset.getFloat(16)
					 ,rset.getFloat(17)
					 ,rset.getFloat(18)
					 ,rset.getFloat(19)
					 ,rset.getFloat(20)
					 ,rset.getFloat(21)
					 ,rset.getFloat(22)
					 ,rset.getFloat(23)
					 ,rset.getFloat(24)
					 ,days
					 ));
			}

		 }


        conn.close();

		return dailyCheckinList;



	}



}
