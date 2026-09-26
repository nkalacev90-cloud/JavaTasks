package JavaTask.task2;

public class DeadlineTask extends Task {
    private String deadlineDate;

    public DeadlineTask(String deadlineDate, String name, String description){
        super(name, description);
        this.deadlineDate = deadlineDate;

    }

    public DeadlineTask(String name, String description, String creationDate, String deadlineDate) {
        super(name, description, creationDate);
        this.deadlineDate = deadlineDate;
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
        return "DeadlineTask{" +
                "deadlineDate='" + deadlineDate + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", creationDate='" + getCreationDate() + '\'' +
                '}';
    }
}
