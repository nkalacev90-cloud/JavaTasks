package App1.hall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hall implements Cloneable {
    private String hallName;
    private Map<Integer, List<Seat>> seats;

    public Hall(String hallName, Integer rowsNumber, Integer seatsNumber) {
        this.hallName = hallName;
        seats = new HashMap<>();
        for (int i = 1; i <= rowsNumber; i++) {
            ArrayList<Seat> seatsList = new ArrayList<>(seatsNumber);
            for (int j = 1; j <= seatsNumber; j++) {
                seatsList.add(new Seat(i, j, true));
            }
            seats.put(i, seatsList);
        }
    }

    public Hall(String hallName, Map<Integer, List<Seat>> seats) {
        this.hallName = hallName;
        this.seats = seats;
    }

    public String getHallName() { return hallName; }
    public void setHallName(String hallName) { this.hallName = hallName; }
    public Map<Integer, List<Seat>> getSeats() { return seats; }
    public void setSeats(Map<Integer, List<Seat>> seats) { this.seats = seats; }

    public void markSeatAsSold(int row, int seatNumber) {
        List<Seat> rowSeats = seats.get(row);
        if (rowSeats == null) throw new IllegalArgumentException("Нет ряда " + row);
        for (Seat s : rowSeats) {
            if (s.getNumberSeat() == seatNumber) {
                s.setFree(false);
                return;
            }
        }
        throw new IllegalArgumentException("Нет места " + seatNumber + " в ряду " + row);
    }

    @Override
    public Hall clone() {
        try {
            Hall copy = (Hall) super.clone();
            Map<Integer, List<Seat>> deepSeats = new HashMap<>();
            for (Map.Entry<Integer, List<Seat>> e : this.seats.entrySet()) {
                List<Seat> clonedRow = new ArrayList<>(e.getValue().size());
                for (Seat s : e.getValue()) clonedRow.add(s.clone());
                deepSeats.put(e.getKey(), clonedRow);
            }
            copy.seats = deepSeats;
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Hall{" + hallName + ", rows=" + seats.size() + "}";
    }
}