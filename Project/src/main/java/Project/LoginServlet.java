package Project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImp.UserDaoImp;
import Pojo.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= request.getParameter("username");
		String password= request.getParameter("password");
		UserDaoImp impl = new UserDaoImp();
		User user=impl.checkLogin(userName, password); 
		HttpSession session = request.getSession();
		
	if(user != null) {
			
			System.out.println("Login Succesfull");
		
			session.setAttribute("username", user.getName());
			session.setAttribute("user", user);
			response.sendRedirect("RestaurantServlet");

		
		}
		else {
			System.out.println("Invalid User Name or Password");
			request.setAttribute("error", "Invalid username or password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}



