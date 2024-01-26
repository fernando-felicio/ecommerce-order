package entities;

import entities.enums.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import entities.OrderItem;

public class Order {

	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();

	private Order() {

	}

	private Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	List<Order> listToDelivery = new ArrayList<>();

	public void addItem(OrderItem item) {

		items.add(item);

	}
	
	public void removeItem (OrderItem item) {
		
		items.remove(item);
	}
	
	public double total() {
		return items.stream().mapToDouble(OrderItem::subTotal).sum();
	}
}
