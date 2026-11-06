package App1.order;

import App1.hall.Hall;
import App1.hall.Seat;
import App1.movies.Genre;
import App1.movies.Movie;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TicketCloneTest {

    private Ticket sample() {
        Movie m = new Movie("Test", LocalDate.of(2020, 1, 1), "A", 100, Genre.ACTION);
        Hall h = new Hall("H", 3, 3);
        Seat seat = h.getSeats().get(1).get(0);
        seat.setFree(false);                       // изначально занято
        return new Ticket(m, h, seat);
    }

    @Test
    void cloneIsDeepForSeat() {
        Ticket original = sample();
        Ticket clone = original.clone();

        clone.getSeat().setNumberSeat(99);

        assertEquals(1, original.getSeat().getNumberSeat(), "Место оригинала не должно меняться");
        assertEquals(99, clone.getSeat().getNumberSeat());
    }

    @Test
    void cloneIsDeepForHall() {
        Ticket original = sample();
        Ticket clone = original.clone();

        clone.getHall().getSeats().get(1).get(0).setFree(true);   // было false → стало true

        assertFalse(original.getHall().getSeats().get(1).get(0).isFree(),
                "Зал оригинала не должен меняться (осталось false)");
        assertTrue(clone.getHall().getSeats().get(1).get(0).isFree(),
                "В клоне место стало свободным");
    }

    @Test
    void cloneIsDeepForMovie() {
        Ticket original = sample();
        Ticket clone = original.clone();

        clone.getMovie().setName("Changed");

        assertEquals("Test", original.getMovie().getName(),
                "Фильм оригинала не должен меняться");
        assertEquals("Changed", clone.getMovie().getName());
    }

    @Test
    void cloneIsNotSameObject() {
        Ticket t = sample();
        Ticket c = t.clone();

        assertNotSame(t, c);
        assertNotSame(t.getSeat(), c.getSeat());
        assertNotSame(t.getHall(), c.getHall());
        assertNotSame(t.getMovie(), c.getMovie());
    }
}