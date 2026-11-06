package App1.configs;

import App1.hall.Hall;
import App1.hall.Seat;
import App1.tickets.EmpireTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpireBookingSystemTest {

    private EmpireBookingSystem system;

    @BeforeEach
    void setUp() {
        system = EmpireBookingSystem.getInstance();
        system.reset();
    }

    @Test
    void singletonReturnsSameInstance() {
        assertSame(EmpireBookingSystem.getInstance(), EmpireBookingSystem.getInstance());
    }

    @Test
    void registerSaleWithSeatMarksSeatAsNotFree() {
        Seat seat = new Seat(1, 1, true);
        EmpireTicket ticket = dummyTicket(10.0);

        system.registerSale(ticket, seat);

        assertFalse(seat.isFree(), "Место должно стать занятым после продажи");
        assertEquals(1, system.getTicketsSold());
        assertEquals(10.0, system.getTotalRevenue(), 1e-9);
    }

    @Test
    void registerSaleWithNullSeatDoesNotThrow() {
        EmpireTicket ticket = dummyTicket(15.0);
        assertDoesNotThrow(() -> system.registerSale(ticket, (Seat) null));
        assertEquals(1, system.getTicketsSold());
    }

    @Test
    void registerSaleViaHallMarksSeat() {
        Hall hall = new Hall("H", 2, 2);
        EmpireTicket ticket = dummyTicket(15.0);

        system.registerSale(ticket, hall, 1, 2);

        assertFalse(hall.getSeats().get(1).get(1).isFree());
        assertEquals(1, system.getTicketsSold());
    }

    @Test
    void multipleSalesAccumulateRevenue() {
        EmpireTicket t1 = dummyTicket(10.0);
        EmpireTicket t2 = dummyTicket(20.0);
        system.registerSale(t1, new Seat(1, 1, true));
        system.registerSale(t2, new Seat(1, 2, true));

        assertEquals(2, system.getTicketsSold());
        assertEquals(30.0, system.getTotalRevenue(), 1e-9);
    }

    private EmpireTicket dummyTicket(double price) {
        return new EmpireTicket() {
            public double getPrice() { return price; }
            public String getDescription() { return "test"; }
        };
    }
}