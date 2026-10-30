package App.tickets;

import App.hall.Hall;
import App.hall.Seat;
import App.movies.Movie;

public class VipTicketFactory extends EmpireTicketFactory {
    EmpireTicket createTicket(Movie movie, Hall hall, Seat seat) {
        return new VipHallTicket(movie, hall, seat);
    }
}
