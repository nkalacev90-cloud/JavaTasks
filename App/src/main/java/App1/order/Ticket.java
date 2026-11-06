package App1.order;

import App1.hall.Hall;
import App1.hall.Seat;
import App1.movies.Movie;
import App1.tickets.EmpireTicket;

public class Ticket implements Cloneable, EmpireTicket {
    private Movie movie;
    private Hall hall;
    private Seat seat;

    public Ticket(Movie movie, Hall hall, Seat seat) {
        this.movie = movie;
        this.hall = hall;
        this.seat = seat;
    }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
    public Hall getHall() { return hall; }
    public void setHall(Hall hall) { this.hall = hall; }
    public Seat getSeat() { return seat; }
    public void setSeat(Seat seat) { this.seat = seat; }

    // FIXME выполнено: настоящий deep clone
    @Override
    public Ticket clone() {
        try {
            Ticket copy = (Ticket) super.clone();
            copy.movie = this.movie.clone();
            copy.hall = this.hall.clone();
            copy.seat = this.seat.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return movie
                + " | Зал: " + hall.getHallName()
                + " | Ряд " + seat.getNumberRow()
                + ", Место " + seat.getNumberSeat();
    }

    @Override
    public double getPrice() { return 0; }

    @Override
    public String getDescription() { return "Базовый билет"; }
}