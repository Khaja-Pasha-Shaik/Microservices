package io.javabrains.moviecatalogservice2;

import java.util.List;

public class UserRating {
	
	private String userId;
	private List<Rating> ratingList;
	
	
	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}
	
	

}
