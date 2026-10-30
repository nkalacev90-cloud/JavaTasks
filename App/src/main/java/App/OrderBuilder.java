package App;

public class OrderBuilder {
    private final EmpireOrder order = new EmpireOrder();
    public OrderBuilder addSeat(String seatInfo) { order.seatInfo = seatInfo; return this; }
    public OrderBuilder addPopcornCombo() { order.popcornCombo = true; return this; }
    public OrderBuilder addGlasses3D() { order.glasses3D = true; return this; }
    public EmpireOrder build() { return order; }
}
