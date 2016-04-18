package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.prateek.demoproject.demoproject.model.BusinessCategoryRatingDistribution;
import org.prateek.demoproject.demoproject.model.DailyCheckinTrends;
import org.prateek.demoproject.demoproject.model.HourPieChart;
import org.prateek.demoproject.demoproject.model.ReviewTrend;
import org.prateek.demoproject.demoproject.model.WeeklyCheckinTrends;

public class TrendsService {

	public ArrayList<BusinessCategoryRatingDistribution>getBusinessCategoryRatingDistribution(String city) throws SQLException{

		ArrayList<BusinessCategoryRatingDistribution> businessCategoryRatingDistributionList=new ArrayList();
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		Statement stmt = conn.createStatement ();
		String[] categories ={"Food","Restaurants","Shopping","Active Life","Arts and Entertainment","Automotive","Beauty and Spas","Education","Event Planning and Services","Health and Medical","Home Services","Local Services"};
		 for(int i=0; i<categories.length;i++){
			 String queryString = "select avg(COALESCE(r.stars,0)) as STARS from aravi.reviews r join  SHARSHAR.BUSINESS b on r.BUSINESS_ID = b.BUSINESS_ID where b.categories like '%"+categories[i]+"%' and b.city='"+city+"'";

			 ResultSet rset = stmt.executeQuery (queryString);
			 System.out.println(queryString);
			 while(rset.next()){
				 businessCategoryRatingDistributionList.add(new BusinessCategoryRatingDistribution(categories[i], rset.getFloat(1)));
				}
		 }

		conn.close();
		return businessCategoryRatingDistributionList;



	}








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

