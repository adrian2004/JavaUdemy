package application01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities01.Department;
import entities01.HourContract;
import entities01.Worker;
import entities_enum01.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = teclado.nextLine();
		System.out.println("Enter worker data");
		System.out.print("Name: ");
		String workerName = teclado.nextLine();
		System.out.print("Level: ");
		String workerLevel = teclado.nextLine();
		System.out.print("Base Salary: ");
		double baseSalary = teclado.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("How many contracts to this worker? ");
		int n = teclado.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(teclado.next());
			System.out.print("Value per hour: ");
			double valuePerHour = teclado.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = teclado.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = teclado.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 1));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		
		
		teclado.close();
	}

}
