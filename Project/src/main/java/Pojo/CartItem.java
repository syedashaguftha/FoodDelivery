package Pojo;

public class CartItem {
	private int menuId;
	private  String name;
	private double price;
	private int quantity;
	private int restaurantId;
	public CartItem(int menuId, String name, double price, int restaurantId, int quantity) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.restaurantId = restaurantId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public double getTotalPrice() {
	    return this.price * this.quantity;
	}

}