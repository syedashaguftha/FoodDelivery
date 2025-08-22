<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
   <%@ page language="java" import="Pojo.Cart" %>
<%@ page language="java" import="Pojo.CartItem" %>
<%@ page language="java" import="java.util.Map" %>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="cart.css">
<style>
body{
      background: url('imagesRest/360_F_154148685_yvijeC6L2SFpvqFJ5H1lunPg40FzCAf1.jpg') no-repeat center center/cover;
}</style>
</head>
<body>


<div class="cart-container">
<h1>Your Cart</h1>
	<% 
	Cart cart = (Cart) session.getAttribute("cart");
	Integer restaurantId = (Integer) session.getAttribute("restaurantId");
	if (cart != null && !cart.getItems().isEmpty()) {
		for (CartItem item: cart.getItems().values()) {
	

	%>
	
	<div class="cart-item">
	
	<div class="cart-item-details">
	
		<h3><%= item.getName() %></h3>
		<p>Price: ₹<%= item.getPrice() %></p>
		
		<p>Total: ₹<%= item.getTotalPrice() %></p>
		
		
		
		<div class="quantity-controls">
		
		<form action="CartServlet" method="post" style="display: inline;">
		
			<input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
		
			<input type="hidden" name="action" value="update">
			<input type="hidden" name="restaurantId" value="<%= restaurantId %>">
			
			
			<input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
			
			<button class="quantity-btn">+</button>
		
		</form>
		
		<p><%= item.getQuantity() %></p>
		
		<form action="CartServlet" method="post" style="display: inline;">
		
			<input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
			    <input type="hidden" name="price" value="<%= item.getPrice() %>">
			<input type="hidden" name="action" value="update">
			<input type="hidden" name="restaurantId" value="<%= restaurantId %>">
			
			<input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
			
			<button class="quantity-btn"  >-</button>
		
		</form>
		</div>
		
</div>
	
	<form action= "CartServlet" method="post">
	
		<input type="hidden" name="menuId" value="<%= item.getMenuId()%>">
		
		<input type="hidden" name="action" value="delete">
		<input type="hidden" name="restaurantId" value="<%= restaurantId %>">
		
		<button class="remove-btn">Remove</button>
	
	</form>
	
	</div>
	<%
	}
	
	%>
	
	 <div class="total">Grand Total: <%= cart.getTotalPrice() %> </div>
	<div class="add-more-items">
	
	<a href="MenuServlet?restaurantId=<%= session.getAttribute("restaurantId") %>" class= "btn add-more-items-btn" > Add More Items</a>
	
	</div>
	<% 
	}else {
	%>
	
		<p style="text-align: center; color: #757575; ">Your cart is empty.</p>
		
		<div class="add-more-items">
		
			<a href="MenuServlet?restaurantId=<%= session.getAttribute("restaurantId") %>">Add Items</a>
		</div>
		<% } %>
		
		<%
				if (session.getAttribute("cart") != null) { 
		%>
		
		
		
		<form action="checkout.jsp" method="post">
		
			<input type="submit" value="Proceed to Checkout" class="btn proceed-to-checkout-btn">
		</form>
		
		<%
		}
		%>
	</div>


</body>

</html>
