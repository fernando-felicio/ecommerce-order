package entities;

public class OrderItem {
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
		
	}
	
	public OrderItem(Integer quantity, Double price) {
		this.quantity = quantity;
		this.price = price;
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double subTotal(Integer quantity, Double price) {
		Double sum = 0.0;
		sum = this.quantity * this.price;
		return sum;
	}

	@Override
	public String toString() {
		return "OrderItem [quantity=" + quantity + ", price=" + price + "]";
	}
	
	
	
	

}
