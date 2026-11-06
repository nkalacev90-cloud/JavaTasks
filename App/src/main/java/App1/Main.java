package App1;

import App1.configs.EmpireBookingSystem;
import App1.hall.Hall;
import App1.hall.Seat;
import App1.movies.Genre;
import App1.movies.Movie;
import App1.order.EmpireOrder;
import App1.order.Ticket;
import App1.purchases.KioskFactory;
import App1.purchases.PurchaseInterfaceFactory;
import App1.tickets.EmpireTicket;
import App1.tickets.EmpireTicketFactory;
import App1.tickets.StandardTicketFactory;
import App1.tickets.VipTicketFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("🌟 Добро пожаловать в сеть кинотеатров 'ИМПЕРИЯ КИНО' 🌟\n");

        Movie starWars = new Movie("Star Wars. Episode IV: A New Hope",
                LocalDate.of(1977, 5, 25), "Джордж Лукас", 121, Genre.ADVENTURE);
        Movie avatar = new Movie("Avatar: The Way of Water",
                LocalDate.of(2022, 12, 16), "Джеймс Кэмерон", 192, Genre.ACTION);

        Hall hall1 = new Hall("Зал №1", 5, 20);
        Hall hall2 = new Hall("VIP зал", 5, 5);

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
        Seat vipSeat = new Seat(1, 1, true);
        EmpireTicket myTicket = vipFactory.sellTicket(starWars, hall2, vipSeat);
        bookingSystem.registerSale(myTicket, vipSeat); // место помечается занятым

        // 4. Prototype — FIXME выполнен
        System.out.println("\n--- Шаг 4: Покупка билета для спутницы (Прототип) ---");
        EmpireTicketFactory standardFactory = new StandardTicketFactory();
        Seat mySeatPlace = new Seat(3, 4, true);
        EmpireTicket mySeat = standardFactory.sellTicket(avatar, hall1, mySeatPlace);
        System.out.println("Мое место: " + mySeat);

        Ticket originalTicket = (Ticket) mySeat;
        Ticket dateTicket = originalTicket.clone();
        dateTicket.getSeat().setNumberSeat(15);
        System.out.println("Место спутницы: " + dateTicket);
        System.out.println("Оригинал (не изменился): " + originalTicket);

        bookingSystem.registerSale(dateTicket, dateTicket.getSeat());

        // 5. Builder
        System.out.println("\n--- Шаг 5: Дополнительные услуги (Строитель) ---");
        EmpireOrder finalOrder = new EmpireOrder.Builder()
                .setTicket(myTicket)
                .setGlasses3D(false)
                .setPopcornCombo(true)
                .build();

        finalOrder.printCheck();
        terminal.createPrinter().print();
    }
}