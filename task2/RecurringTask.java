package JavaTask.task2;


public class RecurringTask extends Task {
    private String startDate;
    private String interval;

    public RecurringTask(String name, String description, String creationDate, String interval, String startDate) {
        super(name, description, creationDate);
        this.interval = interval;
        this.startDate = startDate;
    }

    public RecurringTask (String interval, String startDate, String name, String description){
        super(name, description);
        this.startDate = startDate;
        this.interval = interval;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public void setName(String name) {
        if (name != null) {
            setName(name);
        }

    }

    public String getName() {
        return super.getName();
    }

    public String getDescription() {
        return super.getDescription();
    }

    public void setDescription(String description) {
        if (description != null) {
            setDescription(description);
        }

    }

    public void setCreationDate(String creationDate) {
        if (creationDate != null) {
            setCreationDate(creationDate);
        }

    }

    public String getCreationDate() {
        return super.getCreationDate();

    }

    @Override
    public String toString() {
        return "RecurringTask{" +
                "startDate='" + startDate + '\'' +
                ", interval='" + interval + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", creationDate='" + getCreationDate() + '\'' +
                '}';
    }
}
