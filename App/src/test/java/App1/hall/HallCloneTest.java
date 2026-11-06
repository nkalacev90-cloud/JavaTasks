package App1.hall;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HallCloneTest {

    @Test
    void deepCloneDoesNotShareSeats() {
        Hall hall = new Hall("Зал", 2, 2);
        Hall copy = hall.clone();

        copy.getSeats().get(1).get(0).setFree(false);

        assertTrue(hall.getSeats().get(1).get(0).isFree(), "Оригинал не должен меняться");
        assertFalse(copy.getSeats().get(1).get(0).isFree());
    }

    @Test
    void cloneIsNotSameObject() {
        Hall hall = new Hall("Зал", 2, 2);
        Hall copy = hall.clone();

        assertNotSame(hall, copy);
        assertNotSame(hall.getSeats(), copy.getSeats());
        assertNotSame(hall.getSeats().get(1), copy.getSeats().get(1));
        assertNotSame(hall.getSeats().get(1).get(0), copy.getSeats().get(1).get(0));
    }

    @Test
    void markSeatAsSoldWorks() {
        Hall hall = new Hall("Зал", 3, 4);
        hall.markSeatAsSold(2, 3);

        assertFalse(hall.getSeats().get(2).get(2).isFree());
    }

    @Test
    void markSeatAsSoldThrowsOnWrongRow() {
        Hall hall = new Hall("Зал", 2, 2);
        assertThrows(IllegalArgumentException.class, () -> hall.markSeatAsSold(5, 1));
    }

    @Test
    void markSeatAsSoldThrowsOnWrongSeat() {
        Hall hall = new Hall("Зал", 2, 2);
        assertThrows(IllegalArgumentException.class, () -> hall.markSeatAsSold(1, 99));
    }
}