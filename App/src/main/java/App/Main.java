package App;

import App.configs.EmpireBookingSystem;
import App.hall.Hall;
import App.hall.Seat;
import App.movies.Genre;
import App.movies.Movie;
import App.order.EmpireOrder;
import App.order.Ticket;
import App.purchases.KioskFactory;
import App.purchases.PurchaseInterfaceFactory;
import App.tickets.EmpireTicket;
import App.tickets.EmpireTicketFactory;
import App.tickets.VipTicketFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("🌟 Добро пожаловать в сеть кинотеатров 'ИМПЕРИЯ КИНО' 🌟\n");

        Movie starWars = new Movie("Star Wars. Episode IV: A New Hope",
                LocalDate.of(1977, 05, 25),
                "Джордж Лукас", 121, Genre.ADVENTURE);

        Movie avatar = new Movie("Avatar: The Way of Water",
                LocalDate.of(2022, 12, 16),
                "Джеймс Кэмерон", 192, Genre.ACTION);

        Hall hall1 = new Hall("Зал №1", 5, 20);
        Hall hall2 = new Hall("VIP зал", 5,5);

        // 1. Singleton
        System.out.println("--- Шаг 1: Инициализация системы ---");
        EmpireBookingSystem bookingSystem = EmpireBookingSystem.getInstance();

        // 2. Abstract Factory
        System.out.println("\n--- Шаг 2: Подход к терминалу ---");
        PurchaseInterfaceFactory terminal = new KioskFactory();
        terminal.createScreen().display();

        // 3. Factory Method
        System.out.println("\n--- Шаг 3: Выбор билета ---");
        EmpireTicketFactory vipFactory = new VipTicketFactory();
        EmpireTicket myTicket = vipFactory.sellTicket(
                starWars, hall2, new Seat(1,1, false));
        bookingSystem.registerSale(myTicket.getPrice());

        // 4. Prototype
        System.out.println("\n--- Шаг 4: Покупка билета для спутницы (Прототип) ---");
        EmpireTicket mySeat = new Ticket(
                avatar, hall1, new Seat(3,4, false));
        System.out.println("Мое место: " + mySeat);

        // FIXME после deep-клона переделать
        //Ticket dateTicket = mySeat.clone(); // Клонируем
        //dateTicket.setSeatNumber(15);     // Меняем только место
        //System.out.println("Место спутницы: " + dateTicket);
        //bookingSystem.registerSale(myTicket.getPrice());

        // 5. Builder
        System.out.println("\n--- Шаг 5: Дополнительные услуги (Строитель) ---");
        EmpireOrder finalOrder = new EmpireOrder.Builder()
                .setTicket(myTicket)
                .setGlasses3D(false)
                .setPopcornCombo(true).build();

        // Вывод результатов
        finalOrder.printCheck();
        terminal.createPrinter().print();
    }
}
