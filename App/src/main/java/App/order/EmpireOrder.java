package App.order;

import App.tickets.EmpireTicket;

public class EmpireOrder {
    private EmpireTicket ticket;
    private boolean popcornCombo; // TODO на будущее можно сделать отдельные сущности еды\напитков
    private boolean glasses3D;

    public EmpireOrder(Builder builder) {
        this.ticket = builder.ticket;
        this.popcornCombo = builder.popcornCombo;
        this.glasses3D = builder.glasses3D;
    }

    public void printCheck() {
        System.out.println("\n=== ЧЕК КИНОТЕАТРА 'ИМПЕРИЯ ГРЁЗ' ===");
        System.out.println("🎟️ " + ticket);
        if (popcornCombo) System.out.println("🍿 Комбо 'Империя' (Попкорн L + 2 Колы)");
        if (glasses3D) System.out.println("👓 3D-очки");
        System.out.println("=====================================");
    }

     public static class Builder {
         private EmpireTicket ticket;
         private boolean popcornCombo; // TODO на будущее можно сделать отдельные сущности еды\напитков
         private boolean glasses3D;

         public Builder setTicket(EmpireTicket ticket) {
             this.ticket = ticket;
             return this;
         }

         public Builder setPopcornCombo(boolean flag) {
             this.popcornCombo = flag;
             return this;
         }

         public Builder setGlasses3D(boolean flag) {
             this.glasses3D = flag;
             return this;
         }

         public EmpireOrder build() {
             return new EmpireOrder(this);
         }
    }
}
