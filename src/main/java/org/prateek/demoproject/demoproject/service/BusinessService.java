package org.prateek.demoproject.demoproject.service;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.text.SimpleDateFormat;

import org.prateek.demoproject.demoproject.model.Business;
import org.prateek.demoproject.demoproject.model.BusinessMonthlyTrends;
import org.prateek.demoproject.demoproject.model.BusinessReview;
import org.prateek.demoproject.demoproject.model.Movie;

public class BusinessService {

	public List<Business> getSearchQueryBusinesses(String searchCriteraString,String city,String category ) throws SQLException{
		String queryPart="";
		String stringParts[]=searchCriteraString.split(",");
		for(String s:stringParts){
			queryPart+=s+"='TRUE' and ";

		}
		System.out.println(queryPart.substring(0,queryPart.length()-4));
String queryString="select business_id,name,stars from sharshar.business where  city='"+city+"' and CATEGORIES  like '%"+category+"%' and "+ queryPart.substring(0,queryPart.length()-4);
System.out.println(queryString);
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();


		 ResultSet rset = stmt.executeQuery (queryString);
		 List<Business> businessList=new ArrayList<Business>();

		 while (rset.next ()){

			 Business business=new Business(rset.getString("NAME"),rset.getString("BUSINESS_ID"),Float.parseFloat(rset.getString("STARS")));
			 businessList.add(business);

		 }


		 conn.close(); // ** IMPORTANT : Close connections when done **}
		return businessList;

	}

	public List<Business> getTop5Businesses(String city,String category,int review_count) throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 //String oldQuery = "select name,business_id,stars from(select name,business_id,stars from sharshar.BUSINESS where city='"+city+"' and CATEGORIES  like '%"+category+"%' and REVIEW_COUNT >"+review_count+" order by stars desc)where rownum <6 ";
		 String query = "select name,business_id,stars from sharshar.business where business_id in (select * from (select a.business_id as review_count from sharshar.business a join aravi.reviews b on a.business_id=b.business_id where a.categories like '%"+category+"%' AND city = '"+city+"' group by a.business_id,a.STARS order by a.stars desc) where ROWNUM<=6) order by stars desc";
		 ResultSet rset = stmt.executeQuery (query);
		 List<Business> businessList=new ArrayList<Business>();
		 if(!rset.next()){

			  rset = stmt.executeQuery ("select name,business_id,stars from(select name,business_id,stars from sharshar.BUSINESS where city='"+city+"' and CATEGORIES  like '%"+category+"%' order by stars desc)where rownum <6 ");
		 }
		 while (rset.next ()){

			 Business business=new Business(rset.getString("NAME"),rset.getString("BUSINESS_ID"),Float.parseFloat(rset.getString("STARS")));
			 businessList.add(business);

		 }


