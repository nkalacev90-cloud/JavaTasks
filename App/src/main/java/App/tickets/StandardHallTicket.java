package App.tickets;

import App.Ticket;
import App.hall.Hall;
import App.hall.Seat;
import App.movies.Movie;

public class StandardHallTicket extends Ticket implements EmpireTicket {

    public StandardHallTicket(Movie movie, Hall hall, Seat seat) {
        super(movie, hall, seat);
    }

    public double getPrice() {
        return 15.0;
    }

    public String getDescription() {
        return "Билет в зал 'Синий'";
    }


}