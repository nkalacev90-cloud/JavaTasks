package App;

public class StandardHallTicket implements EmpireTicket {
    public double getPrice() { return 15.0; }
    public String getDescription() { return "Билет в зал 'Синий'"; }
}