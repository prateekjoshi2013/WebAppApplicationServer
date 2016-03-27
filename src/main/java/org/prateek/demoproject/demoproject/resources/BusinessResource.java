package org.prateek.demoproject.demoproject.resources;

import java.sql.SQLException;
import java.util.List;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import org.prateek.demoproject.demoproject.model.Business;
import org.prateek.demoproject.demoproject.model.Movie;
import org.prateek.demoproject.demoproject.service.BusinessService;
import org.prateek.demoproject.demoproject.service.MovieService;

@Path("/business")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BusinessResource {

	BusinessService businessService=new BusinessService();

	@GET
	@Path("/{num}")
	public List<Business> getMovies(@PathParam("num")int num) throws SQLException{
		return businessService.getAllBusinesses(num);
	}

}
