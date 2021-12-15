package io.javabrains.moviecatalogservice2;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRatingForHystrix userRatingForHystrix;
	
	@Autowired
	private CatalogObjForHystrix catalogObjForHystrix;
	
	// Async Programming
//	@Autowired
//	private WebClient.Builder webClientbuilder;
	
	@RequestMapping("/{userId}")
	
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		
		UserRating ratings = userRatingForHystrix.getUserRating(userId);
		
		
		return ratings.getRatingList().stream().map(rating -> catalogObjForHystrix.getCatalogObj(rating))
				.collect(Collectors.toList());
			
			//Synchronous Programming
			// Async Programming
//			Movie movie = webClientbuilder.build()
//			.get()
//			.uri("http://localhost:8082/movies/" +rating.getMovieId())
//			.retrieve()
//			.bodyToMono(Movie.class)
//			.block();
			
	}
	
	
	
	
	
	

}
