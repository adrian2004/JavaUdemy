package application03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities03.Client;
import entities03.Order;
import entities03.OrderItem;
import entities03.Product;
import entities_enums03.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = teclado.nextLine();
		System.out.print("Email: ");
		String email = teclado.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthDate = teclado.nextLine();
		
		Client client = new Client(name, email, sdf.parse(birthDate));
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = teclado.nextLine();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		System.out.println("How many items to this order? ");
		int quantity = teclado.nextInt();
		teclado.nextLine();
		for(int i = 1; i <= quantity; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String prodName = teclado.nextLine();
			System.out.print("Product price: ");
			double prodPrice = teclado.nextDouble();
			teclado.nextLine();	
			System.out.print("Quantity: ");
			int prodQuantity = teclado.nextInt();
			teclado.nextLine();
			
			Product product = new Product(prodName, prodPrice);
			OrderItem item = new OrderItem(prodQuantity, product.getPrice(), product);
			
			System.out.println();
			order.addItem(item);
		}
		
		System.out.println(order);
		
		teclado.close();
	}

}
