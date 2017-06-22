package ro.emanuel.musicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.musicstore.helper.DBHelper;
import ro.emanuel.musicstore.pojo.User;

public class UserDAO {

	public static void createUser(User u) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String insertString = "INSERT INTO users(fname, lname, email,telefon,address,city) values(?,?,?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(insertString);
		stmt.setString(1, u.getFname());
		stmt.setString(2, u.getLname());
		stmt.setString(3, u.getEmail());
		stmt.setString(4, u.getTelefon());
		stmt.setString(5, u.getAddress());
		stmt.setString(6, u.getCity());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);

	}

	public static void createUser(String fname, String lname, String email, String telefon, String address, String city) throws SQLException {
		User u = new User(-1, fname, lname, email,telefon,address,city);
		UserDAO.createUser(u);
	}

	public static ArrayList<User> getUsers() throws SQLException {
		ArrayList<User> result = new ArrayList<User>();
		Connection conn = DBHelper.createConnection();

		String selectString = "select * from users";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);
		while (rs.next()) {
			int id = rs.getInt("id");
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			String email = rs.getString("email");
			String telefon = rs.getString("telefon");
			String address = rs.getString("address");
			String city = rs.getString("city");
			User u = new User(id, fname, lname, email,telefon,address,city);
			result.add(u);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static User getUserById(int userId) throws SQLException {
		User result = null;
		Connection conn = DBHelper.createConnection();

		String selectString = "select * from users where id=?";
		PreparedStatement stmt = conn.prepareStatement(selectString);
		stmt.setInt(1, userId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("id");
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			String email = rs.getString("email");
			String telefon = rs.getString("telefon");
			String address = rs.getString("address");
			String city = rs.getString("city");
			result = new User(id, fname, lname, email,telefon,address,city);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static void updateUser(User u) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String updateString = "UPDATE users SET fname=?, lname=?, email=?, telefon=?, address=?, city=? where id=?";

		PreparedStatement stmt = conn.prepareStatement(updateString);
		stmt.setString(1, u.getFname());
		stmt.setString(2, u.getLname());
		stmt.setString(3, u.getEmail());
		stmt.setString(4, u.getTelefon());
		stmt.setString(5, u.getAddress());
		stmt.setString(6, u.getCity());
		stmt.setInt(7, u.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	public static void deleteUser(User u) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE from users where id=?";

		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, u.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
}
