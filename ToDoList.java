import java.util.Arrays;
import java.util.Scanner;

public class ToDoList{
    private static Task[] tasks = new Task[10]; //task capacity of 10 initially
    private static int taskCount = 0;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        while(true){
            showMenu();
            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice){
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    markTaskAsCompleted();
                    break;
                case 5:
                    System.out.println("Goodbye");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void showMenu(){
        System.out.println("\nTo-Do List Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. View Tasks");
        System.out.println("4. Mark Task as Completed");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask(){
        if (taskCount == tasks.length){
            //resizing array if it's full
            tasks = Arrays.copyOf(tasks, tasks.length * 2);
        }
        System.out.print("Enter task description: ");
        String description = scan.nextLine();
        tasks[taskCount++] = new Task(description);
        System.out.println("Task added.");
    }

    private static void deleteTask(){
        System.out.print("Enter task number to delete: ");
        int taskNumber = scan.nextInt();
        if (taskNumber > 0 && taskNumber <= taskCount){
            for(int i = taskNumber - 1; i < taskCount - 1; i++){
                tasks[i] = tasks[i + 1];
            }
            tasks[--taskCount] = null;
            System.out.println("Task deleted.");
        } else{
            System.out.println("Invalid task number.");

        }
    }

    private static void viewTasks(){
        if (taskCount == 0){
            System.out.println("No tasks in your list.");
        } else{
            for(int i = 0; i < taskCount; i++){
                System.out.println((i + 1) + ". " + tasks[i]);
            }
        }
    }

    private static void markTaskAsCompleted(){
        System.out.print("Enter task number to mark as completed: ");
        int taskNumber = scan.nextInt();
        if(taskNumber > 0 && taskNumber <= taskCount){
            tasks[taskNumber - 1].markAsCompleted();
            System.out.println("Task marked as completed.");
        } else{
            System.out.println("Invalid task number.");
        }
    }
}