package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


public class Program {
	
	public static void main (String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter sdf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");	
				
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);		
		
		//Entering Customer data - Client Class
		System.out.println("Enter client data:"); 
		
		System.out.print("Name: ");
		String name = scanner.nextLine();
		
		System.out.print("Email: ");
		String email = scanner.next();
		
		System.out.print("Birth Date: ");
		Date birthDate = sdf.parse(scanner.next());
		
		Client client = new Client(name, email, birthDate);
		
		//Entering Order data - Order Class
		
		System.out.println(" ");
		System.out.println("Enter order data:");
		System.out.println(" ");
		
		OrderStatus status = OrderStatus.PROCESSING;
		System.out.println("Status: " + status + "...");
		
		System.out.print("How many items will there be in this order? ");
		int qtdItems = scanner.nextInt();	
				
		LocalDateTime ldt = LocalDateTime.now();
		String dateTimeNow = ldt.format(sdf2);
		
		Order order = new Order(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dateTimeNow), status, client);
		
		//Entering Products data - Product Class
		
		for (int i = 0; i<qtdItems; i++) {
			
			System.out.println("Enter #" + (i +1) + " item data: ");
			
			System.out.print("Enter the product name: ");	
			scanner.nextLine();
			String nameProduct = scanner.nextLine();
									
			System.out.print("Enter the value of the product: ");
			Double valueProduct = scanner.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = scanner.nextInt();
			
			Product product = new Product(nameProduct, valueProduct);
			
			OrderItem item = new OrderItem(quantity, valueProduct, product);
			
			order.addItem(item);
									
		}
		
		System.out.println(" ");	
		System.out.println(order);
		
		scanner.close();
		
		
	}

}
