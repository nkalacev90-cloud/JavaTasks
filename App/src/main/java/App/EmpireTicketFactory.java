package App;

public abstract class EmpireTicketFactory {
    abstract EmpireTicket createTicket();

    // Метод, который использует фабричный метод
    public EmpireTicket sellTicket() {
        EmpireTicket ticket = createTicket();
        System.out.println("🎫 Выдан билет: " + ticket.getDescription() + " | Цена: $" + ticket.getPrice());
        return ticket;
    }
}
