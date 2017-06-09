package ro.emanuel.musicstore.pojo;

import java.util.Date;

public class Order {

	private int id;
	private int userId;
	private Date orderDate;

	public Order() {
		super();
	}

	public Order(int id, int userId, Date orderDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderDate = orderDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
