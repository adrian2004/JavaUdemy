package application06;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities06.Circle;
import entities06.Rectangle;
import entities06.Shape;
import entities_enums06.Color;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);

		List<Shape> list = new ArrayList<>();
		
		System.out.print("Enter the number of shapes: ");
		int qnt = teclado.nextInt();
		teclado.nextLine();
		
		for(int i = 1; i <= qnt; i++) {
			System.out.print("Rectangle or Circle (r/c)? ");
			char shape = teclado.next().charAt(0);
			teclado.nextLine();
			
			System.out.print("Color (BLACK/BLUE/RED)? ");
			Color color = Color.valueOf(teclado.next());
			
			if(shape == 'c') {
				System.out.print("Radius: ");
				double radius = teclado.nextDouble();
				
				list.add(new Circle(color, radius));
			} else if(shape == 'r') {
				System.out.print("Width: ");
				double width = teclado.nextDouble();
				System.out.print("Height: ");
				double height = teclado.nextDouble();
				
				list.add(new Rectangle(color, width, height));
			}
		}
		
		System.out.println();
		System.out.println("SHAPE AREAS: ");
		for(Shape shape : list) {
			System.out.println(String.format("%.2f", shape.area()));
		}
		
		teclado.close();
	}
}