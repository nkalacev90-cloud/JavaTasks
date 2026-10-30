package App;

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
        System.out.println("💾 [Система 'Империя Грёз'] Билет продан. Всего продано: " + ticketsSold + ", Выручка: $" + totalRevenue);
    }
}
