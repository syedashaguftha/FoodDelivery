package DaoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import Dao.userDao;
import Pojo.User;

public class UserDaoImp implements userDao {
	public static Connection con;
	
	String GET_USER = "SELECT * FROM `user` WHERE `userId` = ?";
    String INSERT = "INSERT INTO `user`(`name`, `username`, `password`, `email`, `phone`, `address`, `role`,`createdDate`, `lastLoginDate`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_USER = "UPDATE `user` SET `name` = ?, `password` = ?, `phone` = ?, `address` = ?, `role` = ? WHERE `userId` = ?";
    String DELETE_USER = "DELETE FROM `user` WHERE `userId` = ?";
    String GETALL_USERS = "SELECT * FROM `user`";
    private String CHECK_LOGIN="SELECT* FROM `user` WHERE `username`=? AND `password`=?";
	User user=new User();
	
    @Override
	public void addUser(User user) {
		try  {
			con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(INSERT);
           
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getAddress());
            stmt.setString(7, user.getRole());
            stmt.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
			stmt.setTimestamp(9,new Timestamp(System.currentTimeMillis()));

            int res = stmt.executeUpdate() ;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
	}

	@Override
	public User getUserId(int id) {
	        User user = new User();
	       
	        try{
	        	con = DBConnection.getConnection();
	            PreparedStatement stmt = con.prepareStatement(GET_USER);
	            stmt.setInt(1, id);
	            ResultSet res = stmt.executeQuery();
	            while(res.next()) {
	            	int userId=res.getInt(1);
	            	String name=res.getString(2);
	        		String username=res.getString(3);
	        		String password=res.getString(4);
	        		String email=res.getString(5);
	        		String phone=res.getString(6);
	        		String address=res.getString(7);
	        		String role=res.getString(8);
	        		user = new User(userId,name, username, password,email, phone, address, role);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;

		
	}

	@Override
	public List<User> getAllUsers() {
	
		List<User> list = new ArrayList<User>();
		User user;
		
        try {
        	con = DBConnection.getConnection();
           
            PreparedStatement stmt = con.prepareStatement(GETALL_USERS);
            ResultSet res = stmt.executeQuery();
            
            while(res.next()) {
            	int userId=res.getInt(1);
	        	String name=res.getString(2);
	    		String username=res.getString(3);
	    		String password=res.getString(4);
	    		String email=res.getString(5);
	    		String phone=res.getString(6);
	    		String address=res.getString(7);
	    		String role=res.getString(8);
        		user = new User(userId, name, username, password,email, phone, address, role);
        		list.add(user);
        		
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


	@Override
	public void updateUser(User user) {

	     try  {
	    	 con = DBConnection.getConnection();
	            PreparedStatement stmt = con.prepareStatement(UPDATE_USER);
	            
	            stmt.setString(1, user.getName());
	            stmt.setString(2, user.getPassword());
	            stmt.setString(3, user.getPhone());
	            stmt.setString(4, user.getAddress());
	            stmt.setString(5, user.getRole());
	            stmt.setInt(6, user.getUserId());
	            stmt.executeUpdate();
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		
	

	@Override
	public void deleteUser(int userId) {

		  try{
			  con = DBConnection.getConnection();
	            PreparedStatement stmt = con.prepareStatement(DELETE_USER);
	            stmt.setInt(1, userId);
	            stmt.executeUpdate();
	          
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		
	}
	@Override
	public User checkLogin(String username, String password) {
		user=null;
		
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(CHECK_LOGIN);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				user=new User();
				user.setUserId(res.getInt(1));
				user.setName(res.getString(2));
				user.setUsername(res.getString(3));
				user.setPassword(res.getString(4));
				user.setEmail(res.getString(5));
				user.setPhone(res.getString(6));
				user.setAddress(res.getString(7));
				user.setRole(res.getString(8));
				user.setCreatedDate(res.getTimestamp(9));
				user.setLastLoginDate(res.getTimestamp(10));
				
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}



}
