package App1.hall;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatCloneTest {

    @Test
    void cloneCopiesAllFields() {
        Seat s = new Seat(3, 4, true);
        Seat copy = s.clone();

        assertNotSame(s, copy);
        assertEquals(s.getNumberRow(), copy.getNumberRow());
        assertEquals(s.getNumberSeat(), copy.getNumberSeat());
        assertEquals(s.isFree(), copy.isFree());
    }

    @Test
    void cloneIsIndependent() {
        Seat s = new Seat(1, 1, true);
        Seat copy = s.clone();

        copy.setFree(false);
        copy.setNumberSeat(99);

        assertTrue(s.isFree(), "Оригинал не должен меняться");
        assertEquals(1, s.getNumberSeat());
    }
}