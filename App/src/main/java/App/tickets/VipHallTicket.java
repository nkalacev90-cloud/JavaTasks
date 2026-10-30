package App.tickets;

import App.order.Ticket;
import App.hall.Hall;
import App.hall.Seat;
import App.movies.Movie;

public class VipHallTicket extends Ticket implements EmpireTicket {
    public double getPrice() {
        return 35.0;
    }

    public String getDescription() {
        return "VIP-билет (диван-реклайнер)";
    }

    public VipHallTicket(Movie movie, Hall hall, Seat seat) {
        super(movie, hall, seat);
    }
}
