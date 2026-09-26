package JavaTask.task2;

public class Task {
    private String name;
    private String description;
    private String creationDate;


    public Task(String name, String description, String creationDate) {
        this.name = name;
        this.description = description;
         this.creationDate = creationDate;
    }

    public Task(String name, String description) {
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }

    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        }

    }

    public void setCreationDate(String creationDate) {
        if (creationDate != null) {
            this.creationDate = creationDate;
        }

    }

    public String getCreationDate() {
        return this.creationDate;

    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}