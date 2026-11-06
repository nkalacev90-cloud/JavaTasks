package App1.tickets;

import App1.hall.Hall;
import App1.hall.Seat;
import App1.movies.Genre;
import App1.movies.Movie;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TicketFactoryTest {

    private Movie movie() {
        return new Movie("M", LocalDate.now(), "A", 90, Genre.DRAMA);
    }

    @Test
    void vipTicketHasVipPriceAndDescription() {
        EmpireTicket t = new VipTicketFactory()
                .sellTicket(movie(), new Hall("VIP", 1, 1), new Seat(1, 1, true));

        assertEquals(35.0, t.getPrice());
        assertTrue(t.getDescription().contains("VIP"));
    }

    @Test
    void standardTicketHasStandardPrice() {
        EmpireTicket t = new StandardTicketFactory()
                .sellTicket(movie(), new Hall("S", 1, 1), new Seat(1, 1, true));

        assertEquals(15.0, t.getPrice());
        assertTrue(t.getDescription().contains("Синий"));
    }

    @Test
    void factoryProducesCorrectSubtype() {
        assertInstanceOf(VipHallTicket.class,
                new VipTicketFactory().sellTicket(movie(), new Hall("V", 1, 1), new Seat(1, 1, true)));
        assertInstanceOf(StandardHallTicket.class,
                new StandardTicketFactory().sellTicket(movie(), new Hall("S", 1, 1), new Seat(1, 1, true)));
    }
}