	public WeeklyCheckinTrends getWeeklyCheckinTrends(String city,String category) throws SQLException{

		WeeklyCheckinTrends wtrend=new WeeklyCheckinTrends();
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		Statement stmt = conn.createStatement ();
		String queryString="select "+
				"(sum(COALESCE(a.checkin_info_0_0,0)) + sum(COALESCE(a.checkin_info_1_0,0)) + sum(COALESCE(a.checkin_info_2_0,0)) + sum(COALESCE(a.checkin_info_3_0,0)) + sum(COALESCE(a.checkin_info_4_0,0)) + sum(COALESCE(a.checkin_info_5_0,0)) + sum(COALESCE(a.checkin_info_6_0,0)) + sum(COALESCE(a.checkin_info_7_0,0)) + sum(COALESCE(a.checkin_info_8_0,0)) + sum(COALESCE(a.checkin_info_9_0,0)) + sum(COALESCE(a.checkin_info_10_0,0)) + sum(COALESCE(a.checkin_info_11_0,0)) + sum(COALESCE(a.checkin_info_12_0,0)) + sum(COALESCE(a.checkin_info_13_0,0)) + sum(COALESCE(a.checkin_info_14_0,0)) + sum(COALESCE(a.checkin_info_15_0,0)) + sum(COALESCE(a.checkin_info_16_0,0)) + sum(COALESCE(a.checkin_info_17_0,0)) + sum(COALESCE(a.checkin_info_18_0,0)) + sum(COALESCE(a.checkin_info_19_0,0)) + sum(COALESCE(a.checkin_info_20_0,0)) + sum(COALESCE(a.checkin_info_21_0,0)) + sum(COALESCE(a.checkin_info_22_0,0)) + sum(COALESCE(a.checkin_info_23_0,0)) ) as h_0,"+
				"(sum(COALESCE(a.checkin_info_0_1,0)) + sum(COALESCE(a.checkin_info_1_1,0)) + sum(COALESCE(a.checkin_info_2_1,0)) + sum(COALESCE(a.checkin_info_3_1,0)) + sum(COALESCE(a.checkin_info_4_1,0)) + sum(COALESCE(a.checkin_info_5_1,0)) + sum(COALESCE(a.checkin_info_6_1,0)) + sum(COALESCE(a.checkin_info_7_1,0)) + sum(COALESCE(a.checkin_info_8_1,0)) + sum(COALESCE(a.checkin_info_9_1,0)) + sum(COALESCE(a.checkin_info_10_1,0)) + sum(COALESCE(a.checkin_info_11_1,0)) + sum(COALESCE(a.checkin_info_12_1,0)) + sum(COALESCE(a.checkin_info_13_1,0)) + sum(COALESCE(a.checkin_info_14_1,0)) + sum(COALESCE(a.checkin_info_15_1,0)) + sum(COALESCE(a.checkin_info_16_1,0)) + sum(COALESCE(a.checkin_info_17_1,0)) + sum(COALESCE(a.checkin_info_18_1,0)) + sum(COALESCE(a.checkin_info_19_1,0)) + sum(COALESCE(a.checkin_info_20_1,0)) + sum(COALESCE(a.checkin_info_21_1,0)) + sum(COALESCE(a.checkin_info_22_1,0)) + sum(COALESCE(a.checkin_info_23_1,0)) ) as h_1,"+
				"(sum(COALESCE(a.checkin_info_0_2,0)) + sum(COALESCE(a.checkin_info_1_2,0)) + sum(COALESCE(a.checkin_info_2_2,0)) + sum(COALESCE(a.checkin_info_3_2,0)) + sum(COALESCE(a.checkin_info_4_2,0)) + sum(COALESCE(a.checkin_info_5_2,0)) + sum(COALESCE(a.checkin_info_6_2,0)) + sum(COALESCE(a.checkin_info_7_2,0)) + sum(COALESCE(a.checkin_info_8_2,0)) + sum(COALESCE(a.checkin_info_9_2,0)) + sum(COALESCE(a.checkin_info_10_2,0)) + sum(COALESCE(a.checkin_info_11_2,0)) + sum(COALESCE(a.checkin_info_12_2,0)) + sum(COALESCE(a.checkin_info_13_2,0)) + sum(COALESCE(a.checkin_info_14_2,0)) + sum(COALESCE(a.checkin_info_15_2,0)) + sum(COALESCE(a.checkin_info_16_2,0)) + sum(COALESCE(a.checkin_info_17_2,0)) + sum(COALESCE(a.checkin_info_18_2,0)) + sum(COALESCE(a.checkin_info_19_2,0)) + sum(COALESCE(a.checkin_info_20_2,0)) + sum(COALESCE(a.checkin_info_21_2,0)) + sum(COALESCE(a.checkin_info_22_2,0)) + sum(COALESCE(a.checkin_info_23_2,0)) ) as h_2,"+
				"(sum(COALESCE(a.checkin_info_0_3,0)) + sum(COALESCE(a.checkin_info_1_3,0)) + sum(COALESCE(a.checkin_info_2_3,0)) + sum(COALESCE(a.checkin_info_3_3,0)) + sum(COALESCE(a.checkin_info_4_3,0)) + sum(COALESCE(a.checkin_info_5_3,0)) + sum(COALESCE(a.checkin_info_6_3,0)) + sum(COALESCE(a.checkin_info_7_3,0)) + sum(COALESCE(a.checkin_info_8_3,0)) + sum(COALESCE(a.checkin_info_9_3,0)) + sum(COALESCE(a.checkin_info_10_3,0)) + sum(COALESCE(a.checkin_info_11_3,0)) + sum(COALESCE(a.checkin_info_12_3,0)) + sum(COALESCE(a.checkin_info_13_3,0)) + sum(COALESCE(a.checkin_info_14_3,0)) + sum(COALESCE(a.checkin_info_15_3,0)) + sum(COALESCE(a.checkin_info_16_3,0)) + sum(COALESCE(a.checkin_info_17_3,0)) + sum(COALESCE(a.checkin_info_18_3,0)) + sum(COALESCE(a.checkin_info_19_3,0)) + sum(COALESCE(a.checkin_info_20_3,0)) + sum(COALESCE(a.checkin_info_21_3,0)) + sum(COALESCE(a.checkin_info_22_3,0)) + sum(COALESCE(a.checkin_info_23_3,0)) ) as h_3,"+
				"(sum(COALESCE(a.checkin_info_0_4,0)) + sum(COALESCE(a.checkin_info_1_4,0)) + sum(COALESCE(a.checkin_info_2_4,0)) + sum(COALESCE(a.checkin_info_3_4,0)) + sum(COALESCE(a.checkin_info_4_4,0)) + sum(COALESCE(a.checkin_info_5_4,0)) + sum(COALESCE(a.checkin_info_6_4,0)) + sum(COALESCE(a.checkin_info_7_4,0)) + sum(COALESCE(a.checkin_info_8_4,0)) + sum(COALESCE(a.checkin_info_9_4,0)) + sum(COALESCE(a.checkin_info_10_4,0)) + sum(COALESCE(a.checkin_info_11_4,0)) + sum(COALESCE(a.checkin_info_12_4,0)) + sum(COALESCE(a.checkin_info_13_4,0)) + sum(COALESCE(a.checkin_info_14_4,0)) + sum(COALESCE(a.checkin_info_15_4,0)) + sum(COALESCE(a.checkin_info_16_4,0)) + sum(COALESCE(a.checkin_info_17_4,0)) + sum(COALESCE(a.checkin_info_18_4,0)) + sum(COALESCE(a.checkin_info_19_4,0)) + sum(COALESCE(a.checkin_info_20_4,0)) + sum(COALESCE(a.checkin_info_21_4,0)) + sum(COALESCE(a.checkin_info_22_4,0)) + sum(COALESCE(a.checkin_info_23_4,0)) ) as h_4,"+
				"(sum(COALESCE(a.checkin_info_0_5,0)) + sum(COALESCE(a.checkin_info_1_5,0)) + sum(COALESCE(a.checkin_info_2_5,0)) + sum(COALESCE(a.checkin_info_3_5,0)) + sum(COALESCE(a.checkin_info_4_5,0)) + sum(COALESCE(a.checkin_info_5_5,0)) + sum(COALESCE(a.checkin_info_6_5,0)) + sum(COALESCE(a.checkin_info_7_5,0)) + sum(COALESCE(a.checkin_info_8_5,0)) + sum(COALESCE(a.checkin_info_9_5,0)) + sum(COALESCE(a.checkin_info_10_5,0)) + sum(COALESCE(a.checkin_info_11_5,0)) + sum(COALESCE(a.checkin_info_12_5,0)) + sum(COALESCE(a.checkin_info_13_5,0)) + sum(COALESCE(a.checkin_info_14_5,0)) + sum(COALESCE(a.checkin_info_15_5,0)) + sum(COALESCE(a.checkin_info_16_5,0)) + sum(COALESCE(a.checkin_info_17_5,0)) + sum(COALESCE(a.checkin_info_18_5,0)) + sum(COALESCE(a.checkin_info_19_5,0)) + sum(COALESCE(a.checkin_info_20_5,0)) + sum(COALESCE(a.checkin_info_21_5,0)) + sum(COALESCE(a.checkin_info_22_5,0)) + sum(COALESCE(a.checkin_info_23_5,0)) ) as h_5,"+
				"(sum(COALESCE(a.checkin_info_0_6,0)) + sum(COALESCE(a.checkin_info_1_6,0)) + sum(COALESCE(a.checkin_info_2_6,0)) + sum(COALESCE(a.checkin_info_3_6,0)) + sum(COALESCE(a.checkin_info_4_6,0)) + sum(COALESCE(a.checkin_info_5_6,0)) + sum(COALESCE(a.checkin_info_6_6,0)) + sum(COALESCE(a.checkin_info_7_6,0)) + sum(COALESCE(a.checkin_info_8_6,0)) + sum(COALESCE(a.checkin_info_9_6,0)) + sum(COALESCE(a.checkin_info_10_6,0)) + sum(COALESCE(a.checkin_info_11_6,0)) + sum(COALESCE(a.checkin_info_12_6,0)) + sum(COALESCE(a.checkin_info_13_6,0)) + sum(COALESCE(a.checkin_info_14_6,0)) + sum(COALESCE(a.checkin_info_15_6,0)) + sum(COALESCE(a.checkin_info_16_6,0)) + sum(COALESCE(a.checkin_info_17_6,0)) + sum(COALESCE(a.checkin_info_18_6,0)) + sum(COALESCE(a.checkin_info_19_6,0)) + sum(COALESCE(a.checkin_info_20_6,0)) + sum(COALESCE(a.checkin_info_21_6,0)) + sum(COALESCE(a.checkin_info_22_6,0)) + sum(COALESCE(a.checkin_info_23_6,0)) ) as h_6 "+
				"from sharshar.check_in a where a.business_id in (select business_id from sharshar.business where categories like '%"+category+"%' AND city = '"+city+"')";
		System.out.println(queryString);
		ResultSet rset = stmt.executeQuery (queryString);
		while(rset.next()){
			wtrend=new WeeklyCheckinTrends(rset.getInt(1), rset.getInt(2), rset.getInt(3),rset.getInt(4),rset.getInt(5),rset.getInt(6),rset.getInt(7));
		}
		conn.close();
		return wtrend;



	}


