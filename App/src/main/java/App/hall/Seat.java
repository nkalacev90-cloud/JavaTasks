package App.hall;

public class Seat {
    private int numberRow;
    private int numberSeat;
    private boolean free;

    public Seat(int numberRow, int numberSeat, boolean free) {
        this.numberRow = numberRow;
        this.numberSeat = numberSeat;
        this.free = free;
    }

    public int getNumberRow() {
        return numberRow;
    }

    public void setNumberRow(int numberRow) {
        this.numberRow = numberRow;
    }

    public int getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(int numberSeat) {
        this.numberSeat = numberSeat;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
