package App1.tickets;

import App1.order.Ticket;
import App1.hall.Hall;
import App1.hall.Seat;
import App1.movies.Movie;

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