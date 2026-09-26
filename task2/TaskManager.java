package JavaTask.task2;
import java.util.ArrayList ;
import java.util.Collections;

public class TaskManager {
    ArrayList<Task> arr = new ArrayList<>();
    static int countTask;

    public void addTask(Task task){
        arr.add(task);
        this.countTask +=1;
    }
    public void delitTask(Task task){

        arr.remove(task);
        this.countTask -=1;
    }
    public void lookTasks(){
        System.out.println(arr);
    }

    public static int getCountTask(){
        return countTask;
    }

    public void sortArrTask(){
        for(int i =0; i < arr.size()-1; i++){
            if (arr.get(i).getName().compareTo(arr.get(i+1).getName()) > 0 ){
                Collections.swap(arr, i, i+1);
;
            }
        }
    }

    @Override
    public String toString() {
        return "TaskManager{ Кол-во задать: " + getCountTask() +
                " arr=" + arr +
                '}';
    }
}
