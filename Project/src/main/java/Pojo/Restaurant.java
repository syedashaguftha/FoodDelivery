package Pojo;

public class Restaurant {
    private int restaurantId;
    private String name;
    private String address;
    private String phone;
    private double rating;
    private String cuisineType;
    private boolean isActive;
    private String eta;
    private int userId;
    private String imagePath;
    
    public Restaurant() {}
	public Restaurant(int restaurantId, String name, String address, String phone, double rating, String cuisineType,
			boolean isActive, String eta, int userId, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.cuisineType = cuisineType;
		this.isActive = isActive;
		this.eta = eta;
		this.userId = userId;
		this.imagePath = imagePath;
	}
	
	
	public Restaurant(String name, String address, String phone, double rating, String cuisineType, boolean isActive,
			String eta, int userId, String imagePath) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.cuisineType = cuisineType;
		this.isActive = isActive;
		this.eta = eta;
		this.userId = userId;
		this.imagePath = imagePath;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", rating=" + rating + ", cuisineType=" + cuisineType + ", isActive=" + isActive + ", eta="
				+ eta + ", userId=" + userId + ", imagePath=" + imagePath + "]";
	}
    


}
