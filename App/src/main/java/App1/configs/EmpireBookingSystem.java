package App1.configs;

import App1.hall.Hall;
import App1.hall.Seat;
import App1.tickets.EmpireTicket;

public class EmpireBookingSystem {
    private static EmpireBookingSystem instance;
    private int ticketsSold = 0;
    private double totalRevenue = 0.0;

    private EmpireBookingSystem() {}

    public static synchronized EmpireBookingSystem getInstance() {
        if (instance == null) instance = new EmpireBookingSystem();
        return instance;
    }

    public void registerSale(double price) {
        ticketsSold++;
        totalRevenue += price;
        printStats();
    }

    // TODO выполнено: помечаем конкретное место занятым
    public void registerSale(EmpireTicket ticket, Seat seat) {
        if (seat != null) seat.setFree(false);
        registerSale(ticket.getPrice());
    }

    // TODO выполнено: помечаем место через Hall
    public void registerSale(EmpireTicket ticket, Hall hall, int row, int seatNumber) {
        hall.markSeatAsSold(row, seatNumber);
        registerSale(ticket.getPrice());
    }

    private void printStats() {
        System.out.println("💾 [Система 'Империя Грёз'] Билет продан. Всего продано: "
                + ticketsSold + ", Выручка: $" + totalRevenue);
    }

    // Для тестов
    int getTicketsSold() { return ticketsSold; }
    double getTotalRevenue() { return totalRevenue; }
    void reset() { ticketsSold = 0; totalRevenue = 0.0; }
}