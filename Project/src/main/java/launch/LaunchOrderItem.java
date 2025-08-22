package launch;

import java.util.List;
import java.util.Scanner;

import DaoImp.OrderItemDaoImp;
import Pojo.OrderItem;

public class LaunchOrderItem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        OrderItemDaoImp oiImpl = new OrderItemDaoImp();

        // Get order item by ID
        System.out.println("Enter orderItem ID:");
        int id = sc.nextInt();
        OrderItem item = oiImpl.getOrderItemById(id);
        System.out.println(item);

        // Add order item
//        System.out.println("Enter order ID:");
//        int orderId = sc.nextInt();
//        System.out.println("Enter menu ID:");
//        int menuId = sc.nextInt();
//        System.out.println("Enter quantity:");
//        int quantity = sc.nextInt();
//        System.out.println("Enter total price:");
//        double totalPrice = sc.nextDouble();
//        OrderItem newItem = new OrderItem(0, orderId, menuId, quantity, totalPrice);
//        oiImpl.addOrderItem(newItem);

        // Update order item
//        System.out.println("Enter orderItem ID to update:");
//        int itemId = sc.nextInt();
//        OrderItem item = oiImpl.getOrderItemById(itemId);
//        item.setQuantity(3);
//        item.setTotalPrice(599.00);
//        oiImpl.updateOrderItem(item);

        // Delete order item
//        System.out.println("Enter orderItem ID to delete:");
//        int deleteId = sc.nextInt();
//        oiImpl.deleteOrderItem(deleteId);

        // Get all order items for a specific order ID
//        System.out.println("Enter order ID to list items:");
//        int orderId = sc.nextInt();
//        List<OrderItem> list = oiImpl.getOrderItemsByOrderId(orderId);
//
//        for (OrderItem oi : list) {
//            System.out.println(oi);
//        }

        sc.close();
    }
}
