<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<style type="text/css">

body{
	
  margin: 0;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: url('imagesRest/indian-food-on-restaurant-table.jpg') no-repeat center center/cover;
}
.checkout-title {
  text-align: center;
  color: #dc3545;
  font-size: 28px;
  margin-bottom: 20px;
  font-family: 'Segoe UI', sans-serif;
}

/* Form styling */


.checkout-form {
  max-width: 700px;   /* wider than before (was 500px) */
  margin: 0 auto;
  background: #fff;
  padding: 35px;      /* a little more padding */
  border-radius: 16px;
  box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
  font-family: 'Segoe UI', sans-serif;
}
.checkout-form textarea,
.checkout-form select,
.checkout-form input {
  width: 100%;              /* make all same width */
  padding: 12px;            /* consistent padding */
  border: 1px solid #ccc;
  border-radius: 6px;
  font-size: 15px;
  box-sizing: border-box;   /* ensures padding doesn't mess width */
  margin-bottom: 10px;
}


/* Form elements */
.checkout-form label {
  display: block;
  margin: 12px 0 6px;
  font-weight: 500;
  color: #333;
}

.checkout-form textarea,
.checkout-form select {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 6px;
  font-size: 14px;
  resize: vertical;
}

/* Button styling */
.place-order-btn {
  margin-top: 20px;
  padding: 12px 20px;
  background: linear-gradient(to right, #dc3545);
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
  transition: background 0.3s;
  width: 100%;
}

.place-order-btn:hover {
  background: linear-gradient(to right, #dc3545 );
}

body::before {
  content: "";
  position: absolute;
  inset: 0;
  background: rgba(0, 0, 0, 0.4); /* dark overlay */
  backdrop-filter: blur(3px); /* blur effect */
}
.checkout-form {
  position: relative; /* keep form above overlay */
  z-index: 1;
}


</style>

</head>
<body>
	

<form action="checkoutServlet" method="post" class="checkout-form">
<h2 class="checkout-title">Checkout</h2>
  <label for="address">Delivery Address:</label>
  <textarea id="address" name="address" required></textarea>

  <label for="paymentMethod">Payment Mode:</label>
  <select name="paymentMethod" id="paymentMethod">
    <option value="Credit Card">Credit Card</option>
    <option value="Debit Card">Debit Card</option>
    <option value="Cash">Cash</option>
    <option value="UPI">UPI</option>
  </select>

  <button type="submit" class="place-order-btn">Place Order</button>
</form>
</body>
</html>