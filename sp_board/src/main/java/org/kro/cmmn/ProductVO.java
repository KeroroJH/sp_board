package org.kro.cmmn;

public class ProductVO {
	private String name;
	private Double price;
	
	public ProductVO(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public ProductVO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + "]";
	}
	
	

}
