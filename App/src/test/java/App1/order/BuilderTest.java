package App1.order;

import App1.hall.Hall;
import App1.hall.Seat;
import App1.movies.Genre;
import App1.movies.Movie;
import App1.tickets.EmpireTicket;
import App1.tickets.StandardTicketFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    private EmpireTicket ticket() {
        return new StandardTicketFactory().sellTicket(
                new Movie("M", LocalDate.now(), "A", 90, Genre.COMEDY),
                new Hall("H", 1, 1),
                new Seat(1, 1, true));
    }

    @Test
    void builderBuildsOrder() {
        EmpireOrder order = new EmpireOrder.Builder()
                .setTicket(ticket())
                .setPopcornCombo(true)
                .setGlasses3D(false)
                .build();

        assertNotNull(order);
        assertDoesNotThrow(order::printCheck);
    }

    @Test
    void builderWithoutOptions() {
        EmpireOrder order = new EmpireOrder.Builder()
                .setTicket(ticket())
                .build();

        assertNotNull(order);
        assertDoesNotThrow(order::printCheck);
    }
}