package DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import Dao.MenuDao;
import Pojo.Menu;

public class MenuDaoImp implements MenuDao {
	
	Connection con = DBConnection.getConnection();
	
	String INSERT_MENU = "INSERT INTO `menu` (`restaurantId`, `itemName`, `description`, `price`, `ratings`, `isAvailable`, `imagePath`) VALUES (?, ?, ?, ?, ?, ?, ?)";
	String GET_MENU = "SELECT * FROM `menu` WHERE `menuId` = ?";
	String GETALL_MENUITEMS = "SELECT * FROM `menu`";
	String GETMENU_BY_RESTAURANT_ID = "SELECT * FROM `menu` WHERE `restaurantId` = ?";
	String UPDATE_MENU = "UPDATE `menu` SET `restaurantId` = ?, `itemName` = ?, `description` = ?, `price` = ?, `ratings` = ?, `isAvailable` = ?, `imagePath` = ? WHERE `menuId` = ?";
	String DELETE_MENU = "DELETE FROM `menu` WHERE `menuId` = ?";
	
	@Override
	public void addMenuItem(Menu menu) {
		try {
			PreparedStatement stmt = con.prepareStatement(INSERT_MENU);
			stmt.setInt(1, menu.getRestaurantId());
			stmt.setString(2, menu.getItemName());
			stmt.setString(3, menu.getDescription());
			stmt.setDouble(4, menu.getPrice());
			stmt.setInt(5, menu.getRatings());
			stmt.setBoolean(6, menu.isAvailable());
			stmt.setString(7, menu.getImagePath());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
		public Menu getMenuItemById(int id) {
		    Menu menu = null;
		    try {
		        PreparedStatement stmt = con.prepareStatement(GET_MENU);
		        stmt.setInt(1, id);
		        ResultSet res = stmt.executeQuery();
		        if (res.next()) {
		            int menuId = res.getInt(1);
		            int restaurantId = res.getInt(2);
		            String itemName = res.getString(3);
		            String description = res.getString(4);
		            double price = res.getDouble(5);
		            int ratings = res.getInt(6);
		            boolean isAvailable = res.getBoolean(7);
		            String imagePath = res.getString(8);

		            menu = new Menu(menuId, restaurantId, itemName, description, price, ratings, isAvailable, imagePath);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return menu;
		}


	@Override
		public List<Menu> getAllMenuItems() {
		    List<Menu> list = new ArrayList<Menu>();
		    Menu menu = null;
		    try {
		        PreparedStatement stmt = con.prepareStatement(GETALL_MENUITEMS);
		        ResultSet res = stmt.executeQuery();
		        while (res.next()) {
		            int menuId = res.getInt(1);
		            int restaurantId = res.getInt(2);
		            String itemName = res.getString(3);
		            String description = res.getString(4);
		            double price = res.getDouble(5);
		            int ratings = res.getInt(6);
		            boolean isAvailable = res.getBoolean(7);
		            String imagePath = res.getString(8);
		            
		            menu = new Menu(menuId, restaurantId, itemName, description, price, ratings, isAvailable, imagePath);
		            list.add(menu);

		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return list;
		}

	
		@Override
		public List<Menu> getMenuItemsByRestaurantId(int restaurantId) {
		    List<Menu> list = new ArrayList<Menu>();
		    Menu menu = null;
		    try {
		        PreparedStatement stmt = con.prepareStatement(GETMENU_BY_RESTAURANT_ID);
		        stmt.setInt(1, restaurantId);
		        ResultSet res = stmt.executeQuery();
		        while (res.next()) {
		            int menuId = res.getInt(1);
		            int restId = res.getInt(2);
		            String itemName = res.getString(3);
		            String description = res.getString(4);
		            double price = res.getDouble(5);
		            int ratings = res.getInt(6);
		            boolean isAvailable = res.getBoolean(7);
		            String imagePath = res.getString(8);

		            menu = new Menu(menuId, restId, itemName, description, price, ratings, isAvailable, imagePath);
		            list.add(menu);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return list;
		}

	

	@Override
	public void updateMenuItem(Menu menu) {
		try {
			PreparedStatement stmt = con.prepareStatement(UPDATE_MENU);
			stmt.setInt(1, menu.getRestaurantId());
			stmt.setString(2, menu.getItemName());
			stmt.setString(3, menu.getDescription());
			stmt.setDouble(4, menu.getPrice());
			stmt.setInt(5, menu.getRatings());
			stmt.setBoolean(6, menu.isAvailable());
			stmt.setString(7, menu.getImagePath());
			stmt.setInt(8, menu.getMenuId());
			int res = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenuItem(int menuId) {
		try {
			PreparedStatement stmt = con.prepareStatement(DELETE_MENU);
			stmt.setInt(1, menuId);
			int res = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}