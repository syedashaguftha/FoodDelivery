	package Project;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.List;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import DaoImp.RestaurantDaoImp;
	import Pojo.Restaurant;
	
@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {


				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
					
					RestaurantDaoImp restaurant = new RestaurantDaoImp();
					List<Restaurant> restaurants = restaurant.getAllRestaurants();
					
					req.setAttribute("Restaurant", restaurants);
					
				
			        	
					RequestDispatcher rd=req.getRequestDispatcher("JspRestaurant.jsp");
					rd.forward(req, resp);
					
					
					
					
					
					
					
					
					
					
//					PrintWriter out=resp.getWriter();
//					out.println("Restaurant");
//					
				

			

		}



}
