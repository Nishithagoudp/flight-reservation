package com.nish.flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightService {

    private List<Flight> flights = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getAllFlights() {
        return flights;
    }

    public List<Flight> searchFlights(String destination, LocalDateTime date) {
        List<Flight> results = new ArrayList<>();

        for (Flight f : flights) {
            boolean sameDay = f.getDepartureTime().toLocalDate().equals(date.toLocalDate());
            if (f.getDestination().equalsIgnoreCase(destination) && sameDay) {
                results.add(f);
            }
        }
        return results;
    }

    public Reservation bookFlight(String customerName, Flight flight, int seats) {
        if (flight.getAvailableSeats() < seats) {
            return null; // not enough seats, booking fails
        }
        flight.reduceSeats(seats);
        Reservation reservation = new Reservation(customerName, flight, seats);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getReservationsByCustomer(String customerName) {
        List<Reservation> list = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getCustomerName().equalsIgnoreCase(customerName)) {
                list.add(r);
            }
        }
        return list;
    }
}
