package application;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		
		System.out.println(" ");
		System.out.print("Did the customer make the payment? (Y/N): ");
		String customerPayment = scanner.next().toLowerCase();
		
		if (customerPayment.charAt(0) == 'y') {
			order.setStatus(OrderStatus.SHIPPED);
			System.out.println("Order Status: " + order.getStatus());
		} else {
			order.setStatus(OrderStatus.PENDING_PAYMENT);
			System.out.println("Order Status: " + order.getStatus());
		}
		
		
		// Output dos dados em uma string
        String outputData = order.toString();

        // Caminho para o desktop
        String desktopPath = System.getProperty("user.home") + "/Desktop/";

        // Criar uma nova pasta "Orders" no desktop
        File ordersDirectory = new File(desktopPath + "Orders");
        if (!ordersDirectory.exists()) {
            ordersDirectory.mkdir();
        }

        // Nome do arquivo
        String fileName = "order_details.txt";

        // Caminho completo do arquivo dentro da pasta "Orders"
        String filePath = ordersDirectory.getAbsolutePath() + "/" + fileName;

        // Salvar os dados em um arquivo de texto
        saveTextToFile(outputData, filePath);

        System.out.println("Dados salvos com sucesso em: " + filePath);

		
		scanner.close();
		
		
	}
	
	 // Método para salvar uma string em um arquivo de texto
    private static void saveTextToFile(String text, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

}
