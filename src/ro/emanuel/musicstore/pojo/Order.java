package ro.emanuel.musicstore.pojo;

public class Order {
	
	private int id;
	private int userId;
	private int productId;
	private String orderDate;
	private int quant;
	
	
	public Order(int id, int userId, int productId, String orderDate, int quant) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.orderDate = orderDate;
		this.quant = quant;
	}
	
	public Order(){
		super();
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}

}
