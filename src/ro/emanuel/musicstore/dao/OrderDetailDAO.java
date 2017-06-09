package ro.emanuel.musicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.musicstore.helper.DBHelper;
import ro.emanuel.musicstore.pojo.OrderDetail;

public class OrderDetailDAO {

		public static void createOrderDetail(OrderDetail od) throws SQLException {
			Connection conn = DBHelper.createConnection();

			String insertString = "INSERT INTO orderdetails(orderId, productId,quant) values(?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(insertString);
			stmt.setInt(1, od.getOrderId());
			stmt.setInt(2, od.getProductId());
			stmt.setInt(3, od.getQuant());

			stmt.executeUpdate();

			DBHelper.closeConnection(conn);

		}

		public static ArrayList<OrderDetail> getOrderDetails() throws SQLException {
			ArrayList<OrderDetail> result = new ArrayList<OrderDetail>();
			Connection conn = DBHelper.createConnection();

			String selectString = "select * from orderdetails";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				int id = rs.getInt("id");
				int orderId = rs.getInt("orderId");
				int productId = rs.getInt("productId");
				int quant = rs.getInt("quant");		
				OrderDetail od = new OrderDetail(id, orderId, productId, quant);
				result.add(od	);
			}
			DBHelper.closeConnection(conn);
			return result;
		}
		
		public static OrderDetail getOrderDetailById(int orderdetailId) throws SQLException {
			OrderDetail result = null;
			Connection conn = DBHelper.createConnection();

			String selectString = "select * from orderdetails where id=?";
			PreparedStatement stmt = conn.prepareStatement(selectString);
			stmt.setInt(1, orderdetailId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				int orderId= rs.getInt("orderId");
				int productId = rs.getInt("productId");
				int quant = rs.getInt("quant");
				result = new OrderDetail(id, orderId, productId, quant);
			}
			DBHelper.closeConnection(conn);
			return result;
		}


		public static void updateOrderDetail(OrderDetail od) throws SQLException {
			Connection conn = DBHelper.createConnection();

			String updateString = "UPDATE orderdetails SET orderId=?,  productId=?, quant=? where id=?";

			PreparedStatement stmt = conn.prepareStatement(updateString);
			stmt.setInt(1, od.getOrderId());
			stmt.setInt(2, od.getProductId());
			stmt.setInt(3, od.getQuant());
			stmt.setInt(4, od.getId());

			stmt.executeUpdate();

			DBHelper.closeConnection(conn);
		}

		public static void deleteOrderDetail(OrderDetail od) throws SQLException {
			Connection conn = DBHelper.createConnection();

			String deleteString = "DELETE from orderdetails where id=?";

			PreparedStatement stmt = conn.prepareStatement(deleteString);
			stmt.setInt(1, od.getId());

			stmt.executeUpdate();

			DBHelper.closeConnection(conn);
		}
	}
	


