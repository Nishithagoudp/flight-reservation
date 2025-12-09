package com.nish.flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FlightService service = new FlightService();

        // Sample flights
        service.addFlight(new Flight("AA101", "Dallas", LocalDateTime.of(2025, 12, 20, 10, 0), 50));
        service.addFlight(new Flight("AA202", "Dallas", LocalDateTime.of(2025, 12, 20, 14, 30), 30));
        service.addFlight(new Flight("UA505", "Chicago", LocalDateTime.of(2025, 12, 20, 9, 45), 40));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Flight Reservation System ---");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Destination: ");
                    String dest = sc.nextLine();

                    System.out.print("Date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());

                    List<Flight> flights = service.searchFlights(dest, LocalDateTime.of(date, LocalTime.MIN));

                    if (flights.isEmpty()) {
                        System.out.println("No flights found.");
                    } else {
                        flights.forEach(System.out::println);
                    }
                    break;

                case 2:
                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Flight Number: ");
                    String flightNum = sc.nextLine();

                    Flight chosen = null;
                    for (Flight f : service.getAllFlights()) {
                        if (f.getFlightNumber().equalsIgnoreCase(flightNum)) {
                            chosen = f;
                        }
                    }

                    if (chosen == null) {
                        System.out.println("Flight not found.");
                        break;
                    }

                    System.out.print("Seats to book: ");
                    int seats = sc.nextInt();

                    Reservation res = service.bookFlight(name, chosen, seats);
                    if (res == null) {
                        System.out.println("Booking failed - not enough seats.");
                    } else {
                        System.out.println("Booking confirmed: " + res);
                    }
                    break;

                case 3:
                    System.out.print("Customer Name: ");
                    String cust = sc.nextLine();
                    List<Reservation> reservations = service.getReservationsByCustomer(cust);

                    if (reservations.isEmpty()) {
                        System.out.println("No reservations found.");
                    } else {
                        reservations.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}
