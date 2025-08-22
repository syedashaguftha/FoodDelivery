<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Order Success</title>
  <style>
    body, html {
      margin: 0;
      padding: 0;
      height: 100%;
      overflow: hidden;
      font-family: 'Segoe UI', sans-serif;
    }

    .success-container {
      position: relative;
      width: 100vw;
      height: 100vh;
    }

    .success-container video {
      width: 100%;
      height: 100%;
      object-fit: cover;
      display: block;
    }

    /* Wrapper for text + button */
    .message-wrapper {
      position: absolute;
      bottom: 40px;
      left: 50%;
      transform: translateX(-50%);
      text-align: center;
    }

    .message-wrapper h1 {
      color: white;
      font-size: 35px;
      text-shadow: 2px 2px 10px rgba(0, 0, 0, 0.7);
      background-color: green;
      padding: 16px 32px;
      border-radius: 10px;
      margin-bottom: 20px;
    }

    .message-wrapper a {
      display: inline-block;
      text-decoration: none;
      background-color: white;
      color: green;
      padding: 12px 25px;
      border-radius: 8px;
      font-size: 18px;
      font-weight: bold;
      transition: all 0.3s ease;
    }

    .message-wrapper a:hover {
      background-color: green;
      color: white;
    }
  </style>
</head>
<body>
  <div class="success-container">

    <div class="message-wrapper">
     <video src="OrderC/vecteezy_delivery-man-on-a-motorized-scooter_1792782.mp4" autoplay loop muted></video>
      <h1>Your Order Successfully Placed!!!!</h1>
      
      <a href="RestaurantServlet">Return to Home</a>
    </div>
  </div>
</body>
</html>
