package App1.tickets;

import App1.hall.Hall;
import App1.hall.Seat;
import App1.movies.Movie;

public class VipTicketFactory extends EmpireTicketFactory {
    EmpireTicket createTicket(Movie movie, Hall hall, Seat seat) {
        return new VipHallTicket(movie, hall, seat);
    }
}
