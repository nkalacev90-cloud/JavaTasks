package App1.tickets;

import App1.order.Ticket;
import App1.hall.Hall;
import App1.hall.Seat;
import App1.movies.Movie;

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
