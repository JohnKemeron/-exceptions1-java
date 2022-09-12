package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), fmt);
		
		if(!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation r = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(r.toString());				
		
			System.out.println("\nEnter data to update the reservation:");
		
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkInUpdate = LocalDate.parse(sc.next(), fmt);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOutUpdate = LocalDate.parse(sc.next(), fmt);
			
			LocalDate now = LocalDate.now();
			if (checkIn.isBefore(now) || checkOut.isBefore(now)) {			
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(!checkOutUpdate.isAfter(checkInUpdate)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				r.updateDates(checkInUpdate, checkOutUpdate);
				System.out.println(r.toString());
			}			
		}
		
		sc.close();

	}

}
