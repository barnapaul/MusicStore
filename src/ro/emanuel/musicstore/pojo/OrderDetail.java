package ro.emanuel.musicstore.pojo;

public class OrderDetail {

	private int id;
	private int orderId;
	private int productId;
	private int quant;
	
	public OrderDetail(int id, int orderId, int productId, int quant) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quant = quant;
	}
	
	public OrderDetail(){
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}


	
}
