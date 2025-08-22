package Project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImp.MenuDaoImp;
import Pojo.Cart;
import Pojo.CartItem;
import Pojo.Menu;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		
		int newrestaurantId = Integer.parseInt(request.getParameter("restaurantId"));
		
		Integer currentRestaurantId = (Integer)session.getAttribute("restaurantId");

		
		if(cart == null || newrestaurantId != currentRestaurantId) {
			cart=new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("restaurantId", newrestaurantId);
			
		}
		
		
		String action = request.getParameter("action");
		try {
			if(action.equals("add"))
			{
				addItemToCart(request, cart);
			}
			else if(action.equals("update")){
				updateCartItem(request, cart);
			}
			else if(action.equals("delete")){
				deleteCartItem(request, cart);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("cart.jsp");
	
		
}


	private void addItemToCart(HttpServletRequest request, Cart cart) {
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		MenuDaoImp menuDao = new  MenuDaoImp();
		Menu menu = menuDao.getMenuItemById(menuId);
		
		String itemName = request.getParameter("itemName");
		double price = Double.parseDouble(request.getParameter("price"));

		
		if(menu != null){
			CartItem item = new CartItem(menuId, menu.getItemName(), menu.getPrice(), menu.getRestaurantId(), quantity);
			cart.addItem(item);
			
		}
		
	}
	private void updateCartItem(HttpServletRequest request, Cart cart) {

		int menuId = Integer.parseInt(request.getParameter("menuId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		cart.updateItem(menuId, quantity);
		
	}

	private void deleteCartItem(HttpServletRequest request, Cart cart) {
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		cart.deleteItem(menuId);
		
	}
	 
	
	
}
