<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Pojo.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restaurants List</title>
    <link rel="stylesheet" href="styleRest.css">
    
</head>
<body>

<header>
  <div class="logo" style="color: #dc3545">FoodDelivery</div>



  <div class="nav-links">
    <a href="login.jsp"><i class="fas fa-search"></i>Login</a>
    <a href="RestaurantServlet"><i class="fas fa-user"></i>Home</a>
    <a href="cart.jsp"><i class="fas fa-shopping-cart"></i>Cart</a>
    <a href="logout.jsp"><i class="fas fa-sign-out-alt"></i>Logout</a>
  </div>
</header>

<!-- Main Content -->
<main>
  <h1 style="color: #dc3545">Restaurants near you</h1>

<div class="restaurant-container">
<%
    List<Restaurant> restList = (List<Restaurant>) request.getAttribute("Restaurant");
	if (restList != null) {
		for (Restaurant r : restList) {
    	
%>
    <div class="restaurant-card">
        <a href="MenuServlet?restaurantId=<%= r.getRestaurantId() %>" style="text-decoration: none; color: inherit;">
            <img src="<%= r.getImagePath() %>" alt="<%= r.getName() %>">
            <h3><%= r.getName() %></h3>
            <p><%= r.getCuisineType() %></p>
            <p>
                <span class="rating"><%= r.getRating() %> ★</span>
                <span class="meta-info"><%= r.getEta() %> mins</span>
            </p>
        </a>
    </div>
<%
    }
} else {
%>
    <p>No restaurants available.</p>
<%
}
%>
</div>

</main>

<footer>
  <div class="footer-section">
    <h4>Company</h4>
    <ul>
      <li><a href="#">About us</a></li>
      <li><a href="#">Team</a></li>
      <li><a href="#">Careers</a></li>
      <li><a href="#">Blog</a></li>
    </ul>
  </div>

  <div class="footer-section">
    <h4>Contact</h4>
    <ul>
      <li><a href="#">Help & Support</a></li>
      <li><a href="#">Partner with us</a></li>
      <li><a href="#">Ride with us</a></li>
    </ul>
  </div>

  <div class="footer-section">
    <h4>Legal</h4>
    <ul>
      <li><a href="#">Terms & Conditions</a></li>
      <li><a href="#">Refund & Cancellation</a></li>
      <li><a href="#">Privacy Policy</a></li>
      <li><a href="#">Cookie Policy</a></li>
    </ul>
  </div>

  <div class="footer-section">
    <h4>Social Links</h4>
    <div class="social-icons">
      <a href="#"><i class="fab fa-facebook"></i> Facebook</a>
      <a href="#"><i class="fab fa-twitter"></i> Twitter</a>
      <a href="#"><i class="fab fa-instagram"></i> Instagram</a>
      <a href="#"><i class="fab fa-youtube"></i> YouTube</a>
    </div>
  </div>
</footer>

</body>
</html> 