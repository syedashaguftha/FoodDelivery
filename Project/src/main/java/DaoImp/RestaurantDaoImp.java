package DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import Dao.RestaurantDao;
import Pojo.Restaurant;
import Pojo.User;

public class RestaurantDaoImp implements RestaurantDao {
	
	Connection con;
	 	String GET_REST = "SELECT * FROM `Restaurant` WHERE `restaurantId` = ?";
	 	String INSERT = "INSERT INTO `Restaurant`(`name`, `address`, `phone`, `rating`, `cuisineType`, `isActive`, `eta`, `userId`, `imagePath`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    String GETALL_REST = "SELECT * FROM `Restaurant`";
	    String UPDATE_REST = "UPDATE `Restaurant` SET `name` = ?, `address` = ?, `phone` = ?, `rating` = ?, `cuisineType` = ?, `isActive` = ?, `eta` = ?, `userId` = ?, `imagePath` = ? WHERE `restaurantId` = ?";
	    String DELETE_REST = "DELETE FROM `Restaurant` WHERE `restaurantId` = ?";
	
	
	
	@Override
	public void addRestaurant(Restaurant restaurant) {
		  try {
			  Connection con = DBConnection.getConnection();
			  	PreparedStatement stmt = con.prepareStatement(INSERT);
	            stmt.setString(1, restaurant.getName());
	            stmt.setString(2, restaurant.getAddress());
	            stmt.setString(3, restaurant.getPhone());
	            stmt.setDouble(4, restaurant.getRating());
	            stmt.setString(5, restaurant.getCuisineType());
	            stmt.setBoolean(6, restaurant.isActive());
	            stmt.setString(7, restaurant.getEta());
	            stmt.setInt(8, restaurant.getUserId());
	            stmt.setString(9, restaurant.getImagePath());

	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public Restaurant getRestaurantId(int id) {
		Restaurant restaurant = new Restaurant();
        try  {
        	Connection con = DBConnection.getConnection();
        	PreparedStatement stmt = con.prepareStatement(GET_REST);
        
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            while(res.next()) {
            	int restaurantId=res.getInt(1);
            	String name=res.getString(2);
            	String address=res.getString(3);
            	String phone=res.getString(4);
            	double rating=res.getDouble(5);
            	String cuisineType=res.getString(6);
            	boolean isActive=res.getBoolean(7);
            	String eta=res.getString(8);
            	int userId=res.getInt(9);
        		String imagePath=res.getString(10);
        		restaurant = new Restaurant(restaurantId, name, address, phone,rating, cuisineType, isActive, eta, userId, imagePath);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return restaurant;
	
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> list = new ArrayList<Restaurant>();
		Restaurant restaurant;
        try  {
        	Connection con = DBConnection.getConnection();
        	PreparedStatement stmt = con.prepareStatement(GETALL_REST);
        	ResultSet res = stmt.executeQuery();
          
            while (res.next()) {
            
            	int restaurantId=res.getInt(1);
            	String name=res.getString(2);
            	String address=res.getString(3);
            	String phone=res.getString(4);
            	double rating=res.getDouble(5);
            	String cuisineType=res.getString(6);
            	boolean isActive=res.getBoolean(7);
            	String eta=res.getString(8);
            	int userId=res.getInt(9);
        		String imagePath=res.getString(10);
        		restaurant = new Restaurant(restaurantId, name, address, phone,rating, cuisineType, isActive, eta, userId, imagePath);
        		list.add(restaurant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return list;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		   try {
			   Connection con = DBConnection.getConnection();
			   PreparedStatement stmt = con.prepareStatement(UPDATE_REST);
	            stmt.setString(1, restaurant.getName());
	            stmt.setString(2, restaurant.getAddress());
	            stmt.setString(3, restaurant.getPhone());
	            stmt.setDouble(4, restaurant.getRating());
	            stmt.setString(5, restaurant.getCuisineType());
	            stmt.setBoolean(6, restaurant.isActive());
	            stmt.setString(7, restaurant.getEta());
	            stmt.setInt(8, restaurant.getUserId());
	            stmt.setString(9, restaurant.getImagePath());
	            stmt.setInt(10, restaurant.getRestaurantId());

	            stmt.executeUpdate();
	            int res=stmt.executeUpdate();
	            System.out.println(res);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		  try  {
			  Connection con = DBConnection.getConnection();
			  PreparedStatement stmt = con.prepareStatement(DELETE_REST);
	            stmt.setInt(1, restaurantId);
	            stmt.executeUpdate();
	            int res=stmt.executeUpdate();
	            System.out.println(res);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

}