		 conn.close(); // ** IMPORTANT : Close connections when done **}
		return businessList;

	}
	public List<Business> getAllBusinesses(int num) throws SQLException{

		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =
			      DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 ResultSet rset = stmt.executeQuery ("select * from sharshar.BUSINESS");
		 List<Business> businessList=new ArrayList<Business>();

		 while (rset.next () && num>0){

			 Business business=new Business(
				rset.getString(1),
				rset.getString(2),
				rset.getString(3),
				rset.getString(4),
				rset.getString(5),
				rset.getString(6),
				rset.getString(7),
				rset.getString(8),
				rset.getString(9),
				rset.getString(10),
				rset.getString(11),
				rset.getString(12),
				rset.getString(13),
				rset.getString(14),
				rset.getString(15),
				rset.getString(16),
				rset.getString(17),
				rset.getString(18),
				rset.getString(19),
				rset.getString(20),
				rset.getString(21),
				rset.getString(22),
				rset.getString(23),
				rset.getString(24),
				rset.getString(25),
				rset.getString(26),
				rset.getString(27),
				rset.getString(28),
				rset.getString(29),
				rset.getString(30),
				rset.getString(31),
				rset.getInt(32),
				rset.getString(33),
				rset.getString(34),
				rset.getString(35),
				rset.getString(36),
				rset.getInt(37),
				rset.getString(38),
				rset.getString(39),
				rset.getString(40),
				rset.getString(41),
				rset.getString(42),
				rset.getString(43),
				rset.getString(44),
				rset.getString(45),
				rset.getString(46),
				rset.getString(47),
				rset.getString(48),
				rset.getString(49),
				rset.getString(50),
				rset.getString(51),
				rset.getString(52),
				rset.getString(53),
				rset.getString(54),
				rset.getString(55),
				rset.getString(56),
				rset.getString(57),
				rset.getString(58),
				rset.getString(59),
				rset.getString(60),
				rset.getString(61),
				rset.getFloat(62),
				rset.getString(63),
				rset.getString(65),
				rset.getString(66),
				rset.getFloat(67),
				rset.getString(68),
				rset.getString(69),
				rset.getFloat(70),
				rset.getString(71),
				rset.getString(72),
				rset.getString(73),
				rset.getString(74),
				rset.getString(75),
				rset.getString(76),
				rset.getString(77),
				rset.getString(78),
				rset.getString(79),
				rset.getString(80),
				rset.getString(81),
				rset.getString(82),
				rset.getString(83),
				rset.getString(84),
				rset.getString(85),
				rset.getString(86),
				rset.getString(87),
				rset.getString(88),
				rset.getString(89),
				rset.getString(90),
				rset.getString(91),
				rset.getString(92),
				rset.getString(93),
				rset.getString(94),
				rset.getString(95),
				rset.getString(96),
				rset.getString(97),
				rset.getString(98)
				);
			 businessList.add(business);
			 num--;
		 }


		 conn.close(); // ** IMPORTANT : Close connections when done **}
		return businessList;
	}

	public Business getBusiness(String businessId) throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =
			      DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 ResultSet rset = stmt.executeQuery ("select * from sharshar.BUSINESS where BUSINESS_ID='"+businessId+"'");
		 Business result = createBusinessObj(rset);
		 conn.close(); // ** IMPORTANT : Close connections when done **}
		 return result;


	}

	public List<BusinessMonthlyTrends> getBusinessMonthlyTrends(String businessId) throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =
			      DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 ResultSet rset = stmt.executeQuery ("select a.business_id,to_char(a.REVIEW_DATE,'MM-YY') as month,to_char(a.REVIEW_DATE,'YY') as year,avg(a.stars) as stars from aravi.reviews a where a.business_id='"+businessId+"' group by a.business_id,to_char(a.REVIEW_DATE,'MM-YY'),to_char(a.REVIEW_DATE,'YY') ORDER BY to_char(a.REVIEW_DATE,'YY')");

		 List<BusinessMonthlyTrends> monthlyTrendsList = new ArrayList<BusinessMonthlyTrends>();
		 //List<BusinessReview> businessReviewList=new ArrayList<BusinessReview>();

		 while (rset.next ()){

			 BusinessMonthlyTrends businessMonthlyTrend =new BusinessMonthlyTrends(
					 rset.getString("BUSINESS_ID"),
					 rset.getString("month"),
					 rset.getString("year"),
					 Float.parseFloat(rset.getString("stars"))
					 );
			 monthlyTrendsList.add(businessMonthlyTrend);


		 }
		 conn.close();
		 //System.out.println(businessMonthlyTrend.getBUSINESS_ID());
		 return monthlyTrendsList;
	}

	public Business createBusinessObj(ResultSet rset) throws SQLException{
		Business business = null;
		while (rset.next ()){

			 business=new Business (
				rset.getString(1),
				rset.getString(2),
				rset.getString(3),
				rset.getString(4),
				rset.getString(5),
				rset.getString(6),
				rset.getString(7),
				rset.getString(8),
				rset.getString(9),
				rset.getString(10),
				rset.getString(11),
				rset.getString(12),
				rset.getString(13),
				rset.getString(14),
				rset.getString(15),
				rset.getString(16),
				rset.getString(17),
				rset.getString(18),
				rset.getString(19),
				rset.getString(20),
				rset.getString(21),
				rset.getString(22),
				rset.getString(23),
				rset.getString(24),
				rset.getString(25),
				rset.getString(26),
				rset.getString(27),
				rset.getString(28),
				rset.getString(29),
				rset.getString(30),
				rset.getString(31),
				rset.getInt(32),
				rset.getString(33),
				rset.getString(34),
				rset.getString(35),
				rset.getString(36),
				rset.getInt(37),
				rset.getString(38),
				rset.getString(39),
				rset.getString(40),
				rset.getString(41),
				rset.getString(42),
				rset.getString(43),
				rset.getString(44),
				rset.getString(45),
				rset.getString(46),
				rset.getString(47),
				rset.getString(48),
				rset.getString(49),
				rset.getString(50),
				rset.getString(51),
				rset.getString(52),
				rset.getString(53),
				rset.getString(54),
				rset.getString(55),
				rset.getString(56),
				rset.getString(57),
				rset.getString(58),
				rset.getString(59),
				rset.getString(60),
				rset.getString(61),
				rset.getFloat(62),
				rset.getString(63),
				rset.getString(65),
				rset.getString(66),
				rset.getFloat(67),
				rset.getString(68),
				rset.getString(69),
				rset.getFloat(70),
				rset.getString(71),
				rset.getString(72),
				rset.getString(73),
				rset.getString(74),
				rset.getString(75),
				rset.getString(76),
				rset.getString(77),
				rset.getString(78),
				rset.getString(79),
				rset.getString(80),
				rset.getString(81),
				rset.getString(82),
				rset.getString(83),
				rset.getString(84),
				rset.getString(85),
				rset.getString(86),
				rset.getString(87),
				rset.getString(88),
				rset.getString(89),
				rset.getString(90),
				rset.getString(91),
				rset.getString(92),
				rset.getString(93),
				rset.getString(94),
				rset.getString(95),
				rset.getString(96),
				rset.getString(97),
				rset.getString(98)
				);
		}
		return business;
	}
}
