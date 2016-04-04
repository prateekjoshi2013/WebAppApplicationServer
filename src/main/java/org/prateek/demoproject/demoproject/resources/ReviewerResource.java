package org.prateek.demoproject.demoproject.resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.prateek.demoproject.demoproject.model.Business;
import org.prateek.demoproject.demoproject.model.Review;
import org.prateek.demoproject.demoproject.model.Reviewer;
import org.prateek.demoproject.demoproject.model.ReviewerCategoryRatingDistribution;
import org.prateek.demoproject.demoproject.model.ReviewerRatingDistribution;
import org.prateek.demoproject.demoproject.model.ReviewerReview;
import org.prateek.demoproject.demoproject.model.ReviewerTip;
import org.prateek.demoproject.demoproject.model.TopEliteReviewer;
import org.prateek.demoproject.demoproject.model.TopReviewer;
import org.prateek.demoproject.demoproject.service.ReviewerCategoryRatingDistributionService;
import org.prateek.demoproject.demoproject.service.ReviewerRatingDistributionService;
import org.prateek.demoproject.demoproject.service.ReviewerReviewTipService;
import org.prateek.demoproject.demoproject.service.ReviewerService;
import org.prateek.demoproject.demoproject.service.TopEliteReviewerService;
import org.prateek.demoproject.demoproject.service.TopReviewerService;

@Path("/reviewer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReviewerResource {

	ReviewerService reviewerService=new ReviewerService();
	TopReviewerService topReviewerService=new TopReviewerService();
	TopEliteReviewerService topEliteReviewerService=new TopEliteReviewerService();
	ReviewerRatingDistributionService reviewerRatingDistributionService=new ReviewerRatingDistributionService();
	ReviewerReviewTipService reviewerReviewTipService = new ReviewerReviewTipService();
	ReviewerCategoryRatingDistributionService reviewerCategoryRatingDistributionService=new ReviewerCategoryRatingDistributionService();
	@GET
	@Path("/{reviewerId}")
	public Reviewer getReviewer(@PathParam("reviewerId")String reviewerID) throws SQLException{
		return reviewerService.getReviewer(reviewerID);


	}

	//Reviewer/home/{city}/{category}/top_reviewer/{count}
	@GET
	@Path("home/{city}/{category}/top_reviewer/{count}")
	public ArrayList<TopReviewer> getTopReviewer(@PathParam("city")String city,@PathParam("category")String category,@PathParam("count")int count) throws SQLException{
		return topReviewerService.getTopReviewer(city,category,count);


	}
	@GET
	@Path("/home/{city}/{category}/elite_reviewer/{count}")
	public ArrayList<TopEliteReviewer> getTopEliteReviewer(@PathParam("city")String city,@PathParam("category")String category,@PathParam("count")int count) throws SQLException{
		return topEliteReviewerService.getTopReviewer(city, category, count);
	}

	@GET
	@Path("/{reviewerId}/reviews")
	public List<ReviewerReview> getReviewerReviews(@PathParam("reviewerId")String reviewerID) throws SQLException{
		return reviewerReviewTipService.getReviewerReviews(reviewerID);


	}

	@GET
	@Path("/{reviewerId}/tips")
	public List<ReviewerTip> getReviewerTips(@PathParam("reviewerId")String reviewerID) throws SQLException{
		return reviewerReviewTipService.getReviewerTips(reviewerID);


	}
	@GET
	@Path("/{reviewerId}/rating_distribution")
	public ArrayList<ReviewerRatingDistribution> getReviewerRatingDistribution(@PathParam("reviewerId")String reviewerId)throws SQLException{
		//System.out.println(reviewerId);
		return reviewerRatingDistributionService.getReviewerRatingDistribution(reviewerId);
}
	@GET
	@Path("/{reviewerId}/categories_review_distribution")
	public ArrayList<ReviewerCategoryRatingDistribution> getReviewerCategoryRatingDistribution(@PathParam("reviewerId")String reviewerId)throws SQLException{
		//System.out.println(reviewerId);
		return reviewerCategoryRatingDistributionService.getReviewerCategoryRatingDistribution(reviewerId);
}
}