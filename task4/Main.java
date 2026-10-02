package JavaTask.task4;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // 1. Создание задач
        manager.addTask(new Task(1, "Написать отчёт", "Квартальный отчёт"));
        manager.addTask(new Task(2, "Позвонить клиенту", "Уточнить детали"));
        manager.addTask(new PriorityTask(3, "Сдать проект", "Дедлайн близко",
                Priority.HIGH));
        manager.addTask(new Task(4, "Прочитать статью", "Java Concurrency"));

        System.out.println("=== Все задачи ===");
        manager.getTasks().forEach(System.out::println);

        // 2. Изменение статуса
        manager.changeStatus(1, TaskStatus.IN_PROGRESS);
        manager.changeStatus(2, TaskStatus.DONE);
        System.out.println("\n=== После изменения статусов ===");
        manager.getTasks().forEach(System.out::println);

        // 3. Сортировка по приоритету (Comparable)
        manager.sortByPriority();
        System.out.println("\n=== После сортировки по приоритету ===");
        manager.getTasks().forEach(System.out::println);

        // 4. Удаление
        manager.removeTask(4);
        System.out.println("\n=== После удаления задачи id=4 ===");
        manager.getTasks().forEach(System.out::println);

        // 5. ImmutableTask
        ImmutableTask it = new ImmutableTask(100, "Оригинал", Priority.LOW);
        ImmutableTask it2 = it.withTitle("Изменённая");
        System.out.println("\n=== ImmutableTask ===");
        System.out.println("Оригинал: " + it);
        System.out.println("Копия:    " + it2);
    }
}