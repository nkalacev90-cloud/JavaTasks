package App;

public class StandardTicketFactory extends EmpireTicketFactory {
    EmpireTicket createTicket() { return new StandardHallTicket(); }
}
