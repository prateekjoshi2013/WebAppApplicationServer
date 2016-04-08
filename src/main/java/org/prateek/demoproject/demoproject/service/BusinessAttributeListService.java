package org.prateek.demoproject.demoproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.prateek.demoproject.demoproject.model.BusinessAttributesList;

public class BusinessAttributeListService {

	public BusinessAttributesList getBusinessAtrributeList() throws SQLException{

		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
        ArrayList<String> attributeList=new ArrayList();

		 ResultSet rset = stmt.executeQuery ("select column_name from all_tab_columns where TABLE_NAME = 'BUSINESS' AND OWNER ='SHARSHAR'");
		while(rset.next()){
			String attr=rset.getString(1);
			if(!attr.equalsIgnoreCase("LONGITUDE")&&!attr.equalsIgnoreCase("NEIGHBORHOODS")&&!attr.equalsIgnoreCase("BUSINESS_ID")&&!attr.equalsIgnoreCase("CATEGORIES")
					&&!attr.equalsIgnoreCase("NAME")&&!attr.equalsIgnoreCase("REVIEW_COUNT")&&!attr.equalsIgnoreCase("STATE")&&!attr.equalsIgnoreCase("FULL_ADDRESS")&&!attr.equalsIgnoreCase("OPEN")
					&&!attr.equalsIgnoreCase("CITY")&&!attr.equalsIgnoreCase("STARS")&&!attr.equalsIgnoreCase("TYPE")&&!attr.equalsIgnoreCase("LATITUDE"))
			{
				attributeList.add(attr);

			}

		}

		 return new BusinessAttributesList(attributeList);


	}

}
