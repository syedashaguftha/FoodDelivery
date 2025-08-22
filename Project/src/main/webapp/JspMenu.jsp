<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ page language="java" import="java.util.*, Pojo.Menu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="styleMenu.css">

</head>
<body>
		<h2>Menu</h2>
		<div class="menu-container">
		<%
		    List<Menu> menuList = (List<Menu>)request.getAttribute("menuList");
		    for(Menu m: menuList) {
		%>
		    <div class="menu-card">
		        <img src="<%=m.getImagePath() %>" alt="Food Item">
		        <h3> <%= m.getItemName() %> </h3>
		        <p> <%= m.getDescription() %> </p>
		        <p class="price">Price: ₹<%= m.getPrice() %> </p>
		  
		
				<form action="CartServlet" method="post">
				
					<input type="hidden" name="restaurantId" value="<%= request.getAttribute("restaurantId") %>">

					
					<input type="hidden" name="menuId" value="<%= m.getMenuId() %>">
					<input type="hidden" name="itemName" value="<%= m.getItemName() %>">
					<input type="hidden" name="price" value="<%= m.getPrice() %>">
					
					
					<input type="hidden" name="quantity" value="1" min="1" >
					
					<input type="hidden" name="action" value="add">
					
					<button class="add-to-cart-btn">Add to Cart</button>
				
				</form>
		
		
		      
		    </div>
		<%
		    }
		%>
		
		
		
		
		
		
		
		
		
		</div>
</body>
</html>