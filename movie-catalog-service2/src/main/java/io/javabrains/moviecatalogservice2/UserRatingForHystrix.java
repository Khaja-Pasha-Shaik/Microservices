package io.javabrains.moviecatalogservice2;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingForHystrix {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getUserRatingFallback")
	public UserRating getUserRating(String userId){
		UserRating ratings = restTemplate
				.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class);
		return ratings;
	}
	
	
	public UserRating getUserRatingFallback(String userId){
			
		UserRating userRating = new UserRating();
		userRating.setUserId(userId);
		userRating.setRatingList(Arrays.asList(new Rating("No Movie",0)));
		return userRating;
	}
	

}
