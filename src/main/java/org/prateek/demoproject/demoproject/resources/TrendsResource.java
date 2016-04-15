package org.prateek.demoproject.demoproject.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.prateek.demoproject.demoproject.model.DailyCheckinTrends;
import org.prateek.demoproject.demoproject.model.ReviewTrend;
import org.prateek.demoproject.demoproject.service.TrendsService;

@Path("/trends")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TrendsResource {

	TrendsService trendsService=new TrendsService();

	@GET
	@Path("/monthly_trends/{city}/{category}")
	public ArrayList<ReviewTrend> getReviewTrends(@PathParam("city")String city,@PathParam("category")String category) throws SQLException{
		return trendsService.getReviewTrends(city,category);
	}
	@GET
	@Path("/daily_checkin/{city}/{category}")
	public ArrayList<DailyCheckinTrends> getDailyCheckinTrends(@PathParam("city")String city,@PathParam("category")String category) throws SQLException{
		return trendsService.getDailyCheckinTrends(city,category);
	}

}
