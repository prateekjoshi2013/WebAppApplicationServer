package org.prateek.demoproject.demoproject.service;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.text.SimpleDateFormat;

import org.prateek.demoproject.demoproject.model.Movie;

public class MovieService {

	public List<Movie> getAllMovies() throws SQLException{

		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn =
			      DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 ResultSet rset = stmt.executeQuery ("select * from MOVIE");
		 List<Movie> movieList=new ArrayList<Movie>();

		 while (rset.next ()){

			 Movie movie=new Movie(rset.getLong(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getDate(5),rset.getInt(6));
			 movieList.add(movie);
		 }


		 conn.close(); // ** IMPORTANT : Close connections when done **}
		return movieList;
	}

	public Movie getMovie(String ID) throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 ResultSet rset = stmt.executeQuery ("select * from MOVIE where movieid="+ID);
		 Movie movie=null;
		 while(rset.next()){
		movie =new Movie(rset.getLong(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getDate(5),rset.getInt(6));
		 }
		 conn.close();
		return movie;

	}


	public Movie updateMovie(Movie movie) throws  SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yy");
		 ResultSet rset = stmt.executeQuery ("UPDATE MOVIE SET NAME=\'"+movie.getName()+"\',rated=\'"+movie.getRated()+"\',category=\'"+movie.getCategory()+"\',releasedate=to_date('"+ ft.format(movie.getReleaseDate()) + "', 'MM/DD/YY'),length="+movie.getLength()+"where movieid="+movie.getId());
		 conn.close();
		 return movie;

	}

	//Long ID,String name,String rated,String category,java.util.Date date,int length
	public Movie insertMovie(Movie movie) throws  SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yy");
		 //String update =  ("INSERT INTO MOVIE( MOVIEID,NAME,RATED,CATEGORY,LENGTH) VALUES("+movie.getId()+",\""+movie.getName()+"\",\""+movie.getRated()+"\",\""+movie.getCategory()+"\","+movie.getLength()+")");
		 String str="insert into MOVIE values("+movie.getId()+", \'"+movie.getName()+"\', \'"+movie.getRated()+"\', \'"+movie.getCategory()+"\',to_date('"
				+ ft.format(movie.getReleaseDate()) + "', 'MM/DD/YY') ,"+movie.getLength()+")" ;
		// String update =  "INSERT INTO MOVIE( MOVIEID,NAME) VALUES("+movie.getId()+",\""+movie.getName()+"\")";
		 Statement statement=null;
		 statement = conn.createStatement();
		 statement.execute(str);
		 conn.close();
		 return movie;

	}



	public void removeMovie(String ID) throws  SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","ntiware", "nikhil123");
		 Statement stmt = conn.createStatement ();
		 ResultSet rset = stmt.executeQuery ("delete from MOVIE where movieid="+ID);
		 conn.close();

	}

}
