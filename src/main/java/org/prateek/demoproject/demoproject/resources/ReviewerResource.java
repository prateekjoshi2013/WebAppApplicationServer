package org.prateek.demoproject.demoproject.resources;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.prateek.demoproject.demoproject.model.Business;
import org.prateek.demoproject.demoproject.model.Reviewer;
import org.prateek.demoproject.demoproject.service.ReviewerService;

@Path("/reviewer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReviewerResource {

	ReviewerService reviewerService=new ReviewerService();

	@GET
	@Path("/{reviewerId}")
	public Reviewer getReviewer(@PathParam("reviewerId")String reviewerID) throws SQLException{
		return reviewerService.getReviewer(reviewerID);
	}



}
