package Dao;

import java.util.List;

import Pojo.Restaurant;

public interface RestaurantDao {
	 void addRestaurant(Restaurant restaurant);
	    Restaurant getRestaurantId(int restaurantId);
	    List<Restaurant> getAllRestaurants();
	    void updateRestaurant(Restaurant restaurant);
	    void deleteRestaurant(int restaurantId);


}
