package launch;

import java.util.List;
import java.util.Scanner;

import DaoImp.OrderDaoImp;
import Pojo.Order;

public class LaunchOrder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		OrderDaoImp oimpl = new OrderDaoImp();

		// Get order by ID
		System.out.println("Enter order ID:");
		int id = sc.nextInt();
		Order o = oimpl.getOrderId(id);
		System.out.println(o);

		// Add order
//		System.out.println("Enter user ID:");
//		int userId = sc.nextInt();
//		System.out.println("Enter restaurant ID:");
//		int restaurantId = sc.nextInt();
//		sc.nextLine(); // consume newline
//		System.out.println("Enter order date (YYYY-MM-DD):");
//		String orderDate = sc.nextLine();
//		System.out.println("Enter total amount:");
//		double totalAmount = sc.nextDouble();
//		sc.nextLine();
//		System.out.println("Enter status:");
//		String status = sc.nextLine();
//		System.out.println("Enter payment mode:");
//		String paymentMode = sc.nextLine();
//		
//		Order o = new Order(0, userId, restaurantId, orderDate, totalAmount, status, paymentMode);
//		oimpl.addOrder(o);

		// Update order
//		Order o = oimpl.getOrderId(id);
//		o.setStatus("Delivered");
//		oimpl.updateOrder(o);

		// Delete order
//		System.out.println("Enter order ID to delete:");
//		int deleteId = sc.nextInt();
//		oimpl.deleteOrder(deleteId);

		// Get all orders
//		List<Order> list = oimpl.getAllOrders();
//		for (Order o : list) {
//			System.out.println(o);
//		}

		sc.close();
	}
}
