package App1.hall;

public class Seat implements Cloneable {
    private int numberRow;
    private int numberSeat;
    private boolean free;

    public Seat(int numberRow, int numberSeat, boolean free) {
        this.numberRow = numberRow;
        this.numberSeat = numberSeat;
        this.free = free;
    }

    public int getNumberRow() { return numberRow; }
    public void setNumberRow(int numberRow) { this.numberRow = numberRow; }

    public int getNumberSeat() { return numberSeat; }
    public void setNumberSeat(int numberSeat) { this.numberSeat = numberSeat; }

    public boolean isFree() { return free; }
    public void setFree(boolean free) { this.free = free; }

    @Override
    public Seat clone() {
        try {
            return (Seat) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Seat{" + numberRow + "," + numberSeat + ", free=" + free + "}";
    }
}