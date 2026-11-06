package App1.tickets;

import App1.hall.Hall;
import App1.hall.Seat;
import App1.movies.Movie;

public abstract class EmpireTicketFactory {
    abstract EmpireTicket createTicket(Movie movie, Hall hall, Seat seat);

    // Метод, который использует фабричный метод
    public EmpireTicket sellTicket(Movie movie, Hall hall, Seat seat) {
        EmpireTicket ticket = createTicket( movie, hall,  seat);
        System.out.println("🎫 Выдан билет (тип " + ticket.getDescription() + "): " + ticket + " | Цена: $" + ticket.getPrice());
        return ticket;
    }
}