	public ArrayList<DailyCheckinTrends>getDailyCheckinTrends(String city,String category) throws SQLException{

		ArrayList<DailyCheckinTrends> dailyCheckinList=new ArrayList();
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		Statement stmt = conn.createStatement ();

		int day;
		for( day=0;day<=6;day++)
		{       String queryString="select "+
				"avg(COALESCE(a.checkin_info_0_"+day+",0)) as h_0_"+day+",avg(COALESCE(a.checkin_info_1_"+day+",0)) as h_1_"+day+",avg(COALESCE(a.checkin_info_2_"+day+",0)) as h_2_"+day+","+
				"avg(COALESCE(a.checkin_info_3_"+day+",0)) as h_3_"+day+",avg(COALESCE(a.checkin_info_4_"+day+",0)) as h_4_"+day+",avg(COALESCE(a.checkin_info_5_"+day+",0)) as h_5_"+day+","+
				"avg(COALESCE(a.checkin_info_6_"+day+",0)) as h_6_"+day+",avg(COALESCE(a.checkin_info_7_"+day+",0)) as h_7_"+day+",avg(COALESCE(a.checkin_info_8_"+day+",0)) as h_8_"+day+","+
				"avg(COALESCE(a.checkin_info_9_"+day+",0)) as h_9_"+day+",avg(COALESCE(a.checkin_info_10_"+day+",0)) as h_10_"+day+",avg(COALESCE(a.checkin_info_11_"+day+",0)) as h_11_"+day+","+
				"avg(COALESCE(a.checkin_info_12_"+day+",0)) as h_12_"+day+",avg(COALESCE(a.checkin_info_13_"+day+",0)) as h_13_"+day+",avg(COALESCE(a.checkin_info_14_"+day+",0)) as h_14_"+day+","+
				"avg(COALESCE(a.checkin_info_15_"+day+",0)) as h_15_"+day+",avg(COALESCE(a.checkin_info_16_"+day+",0)) as h_16_"+day+",avg(COALESCE(a.checkin_info_17_"+day+",0)) as h_17_"+day+","+
				"avg(COALESCE(a.checkin_info_18_"+day+",0)) as h_18_"+day+",avg(COALESCE(a.checkin_info_19_"+day+",0)) as h_19_"+day+",avg(COALESCE(a.checkin_info_20_"+day+",0)) as h_20_"+day+","+
				"avg(COALESCE(a.checkin_info_21_"+day+",0)) as h_21_"+day+",avg(COALESCE(a.checkin_info_22_"+day+",0)) as h_22_"+day+",avg(COALESCE(a.checkin_info_23_"+day+",0)) as h_23_"+day+" from sharshar.check_in a "+
				" where a.business_id in (select business_id from sharshar.business "+
				" where categories like '%"+category+"%' AND city = '"+city+"')";
		System.out.println(queryString);
		ResultSet rset = stmt.executeQuery (queryString);
		while(rset.next()){
			String days="";
			if(day==0)
				days="Sunday";
			else if(day==1)
				days="Monday";
			else if(day==2)
				days="Tuesday";
			else if(day==3)
				days="Wednesday";
			else if(day==4)
				days="Thursday";
			else if(day==5)
				days="Friday";
			else if(day==6)
				days="Saturday";

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
