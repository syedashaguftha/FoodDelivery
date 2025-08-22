package launch;

import java.util.List;
import java.util.Scanner;

import DaoImp.RestaurantDaoImp;
import Pojo.Restaurant;

public class LaunchRestaurant {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        RestaurantDaoImp restDao = new RestaurantDaoImp();

	        List<Restaurant> restaurants = restDao.getAllRestaurants();
	        for (Restaurant r : restaurants) {
	            System.out.println(r);
	        }

	        

//	        System.out.println("Enter restaurant name:");
//	        String name = sc.nextLine();
//	        System.out.println("Enter address:");
//	        String address = sc.nextLine();
//	        System.out.println("Enter phone:");
//	        String phone = sc.nextLine();
//	        System.out.println("Enter rating:");
//	        double rating = sc.nextDouble(); sc.nextLine(); // consume newline
//	        System.out.println("Enter cuisine type:");
//	        String cuisineType = sc.nextLine();
//	        System.out.println("Is active? (true/false):");
//	        boolean isActive = sc.nextBoolean(); sc.nextLine();
//	        System.out.println("Enter ETA:");
//	        String eta = sc.nextLine();
//	        System.out.println("Enter user ID:");
//	        int userId = sc.nextInt(); sc.nextLine();
//	        System.out.println("Enter image path:");
//	        String imagePath = sc.nextLine();
//	
//	        Restaurant newRest = new Restaurant( name, address, phone, rating, cuisineType, isActive, eta, userId, imagePath);
//	        restDao.addRestaurant(newRest);

//	        getRestaurant
//	        System.out.println("Enter restaurant ID to fetch:");
//	        int id = sc.nextInt();
//	        Restaurant r = restDao.getRestaurantId(id);
//	        System.out.println(r);

	        // Update a restaurant
	        
//	            r.setRating(4.9);
//	          
//	            restDao.updateRestaurant(r);
	        

	        // Delete a restaurant
//	        System.out.println("Enter restaurant ID to delete:");
//	        int deleteId = sc.nextInt();
//	        restDao.deleteRestaurant(deleteId);

	        sc.close();
	    }
	}



