package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	private Product product;

	public OrderItem() {

	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public Double subTotal() {
		Double sum = 0.0;
		sum = this.quantity * this.price;
		return sum;
	}

	@Override
	public String toString() {
		return getProduct().getName() + ", : $" + String.format("%.2f",
				price + ", Quantity: " + quantity + ", Subtotal: $" + String.format("%.2f", subTotal()));
	}

}
