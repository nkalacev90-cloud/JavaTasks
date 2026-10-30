package App.hall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hall {
    private String hallName;
    private Map<Integer, List<Seat>> seats;

    public Hall(String hallName, Integer rowsNumber, Integer seatsNumber) {
        this.hallName = hallName;
        seats = new HashMap<>();

        for (int i = 1; i <= rowsNumber; i++) {

            ArrayList<Seat> seatsList = new ArrayList<>(seatsNumber);
            for (int j=1; j <= seatsNumber; j++) {
                seatsList.add(new Seat(i, j, true));
            }

            seats.put(i, seatsList);
        }
    }

    public Hall(String hallName, Map<Integer, List<Seat>> seats) {
        this.hallName = hallName;
        this.seats = seats;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Map<Integer, List<Seat>> getSeats() {
        return seats;
    }

    public void setSeats(Map<Integer, List<Seat>> seats) {
        this.seats = seats;
    }
}
