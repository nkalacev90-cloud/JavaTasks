package JavaTask.task5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meeting {
    private String title;
    private String description;
    private int usersLimit;
    private LocalDate startDate;
    private LocalTime startTimeFrom;
    private LocalTime startTimeTo;
    private LocalDateTime registrationAvailableUntil;

    public Meeting(String title,
                   String description,
                   int usersLimit,
                   LocalDate startDate,
                   LocalTime startTimeFrom,
                   LocalTime startTimeTo,
                   LocalDateTime registrationAvailableUntil) {
        this.title = title;
        this.description = description;
        this.usersLimit = usersLimit;
        this.startDate = startDate;
        this.startTimeFrom = startTimeFrom;
        this.startTimeTo = startTimeTo;
        this.registrationAvailableUntil = registrationAvailableUntil;
    }

    public Meeting() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUsersLimit() {
        return usersLimit;
    }

    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTimeFrom() {
        return startTimeFrom;
    }

    public void setStartTimeFrom(LocalTime startTimeFrom) {
        this.startTimeFrom = startTimeFrom;
    }

    public LocalTime getStartTimeTo() {
        return startTimeTo;
    }

    public void setStartTimeTo(LocalTime startTimeTo) {
        this.startTimeTo = startTimeTo;
    }

    public LocalDateTime getRegistrationAvailableUntil() {
        return registrationAvailableUntil;
    }

    public void setRegistrationAvailableUntil(LocalDateTime registrationAvailableUntil) {
        this.registrationAvailableUntil = registrationAvailableUntil;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", usersLimit=" + usersLimit +
                ", startDate=" + startDate +
                ", startTimeFrom=" + startTimeFrom +
                ", startTimeTo=" + startTimeTo +
                ", registrationAvailableUntil=" + registrationAvailableUntil +
                '}';
    }
}
