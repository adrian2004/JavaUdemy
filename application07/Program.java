package application07;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities07.LegalPerson;
import entities07.PhysicalPerson;
import entities07.Taxpayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		
		List<Taxpayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int qnt = teclado.nextInt();
		teclado.nextLine();

		for(int i = 1; i <= qnt; i++) {
			System.out.println("Tax payer #" + i + " data:");
			
			System.out.print("Individual or Company (i/c): ");
			char type = teclado.next().charAt(0);
			teclado.nextLine();
			
			System.out.print("Name: ");
			String name = teclado.nextLine();
			
			System.out.print("Annual Income: ");
			Double annualIncome = teclado.nextDouble();
			teclado.nextLine();
			
			if(type == 'i') {
				System.out.print("Healt expenditures: ");
				double healtSpending = teclado.nextDouble();
				
				list.add(new PhysicalPerson(name, annualIncome, healtSpending));
			} else if(type == 'c') {
				System.out.print("Number of employees: ");
				int employeeQuantity = teclado.nextInt();
				teclado.nextLine();
				
				list.add(new LegalPerson(name, annualIncome, employeeQuantity));
			}
		}
		
		Double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for(Taxpayer taxpayer : list) {
			System.out.println(taxpayer.toString());
			sum += taxpayer.collectedTax();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: " + String.format("%.2f", sum));
		
		teclado.close();
	}
}