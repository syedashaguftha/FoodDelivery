package DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import Dao.OrderItemDao;
import Pojo.OrderItem;

public class OrderItemDaoImp implements OrderItemDao {
    Connection con;

    String INSERT_ORDERITEM = "INSERT INTO `orderitem` (`orderId`, `menuId`, `quantity`, `totalPrice`) VALUES (?, ?, ?, ?)";
    String GET_ORDERITEM = "SELECT * FROM `orderitem` WHERE `orderItemId` = ?";
    String GETALL_ORDERITEMS = "SELECT * FROM `orderitem` WHERE `orderId` = ?";
    String UPDATE_ORDERITEM = "UPDATE `orderitem` SET `orderId` = ?, `menuId` = ?, `quantity` = ?, `totalPrice` = ? WHERE `orderItemId` = ?";
    String DELETE_ORDERITEM = "DELETE FROM `orderitem` WHERE `orderItemId` = ?";

    @Override
    public void addOrderItem(OrderItem orderItem) {
        try {
        	con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(INSERT_ORDERITEM);
            stmt.setInt(1, orderItem.getOrderId());
            stmt.setInt(2, orderItem.getMenuId());
            stmt.setInt(3, orderItem.getQuantity());
            stmt.setDouble(4, orderItem.getTotalPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItem getOrderItemById(int id) {
        OrderItem item = null;

        try {
        	con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(GET_ORDERITEM);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
            	int itemId = res.getInt(1);
                int oid = res.getInt(2);
                
                int menuId = res.getInt(3);
                int quantity = res.getInt(4);
                double totalPrice = res.getDouble(5);

                item = new OrderItem(itemId, oid,  menuId, quantity);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {
        List<OrderItem> list = new ArrayList<OrderItem>();
        OrderItem item = null;
        
        try {
        	con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(GETALL_ORDERITEMS);
            stmt.setInt(1, orderId);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                int itemId = res.getInt(1);
                int oId = res.getInt(2);
                int menuId = res.getInt(3);
                int quantity = res.getInt(4);
                double totalPrice = res.getDouble(5);

                item = new OrderItem(itemId, oId, menuId, quantity);
                list.add(item);
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        try {
        	con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(UPDATE_ORDERITEM);
            stmt.setInt(1, orderItem.getOrderId());
            stmt.setInt(2, orderItem.getMenuId());
            stmt.setInt(3, orderItem.getQuantity());
            stmt.setDouble(4, orderItem.getTotalPrice());
            stmt.setInt(5, orderItem.getOrderItemId());
            stmt.executeUpdate();
            int res=stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(int orderItemId) {
        try {
        	con = DBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_ORDERITEM);
            stmt.setInt(1, orderItemId);
            int res=stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
