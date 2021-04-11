package application05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities05.ImportedProduct;
import entities05.Product;
import entities05.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int qnt = teclado.nextInt();
		teclado.nextLine();
		
		List<Product> list = new ArrayList<>();
		
		for (int i = 1; i <= qnt; i++) {
			System.out.println("Product #" + i + " data");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = teclado.next().charAt(0);
			teclado.nextLine();
			
			System.out.print("Name: ");
			String name = teclado.nextLine();
			
			System.out.println("Price: ");
			double price = teclado.nextDouble();
			teclado.nextLine();
			
			if(type == 'i') {
				System.out.print("Custom fee: ");
				double cfee = teclado.nextDouble();
				teclado.nextLine();
				
				list.add(new ImportedProduct(name, price, cfee));
			} else if(type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String mdate = teclado.nextLine();

				list.add(new UsedProduct(name, price, sdf.parse(mdate)));
			} else {
				list.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product p : list) {
			System.out.println(p.priceTag());
		}
		
		teclado.close();
	}

}
