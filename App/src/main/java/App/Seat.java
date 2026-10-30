package App;

public class Seat implements Cloneable {
    private final String movie;
    private final String hall;
    private final String row;
    private int seatNumber;

    public Seat(String movie, String hall, String row, int seatNumber) {
        this.movie = movie; this.hall = hall; this.row = row; this.seatNumber = seatNumber;
    }

    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    @Override
    public Seat clone() {
        try { return (Seat) super.clone(); }
        catch (CloneNotSupportedException e) { throw new RuntimeException(e); }
    }

    public String toString() { return "Фильм: " + movie + " | Зал: " + hall + " | Ряд " + row + ", Место " + seatNumber; }
}
