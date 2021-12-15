package io.javabrains.moviecatalogservice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CatalogObjForHystrix {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getCatalogObjFallback")
	public CatalogItem getCatalogObj(Rating rating){
		
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" 
				+ rating.getMovieId(), Movie.class);
		
		return new CatalogItem(movie.getName(),movie.getName(),rating.getRating());		
	}
	
	public CatalogItem getCatalogObjFallback(Rating rating){
			return new CatalogItem("No Movie","",0);
	}

}
