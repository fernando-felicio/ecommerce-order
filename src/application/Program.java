package application;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.OrderItem;
import entities.enums.*;


public class Program {
	
	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How many items will there be in this order?");
		int qtdItems = scanner.nextInt();
		
		
		List<Product> listToDelivery = new ArrayList<>();
		
		for (int i = 0; i<qtdItems; i++) {
			
			System.out.println("Enter the product name: ");			
			String nameProduct = scanner.nextLine();
			scanner.nextLine();
						
			System.out.println("Enter the value of the product: ");
			Double valueProduct = scanner.nextDouble();
			
			Product product = new Product(nameProduct, valueProduct);
			
			listToDelivery.add(product);
									
		}
		
		for (Product x : listToDelivery) {
			
			OrderItem orderItem = new OrderItem();
			
			System.out.println("How many " + x.getName() + " ");
			int qtdOrderItem = scanner.nextInt();
			
			orderItem.setQuantity(qtdOrderItem);
			
			orderItem.setPrice(x.getPrice());
			
			orderItem.subTotal(orderItem.getQuantity(), orderItem.getPrice());
			
			System.out.println(orderItem);
			
		}
		
		
		
		scanner.close();
		
		
	}

}
