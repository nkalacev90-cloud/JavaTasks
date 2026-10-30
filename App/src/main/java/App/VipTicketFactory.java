package App;

public class VipTicketFactory extends EmpireTicketFactory {
    EmpireTicket createTicket() { return new VipHallTicket(); }
}
