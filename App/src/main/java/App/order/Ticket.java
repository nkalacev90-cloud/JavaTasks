package App.order;

import App.hall.Hall;
import App.hall.Seat;
import App.movies.Movie;
import App.tickets.EmpireTicket;

public class Ticket implements Cloneable, EmpireTicket {
    private final Movie movie;
    private final Hall hall;
    private Seat seat;

    public Ticket(Movie movie, Hall hall, Seat seat) {
        this.movie = movie;
        this.hall = hall;
        this.seat = seat;
    }
    @Override
    public Ticket clone() {
        try {
            // TODO добавь DeepClone методы для Movie и Hall
            return (Ticket) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return movie
                + " | Зал: " + hall.getHallName()
                + " | Ряд " + seat.getNumberRow()
                + ", Место " + seat.getNumberSeat();
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Базовый билет";
    }
}
