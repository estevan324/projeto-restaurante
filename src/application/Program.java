package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter client data");
		System.out.print("- Name: ");
		String clientName = sc.nextLine();
		System.out.print("- Email: ");
		String clientEmail = sc.next();
		System.out.print("- Birth date: ");
		LocalDate birthDate = LocalDate.parse(sc.next(), formatter);

		Client client = new Client(clientName, clientEmail, birthDate);

		System.out.println("\nEnter order data");
		System.out.print("- Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.next());

		Order order = new Order(LocalDateTime.now(), orderStatus, client);
		
		System.out.print("\nHow many items to this order? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("\nEnter #" + i + " item data");
			sc.nextLine();
			System.out.print("- Product name: ");
			String productName = sc.nextLine();
			System.out.print("- Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("- Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			order.addItem(orderItem);	
		}
		System.out.println(order);
		sc.close();
	}

}
