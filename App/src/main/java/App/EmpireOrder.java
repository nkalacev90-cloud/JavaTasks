package App;

public class EmpireOrder {
    String seatInfo;
    boolean popcornCombo;
    boolean glasses3D;

    public void printCheck() {
        System.out.println("\n=== ЧЕК КИНОТЕАТРА 'ИМПЕРИЯ ГРЁЗ' ===");
        System.out.println("🎟️ " + seatInfo);
        if (popcornCombo) System.out.println("🍿 Комбо 'Империя' (Попкорн L + 2 Колы)");
        if (glasses3D) System.out.println("👓 3D-очки");
        System.out.println("=====================================");
    }
}
