package JavaTask.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManager {

    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean removeTask(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }

    public boolean changeStatus(int id, TaskStatus newStatus) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setStatus(newStatus);
                return true;
            }
        }
        return false;
    }

    /**
     * Сортирует все задачи по приоритету (по убыванию).
     * Работает благодаря корректному compareTo в Task/PriorityTask.
     */
    public void sortByPriority() {
        Collections.sort(tasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}