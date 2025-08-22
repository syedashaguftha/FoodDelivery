package Dao;

import java.util.List;

import Pojo.OrderItem;

public interface OrderItemDao {
	 void addOrderItem(OrderItem orderItem);
	    OrderItem getOrderItemById(int orderItemId);
	    List<OrderItem> getOrderItemsByOrderId(int orderId);
	    void updateOrderItem(OrderItem orderItem);
	    void deleteOrderItem(int orderItemId);


}
