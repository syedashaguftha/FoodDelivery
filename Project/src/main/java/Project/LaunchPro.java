package Project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImp.UserDaoImp;
import Pojo.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LaunchPro")
public class LaunchPro extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("userId"));
		String name=req.getParameter("name");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String phonenumber=req.getParameter("phonenumber");
		String address=req.getParameter("address");
		String role=req.getParameter("role");
		
		User u = new User(userId,name,username, password, email, phonenumber, address, role );
		
		UserDaoImp uimpl = new UserDaoImp();
		uimpl.addUser(u);
		PrintWriter out=resp.getWriter();
		out.println("Successfully Registered");
	}

}














