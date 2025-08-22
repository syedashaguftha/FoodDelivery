package DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import Dao.OrderDao;
import Pojo.Order;

public class OrderDaoImp implements OrderDao{
	Connection con;
	String INSERT_ORDER = "INSERT INTO orders (userId, restaurantId, orderDate, totalAmount, status, paymentMode) VALUES ( ?, ?, ?, ?, ?, ?)";
	String GET_ORDER = "SELECT * FROM `orders` WHERE `orderId` = ?";
	String GETALL_ORDERS = "SELECT * FROM `orders`";
	String UPDATE_ORDER = "UPDATE `orders` SET `userId` = ?, `restaurantId` = ?, `orderDate` = ?, `totalAmount` = ?, `status` = ?, `paymentMode` = ? WHERE `orderId`=?";
	
	String DELETE_ORDER = "DELETE FROM `orders` WHERE `orderId` = ?";
	 int orderId = 0;
	@Override
	public int addOrder(Order order) {
		
       
		try  {
			con = DBConnection.getConnection();
			PreparedStatement stmt=con.prepareStatement(INSERT_ORDER,java.sql.Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, order.getUserId());
            stmt.setInt(2, order.getRestaurantId());
            stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            stmt.setDouble(4, order.getTotalAmount());
            stmt.setString(5, order.getStatus());
            stmt.setString(6, order.getPaymentMode());
            stmt.executeUpdate();

			ResultSet keys=stmt.getGeneratedKeys();
			while(keys.next()) {
				orderId=keys.getInt(1);
			}
			

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderId;
	}

	@Override
	public Order getOrderId(int id) {
		Order order = null;
      
        try  {
        	con = DBConnection.getConnection();
       		PreparedStatement stmt = con.prepareStatement(GET_ORDER);
       		
        
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int uid = res.getInt(1);
                int rid = res.getInt(2);
                Timestamp orderDate = res.getTimestamp(3);
                double totalAmount = res.getDouble(4);
                String status = res.getString(5);
                String paymentMode = res.getString(6);

              
				order = new Order( uid, rid, orderDate, totalAmount, status, paymentMode);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> list = new ArrayList<Order>();
		Order order = null;
        
        try{
        	
        	con = DBConnection.getConnection();
        	PreparedStatement stmt = con.prepareStatement(GETALL_ORDERS);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                int oid = res.getInt(1);
                int uid = res.getInt(2);
                int rid = res.getInt(3);
                Timestamp orderDate = res.getTimestamp(4);
                double totalAmount = res.getDouble(5);
                String status = res.getString(6);
                String paymentMode = res.getString(7);

                order = new Order(uid, rid, orderDate, totalAmount, status, paymentMode);
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
	}


	 @Override
	    public void updateOrder(Order order) {
	      
	        try {
	        	con = DBConnection.getConnection();
	        	PreparedStatement stmt = con.prepareStatement(UPDATE_ORDER); 
	            stmt.setInt(1, order.getUserId());
	            stmt.setInt(2, order.getRestaurantId());
	            stmt.setTimestamp(3, order.getOrderDate());
	            stmt.setDouble(4, order.getTotalAmount());
	            stmt.setString(5, order.getStatus());
	            stmt.setString(6, order.getPaymentMode());
	            stmt.setInt(7, order.getOrderId());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteOrder(int orderId) {
	      	try 
	            {
	      		con = DBConnection.getConnection();
	  	        PreparedStatement stmt = con.prepareStatement(DELETE_ORDER);
	            stmt.setInt(1, orderId);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}