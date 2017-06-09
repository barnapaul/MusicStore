package ro.emanuel.musicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.musicstore.helper.DBHelper;
import ro.emanuel.musicstore.pojo.Product;


public class ProductDAO {
	public static void createProduct(Product m) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String insertString = "INSERT INTO products(name, price, stoc, producator) values(?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(insertString);
		stmt.setString(1, m.getName());
		stmt.setInt(2, m.getPrice());
		stmt.setInt(3, m.getStoc());
		stmt.setString(4, m.getProducator());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);

	}

	public static ArrayList<Product> getProducts() throws SQLException {
		ArrayList<Product> result = new ArrayList<Product>();
		Connection conn = DBHelper.createConnection();

		String selectString = "select * from products";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			int stoc = rs.getInt("stoc");
			String producator = rs.getString("producator");
			Product m = new Product(id, name, price, stoc, producator);
			result.add(m);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static Product getProductById(int userId) throws SQLException {
		Product result = null;
		Connection conn = DBHelper.createConnection();

		String selectString = "select * from products where id=?";
		PreparedStatement stmt = conn.prepareStatement(selectString);
		stmt.setInt(1, userId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			int stoc = rs.getInt("stoc");
			String producator = rs.getString("producator");
			result = new Product(id, name, price, stoc, producator);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	
	public static void updateProduct(Product m) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String updateString = "UPDATE products SET name=?, price=?, stoc=?, producator=? where id=?";

		PreparedStatement stmt = conn.prepareStatement(updateString);
		stmt.setString(1, m.getName());
		stmt.setInt(2, m.getPrice());
		stmt.setInt(3, m.getStoc());
		stmt.setString(4, m.getProducator());
		stmt.setInt(5, m.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	public static void deleteProduct(Product m) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE from products where id=?";

		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, m.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
}
