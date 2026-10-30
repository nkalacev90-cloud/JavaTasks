package App.tickets;

import App.hall.Hall;
import App.hall.Seat;
import App.movies.Movie;

public class StandardTicketFactory extends EmpireTicketFactory {
    EmpireTicket createTicket(Movie movie, Hall hall, Seat seat) {
        return new StandardHallTicket(movie, hall, seat);
    }
}
