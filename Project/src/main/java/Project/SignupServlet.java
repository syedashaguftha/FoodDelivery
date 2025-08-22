package Project;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImp.UserDaoImp;
import Pojo.User;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			   // 1. Get form data
			  	String name = request.getParameter("name");
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");
		        String email = request.getParameter("email");
		        String phoneNumber = request.getParameter("phoneNumber");
		        String address = request.getParameter("address");
		        String role = request.getParameter("role"); // Optional field
		        // 2. Create User object 
		        User user=new User();
		        user.setName(name);
		        user.setUsername(username);
		        user.setPassword(password);
		        user.setEmail(email);
		        user.setPhone(phoneNumber);
		        user.setAddress(address);
		        user.setRole(role);
		        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		        user.setLastLoginDate(new Timestamp(System.currentTimeMillis()));
		     // 3. Add user using DAO
		        UserDaoImp impl = new UserDaoImp();
		        
		     
		        impl.addUser(user);
		     // 4. Redirect or show message
		        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		        rd.forward(request, response);
		        
		        System.out.println("New User add Succesfully!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
