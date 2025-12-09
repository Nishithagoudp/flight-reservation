package com.nish.flight;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class FlightServiceTest {

    @Test
    void testSearchFlights() {
        FlightService service = new FlightService();
        service.addFlight(new Flight("A1", "New York", LocalDateTime.of(2025, 1, 10, 10, 0), 20));

        assertEquals(1, service.searchFlights("New York", LocalDateTime.of(2025, 1, 10, 0, 0)).size());
    }

    @Test
    void testBookingSuccess() {
        FlightService service = new FlightService();
        Flight flight = new Flight("A1", "NY", LocalDateTime.now(), 10);
        service.addFlight(flight);

        Reservation r = service.bookFlight("John", flight, 5);
        assertNotNull(r);
        assertEquals(5, r.getSeatsBooked());
        assertEquals(5, flight.getAvailableSeats());
    }

    @Test
    void testBookingFailureNotEnoughSeats() {
        FlightService service = new FlightService();
        Flight flight = new Flight("A1", "NY", LocalDateTime.now(), 3);
        service.addFlight(flight);

        Reservation r = service.bookFlight("John", flight, 5);
        assertNull(r);
    }
}
