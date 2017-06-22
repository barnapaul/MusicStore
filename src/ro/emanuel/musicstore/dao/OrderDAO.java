package ro.emanuel.musicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.musicstore.helper.DBHelper;
import ro.emanuel.musicstore.pojo.Order;

public class OrderDAO {

	public static void createOrder(Order o) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String insertString = "INSERT INTO orders(userId, productId, orderDate, quant) values(?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(insertString);
		stmt.setInt(1, o.getUserId());
		stmt.setInt(2, o.getProductId());
		stmt.setString(3, o.getOrderDate());
		stmt.setInt(4, o.getQuant());
		

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);

	}

	public static void createOrder(int userId, int productId, String orderDate, int quant) throws SQLException {
		Order o = new Order(-1, userId, productId, orderDate, quant);
		OrderDAO.createOrder(o);
	}

	public static ArrayList<Order> getOrders() throws SQLException {
		ArrayList<Order> result = new ArrayList<Order>();
		Connection conn = DBHelper.createConnection();

		String selectString = "select * from orders";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);
		while (rs.next()) {
			int id = rs.getInt("id");
			int userId = rs.getInt("userId");
			int productId = rs.getInt("productId");
			String orderDate = rs.getString("orderDate");
			int quant = rs.getInt("quant");
			Order o = new Order(id, userId, productId, orderDate, quant);
			result.add(o);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static Order getOrderById(int orderId) throws SQLException {
		Order result = null;
		Connection conn = DBHelper.createConnection();

		String selectString = "select * from orders where id=?";
		PreparedStatement stmt = conn.prepareStatement(selectString);
		stmt.setInt(1, orderId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("id");
			int userId = rs.getInt("userId");
			int productId = rs.getInt("productId");
			String orderDate = rs.getString("orderDate");
			int quant = rs.getInt("quant");
			result = new Order(id, userId, productId, orderDate, quant);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static void updateOrder(Order o) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String updateString = "UPDATE orders SET userId=?, productId=?, orderDate=?, quant=? where id=?";

		PreparedStatement stmt = conn.prepareStatement(updateString);
		stmt.setInt(1, o.getUserId());
		stmt.setInt(2, o.getProductId());
		stmt.setString(3, o.getOrderDate());
		stmt.setInt(4, o.getQuant());
		stmt.setInt(5, o.getId());
		
		stmt.executeUpdate();

		
		DBHelper.closeConnection(conn);
	}

	public static void deleteOrder(Order o) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE from orders where id=?";

		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, o.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
}
