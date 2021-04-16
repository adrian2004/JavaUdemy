package application08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities08.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner teclado = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = teclado.nextInt();
		teclado.nextLine();
		
		System.out.print("Check-in date(dd/mm/yyyy): ");
		Date checkIn = sdf.parse(teclado.next());
		teclado.nextLine();
		
		System.out.print("Check-out date(dd/mm/yyyy): ");
		Date checkOut = sdf.parse(teclado.next());
		teclado.nextLine();
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
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
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Check-out date must be future dates");
			} else if(!checkIn.after(checkOut)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
			
			
		}
		
		teclado.close();
	}

}
