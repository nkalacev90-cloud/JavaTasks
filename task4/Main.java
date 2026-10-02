package JavaTask.task4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // ===== 1. Создание задач =====
        manager.addTask(new Task(1, "Написать отчёт", "Квартальный отчёт"));
        manager.addTask(new Task(2, "Позвонить клиенту", "Уточнить детали"));
        manager.addTask(new PriorityTask(3, "Сдать проект", "Дедлайн близко",
                Priority.HIGH));
        manager.addTask(new Task(4, "Прочитать статью", "Java Concurrency"));

        System.out.println("=== Все задачи ===");
        manager.getTasks().forEach(System.out::println);

        // ===== 2. Изменение статуса =====
        manager.changeStatus(1, TaskStatus.IN_PROGRESS);
        manager.changeStatus(2, TaskStatus.DONE);
        System.out.println("\n=== После изменения статусов ===");
        manager.getTasks().forEach(System.out::println);

        // ===== 3. Сортировка по приоритету (Comparable) =====
        manager.sortByPriority();
        System.out.println("\n=== После сортировки по приоритету ===");
        manager.getTasks().forEach(System.out::println);

        // ===== 4. Удаление =====
        manager.removeTask(4);
        System.out.println("\n=== После удаления задачи id=4 ===");
        manager.getTasks().forEach(System.out::println);

        // ===== 5. Сохранение в файл =====
        String fileName = "tasks.dat";
        try {
            manager.saveToFile(fileName);
            System.out.println("\n=== Задачи сохранены в файл: " + fileName + " ===");
        } catch (IOException e) {
            System.err.println("Ошибка сохранения: " + e.getMessage());
        }

        // ===== 6. Загрузка из файла с проверкой =====
        TaskManager loaded = new TaskManager();
        try {
            loaded.loadFromFile(fileName);
            System.out.println("=== Загружено из файла: " + fileName + " ===");
            loaded.getTasks().forEach(System.out::println);

            boolean same = loaded.getTasks().equals(manager.getTasks());
            System.out.println("\nДанные совпадают с исходными: " + same);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка загрузки: " + e.getMessage());
        }

        // ===== 7. ImmutableTask =====
        /*
         * ImmutableTask — неизменяемый класс:
         *  - класс объявлен final, чтобы нельзя было унаследоваться и добавить мутаторы;
         *  - все поля private final — их нельзя изменить после конструктора;
         *  - нет сеттеров;
         *  - метод withTitle() не меняет текущий объект, а создаёт НОВЫЙ
         *    с тем же id и priority, но с новым title.
         *
         * ПРОБЛЕМА ИЗМЕНЕНИЯ:
         *  Поля final нельзя переприсвоить. Любое «изменение» — это создание
         *  нового объекта. Это гарантирует, что уже созданный объект никто
         *  не поменяет извне.
         *
         * СЛУЧАИ ПРИМЕНЕНИЯ:
         *  - многопоточность (объект безопасно шарить между потоками);
         *  - ключи в HashMap / элементы HashSet (hashCode не меняется);
         *  - кэширование, value-объекты, DTO;
         *  - откат состояния (храните старые версии — они не изменятся).
         */
        ImmutableTask it = new ImmutableTask(100, "Оригинал", Priority.LOW);
        ImmutableTask it2 = it.withTitle("Изменённая");

        System.out.println("\n=== ImmutableTask ===");
        System.out.println("Оригинал (не изменился): " + it);
        System.out.println("Копия (новый объект):    " + it2);
        System.out.println("it == it2 ? " + (it == it2)); // false — разные объекты
    }
}
