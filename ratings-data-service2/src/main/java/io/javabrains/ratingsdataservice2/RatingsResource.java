package io.javabrains.ratingsdataservice2;

import java.util.Arrays;
import java.util.List;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/hello")
	public String getHello(){
			return "Hello";
	}
	
	
	@RequestMapping("movies/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId){
			return new Rating(movieId, 4);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getAllMovieRating(@PathVariable("userId") String userId){
			List<Rating> ratings = Arrays.asList(
					new Rating("100",5),
					new Rating("200",4)
					);
			
			UserRating ratingsListobj = new UserRating();
			ratingsListobj.setRatingList(ratings);
			return ratingsListobj;
	}
	

}
