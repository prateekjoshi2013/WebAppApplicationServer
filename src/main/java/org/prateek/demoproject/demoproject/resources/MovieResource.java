package org.prateek.demoproject.demoproject.resources;

import java.sql.SQLException;
import java.util.List;


import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.prateek.demoproject.demoproject.model.Movie;
import org.prateek.demoproject.demoproject.service.MovieService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

MovieService movieService=new MovieService();

@GET
public List<Movie> getMovies() throws SQLException{
	return movieService.getAllMovies();
}
@GET
@Path("/{movieID}")
public Movie getMovie(@PathParam("movieID")String movieID) throws SQLException{
	return movieService.getMovie(movieID);

}

@POST
public Movie addMovie(Movie movie) throws SQLException{
 return movieService.insertMovie(movie);
}

@PUT
@Path("/{movieID}")
public Movie updateMovie(@PathParam("movieID")Long movieID,Movie movie) throws SQLException{
movie.setId(movieID);
return movieService.updateMovie(movie);
}

@DELETE
@Path("/{movieID}")
public String deleteMovie(@PathParam("movieID")String movieID) throws SQLException{
	movieService.removeMovie(movieID);

	return "deleted";
}

}
