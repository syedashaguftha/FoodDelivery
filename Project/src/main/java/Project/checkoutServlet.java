package Project;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.OrderDao;
import DaoImp.OrderDaoImp;
import DaoImp.OrderItemDaoImp;
import Pojo.Cart;
import Pojo.CartItem;
import Pojo.Order;
import Pojo.OrderItem;
import Pojo.User;


@WebServlet("/checkoutServlet")
public class checkoutServlet extends HttpServlet {
	private OrderDao orderDao;
	private OrderItemDaoImp orderItemDAOImpl = new OrderItemDaoImp();;

	@Override
		public void init() throws ServletException {
		try {
			orderDao = new OrderDaoImp();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("Failed to start Order DAO Impl",e);
		}
			
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Checkout sevlet is called");
		
		
		HttpSession session = request.getSession();
		
		Cart cart=(Cart) session.getAttribute("cart");
		User user=(User) session.getAttribute("user");
		
		if(cart != null && user!=null && !cart.getItems().isEmpty()) {
			
			// Extract from Data
			String paymentMethod = request.getParameter("paymentMethod");
			String address = request.getParameter("address");
			
			//create and populate order object
			Order order= new Order();
			
			order.setUserId(user.getUserId());
			order.setRestaurantId( (int)session.getAttribute("restaurantId"));
			order.setOrderDate(new Timestamp(System.currentTimeMillis()));

//			order.setAddress(address);
			order.setStatus("Confirmed");

			order.setPaymentMode(paymentMethod);
	
			
			//calculate total AMount
			int totalAmount=0;
			for(CartItem item: cart.getItems().values()) {
				totalAmount+=item.getPrice()*item.getQuantity();
			}
			order.setTotalAmount(totalAmount);
			

			int orderId=orderDao.addOrder(order);
			for(CartItem item: cart.getItems().values()) {
				OrderItem oi = new OrderItem();
				int itemId = item.getMenuId();
				String name = item.getName();
				double price = item.getPrice();
				int quantity = item.getQuantity();
				double totalPrice= price*quantity;
				
			
				OrderItem ordersItem = new OrderItem(orderId,itemId, quantity, totalPrice);
				orderItemDAOImpl.addOrderItem(ordersItem);
				
				
			}
			
			
			session.setAttribute("order", order);
			RequestDispatcher rd = request.getRequestDispatcher("OrderConformation.jsp");
			rd.forward(request, response);
			//session.removeAttribute("cart");
		}
		else {
			if(user==null) {
				 response.sendRedirect("login.jsp");
				 return;
			}
			response.sendRedirect("cart.jsp");
		}
		
		
	}

}













