package Dao;

import java.util.List;

import Pojo.Menu;

public interface MenuDao {
    void addMenuItem(Menu menu);
    Menu getMenuItemById(int menuId);
    List<Menu> getAllMenuItems();
    List<Menu> getMenuItemsByRestaurantId(int restaurantId);
    void updateMenuItem(Menu menu);
    void deleteMenuItem(int menuId);



}
