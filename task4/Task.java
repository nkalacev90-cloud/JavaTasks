package JavaTask.task4;

import java.io.Serializable;
import java.util.Objects;

public class Task implements Comparable<Task>, Serializable {

    private int id;
    private String title;
    private String description;
    private TaskStatus status;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = TaskStatus.NEW;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public TaskStatus getStatus() { return status; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(TaskStatus status) { this.status = status; }

    /**
     * По умолчанию у обычной Task приоритет LOW.
     * PriorityTask переопределяет этот метод.
     */
    public Priority getPriority() {
        return Priority.LOW;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title +
                ", description='" + description +
                ", status=" + status +
                '}';
    }

    /**
     * Сортировка по приоритету (по убыванию: HIGH -> MEDIUM -> LOW),
     * затем по id (по возрастанию) для стабильности.
     */
    @Override
    public int compareTo(Task o) {
        int byPriority = Integer.compare(
                o.getPriority().getLevel(),
                this.getPriority().getLevel()
        );
        if (byPriority != 0) return byPriority;
        return Integer.compare(this.id, o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}