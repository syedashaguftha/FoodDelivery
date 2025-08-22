package Dao;

import java.util.List;

import Pojo.Order;

public interface OrderDao {
    int addOrder(Order order);
    Order getOrderId(int orderId);
    List<Order> getAllOrders();
    void updateOrder(Order order);
    void deleteOrder(int orderId);


}
