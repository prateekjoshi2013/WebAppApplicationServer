package org.prateek.demoproject.demoproject.resources;

import java.sql.SQLException;
import java.util.List;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import org.prateek.demoproject.demoproject.model.Business;
import org.prateek.demoproject.demoproject.model.BusinessMonthlyTrends;
import org.prateek.demoproject.demoproject.model.BusinessReview;
import org.prateek.demoproject.demoproject.model.Movie;
import org.prateek.demoproject.demoproject.service.BusinessReviewService;
import org.prateek.demoproject.demoproject.service.BusinessService;
import org.prateek.demoproject.demoproject.service.MovieService;

@Path("/business")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BusinessResource {

	BusinessService businessService=new BusinessService();
	BusinessReviewService businessReviewService = new BusinessReviewService();

	@GET
	@Path("/getAll/{num}")
	public List<Business> getBuisnesses(@PathParam("num")int num) throws SQLException{
		return businessService.getAllBusinesses(num);
	}

	@GET
	@Path("/{city}/{category}/{review_count}")  //String city,String category,int review_count
	public List<Business> getTop5Buisnesses(@PathParam("city")String city,@PathParam("category")String category,@PathParam("review_count") int review_count) throws SQLException{
		return businessService.getTop5Businesses(city,category,review_count);
	}

	@GET
	@Path("/{businessId}")
	public Business getBusiness(@PathParam("businessId")String businessId) throws SQLException{
		return businessService.getBusiness(businessId);
	}
	
	@GET
	@Path("/{businessId}/reviews")
	public List<BusinessReview> getBusinessReviews(@PathParam("businessId")String businessId) throws SQLException{
		return businessReviewService.getBusinessReviews(businessId);
	}
	
	@GET
	@Path("/{businessId}/monthly_trends")
	public List<BusinessMonthlyTrends> getBusinessMonthlyTrends(@PathParam("businessId")String businessId) throws SQLException{
		return businessService.getBusinessMonthlyTrends(businessId);
	}
	
}
