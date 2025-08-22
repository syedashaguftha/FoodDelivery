package Project;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MenuDao;
import DaoImp.MenuDaoImp;
import Pojo.Menu;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {

	
	    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	        MenuDao menuDao = new MenuDaoImp();
	        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));

	        List<Menu> menuList = menuDao.getMenuItemsByRestaurantId(restaurantId);

	        request.setAttribute("menuList", menuList);

	        request.setAttribute("restaurantId", restaurantId);
	        
	        
	        RequestDispatcher rd=request.getRequestDispatcher("JspMenu.jsp");
			rd.forward(request, response);
			
	}

}
