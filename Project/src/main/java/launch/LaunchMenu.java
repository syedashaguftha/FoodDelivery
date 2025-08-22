
package launch;

import java.util.List;
import java.util.Scanner;

import DaoImp.MenuDaoImp;
import Pojo.Menu;

public class LaunchMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuDaoImp menuDao = new MenuDaoImp();

        // === Add a new menu item ===
//        System.out.println("Enter restaurant ID:");
//        int restaurantId = sc.nextInt(); sc.nextLine();
//        System.out.println("Enter item name:");
//        String itemName = sc.nextLine();
//        System.out.println("Enter description:");
//        String description = sc.nextLine();
//        System.out.println("Enter price:");
//        double price = sc.nextDouble(); sc.nextLine();
//        System.out.println("Enter ratings (1 to 5):");
//        int ratings = sc.nextInt(); sc.nextLine();
//        System.out.println("Is available? (true/false):");
//        boolean isAvailable = sc.nextBoolean(); sc.nextLine();
//        System.out.println("Enter image path:");
//        String imagePath = sc.nextLine();
//
//        Menu newMenu = new Menu(0, restaurantId, itemName, description, price, ratings, isAvailable, imagePath);
//        menuDao.addMenuItem(newMenu);

        // === Get a menu item by ID ===
//        System.out.println("Enter Menu ID to fetch:");
//        int menuId = sc.nextInt();
//        Menu m = menuDao.getMenuItemById(menuId);
//        System.out.println(m);

        // === Get all menu items ===
//        List<Menu> menus = menuDao.getAllMenuItems();
//        for (Menu m : menus) {
//            System.out.println(m);
//        }

        // === Get menu items by restaurant ID ===
        System.out.println("Enter Restaurant ID to fetch menu items:");
        int restId = sc.nextInt();
        List<Menu> items = menuDao.getMenuItemsByRestaurantId(restId);
        for (Menu m : items) {
            System.out.println(m);
        }

        // === Update a menu item ===
//        System.out.println("Enter Menu ID to update:");
//        int updateId = sc.nextInt();
//        Menu menuToUpdate = menuDao.getMenuItemById(updateId);

//            menuToUpdate.setPrice(menuToUpdate.getPrice() + 10); 
//            menuToUpdate.setRatings(5);                         
//            menuDao.updateMenuItem(menuToUpdate);
//            System.out.println("Menu item updated.");


        // === Delete a menu item ===
//        System.out.println("Enter Menu ID to delete:");
//        int deleteId = sc.nextInt();
//        menuDao.deleteMenuItem(deleteId);
//        System.out.println("Menu item deleted.");

        sc.close();
    }
}
