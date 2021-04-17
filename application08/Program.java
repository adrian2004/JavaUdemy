package application08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities08.Reservation;
import model.exceptions08.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = teclado.nextInt();
			teclado.nextLine();
			
			System.out.print("Check-in date(dd/mm/yyyy): ");
			Date checkIn = sdf.parse(teclado.next());
			teclado.nextLine();
			
			System.out.print("Check-out date(dd/mm/yyyy): ");
			Date checkOut = sdf.parse(teclado.next());
			teclado.nextLine();
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-in date(dd/mm/yyyy): ");
			checkIn = sdf.parse(teclado.next());
			teclado.nextLine();
			
			System.out.print("Check-out date(dd/mm/yyyy): ");
			checkOut = sdf.parse(teclado.next());
			teclado.nextLine();
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		} catch(ParseException e) {
			System.out.println("Invalid date format");
		} catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		teclado.close();
	}
}