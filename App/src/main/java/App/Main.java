package App;

public class Main {
    public static void main(String[] args) {
        System.out.println("🌟 Добро пожаловать в сеть кинотеатров 'ИМПЕРИЯ КИНО' 🌟\n");

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
        EmpireTicket myTicket = vipFactory.sellTicket();
        bookingSystem.registerSale(myTicket.getPrice());

        // 4. Prototype
        System.out.println("\n--- Шаг 4: Покупка билета для спутницы (Прототип) ---");
        Seat mySeat = new Seat("Дюна: Часть 2", "VIP-зал", "8", 14);
        System.out.println("Мое место: " + mySeat);

        Seat dateSeat = mySeat.clone(); // Клонируем
        dateSeat.setSeatNumber(15);     // Меняем только место
        System.out.println("Место спутницы: " + dateSeat);
        bookingSystem.registerSale(myTicket.getPrice());

        // 5. Builder
        System.out.println("\n--- Шаг 5: Дополнительные услуги (Строитель) ---");
        EmpireOrder finalOrder = new OrderBuilder()
                .addSeat(dateSeat.toString())
                .addPopcornCombo()
                .addGlasses3D()
                .build();

        // Вывод результатов
        finalOrder.printCheck();
        terminal.createPrinter().print();
    }
}
