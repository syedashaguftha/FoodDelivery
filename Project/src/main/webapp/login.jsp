<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>FoodHub | Login</title>
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
      background: url('imagesRest/360_F_154148685_yvijeC6L2SFpvqFJ5H1lunPg40FzCAf1.jpg') no-repeat center center/cover;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .login-box {
      background-color: rgba(255, 255, 255, 0.95);
      padding: 40px 30px;
      border-radius: 12px;
      box-shadow: 0 8px 20px rgba(0,0,0,0.2);
      width: 100%;
      max-width: 400px;
    }

    .login-box h2 {
      text-align: center;
      color: #dc3545;
      margin-bottom: 30px;
      font-size: 28px;
    }

    .login-box form {
      display: flex;
      flex-direction: column;
    }

    .login-box input[type="text"],
    .login-box input[type="password"] {
      padding: 12px 15px;
      margin-bottom: 20px;
      border: 1px solid #ccc;
      border-radius: 8px;
      font-size: 16px;
    }

    .login-box button {
      padding: 12px;
      font-size: 16px;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: 0.3s ease;
    }

    .login-btn {
      background-color: #dc3545;
      color: white;
      margin-bottom: 10px;
    }

    .login-btn:hover {
      background-color: #dc3545;
    }

    .signup-btn {
      background-color: white;
      color: #ff6b00;
      border: 2px solid #ff6b00;
    }
	.signup-btn a{
		
		color: #dc3545;
	}
    .signup-btn:hover {
      background-color: #fff3ea;
    }

    .footer-text {
      margin-top: 20px;
      text-align: center;
      font-size: 14px;
      color: #555;
    }

    @media screen and (max-width: 500px) {
      .login-box {
        margin: 20px;
        padding: 30px 20px;
      }
    }
  </style>
</head>
<body>
 
  <div class="login-box">
    <h2>Welcome to FoodHub</h2>
    <% String error=(String) request.getAttribute("error"); %>
    <%
     if(error!=null){ 
    %>
    <p style="color:red;"><%= error %></p>
    <%} %>
    <form action="LoginServlet" method="post">
      <input type="text" name="username" placeholder="Username"  required>
      <input type="password" name="password" placeholder="Password" required>
      <button type="submit" class="login-btn">Login</button>
      <button type="button" class="signup-btn"><a href="Signup.jsp">Sign Up</a></button>
    </form>
    <div class="footer-text">
      Fast. Fresh. Delivered.
    </div>
  </div>

</body>
</html>
    