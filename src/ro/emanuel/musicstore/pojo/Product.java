package ro.emanuel.musicstore.pojo;


public class Product {

	private int id;
	private String name;
	private int price;
	private int stoc;
	private String producator;

	public Product(int id, String name, int price, int stoc, String producator) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stoc = stoc;
		this.producator = producator;
	}

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStoc() {
		return stoc;
	}

	public void setStoc(int stoc) {
		this.stoc = stoc;
	}

	public String getProducator() {
		return producator;
	}

	public void setProducator(String producator) {
		this.producator = producator;
	}

}
