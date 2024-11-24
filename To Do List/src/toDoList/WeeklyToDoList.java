package toDoList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class WeeklyToDoList {
    private HashMap<String, ArrayList<Task>> weeklyTasks;
    public class TaskTimeComparator implements Comparator<Task>
    {
 	   @Override 
 	   public int compare(Task t1, Task t2) {
 		   return t1.getTime().compareTo(t2.getTime());
 	   }
    }
 	public void sortTasksForDay(String day) {
 		if (weeklyTasks.containsKey(day)) {
 			ArrayList<Task> tasks = weeklyTasks.get(day);
 			Collections.sort(tasks,new TaskTimeComparator());
 			System.out.println("Tasks for " + day + "sorted by time");		
 		}
 		else {
 			System.out.println("Invaild day enter ");
 		}	
 	}
   public HashMap<String,ArrayList<Task>> getWeeklyTasks(){
	   return weeklyTasks;
   }
   

    public WeeklyToDoList() {
        weeklyTasks = new HashMap<>();
        String[] daysOfWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day : daysOfWeek) {
            weeklyTasks.put(day, new ArrayList<>());
        }
    }

    public void addTask(String day, String schedule, String time) {
        Task task = new Task(schedule, time);
        if (weeklyTasks.containsKey(day)) {
            weeklyTasks.get(day).add(task);
            System.out.println("Added task to " + day + ": " + task);
        } else {
            System.out.println("Invalid day entered.");
        }
    }

    
    public void removeTask(String day, int index) {
        if (weeklyTasks.containsKey(day)) {
            ArrayList<Task> tasks = weeklyTasks.get(day);
            if (index >= 0 && index < tasks.size()) {
                Task removedTask = tasks.remove(index);
                System.out.println("Removed task: " + removedTask);
            } else {
                System.out.println("Invalid index for " + day);
            }
        } else {
            System.out.println("Invalid day entered.");
        }
    }
    
    

    public void showTasksForDay(String day) {
        if (weeklyTasks.containsKey(day)) {
            ArrayList<Task> tasks = weeklyTasks.get(day);
            if (tasks.isEmpty()) {
                System.out.println(day + " has no tasks.");
            } else {
            	sortTasksForDay(day);
                System.out.println("Tasks for " + day + ":");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i + ". " + tasks.get(i));
                }
            }
        } else {
            System.out.println("Invalid day entered.");
        }
    }

    public void showAllTasks() {
        for (String day : weeklyTasks.keySet()) {
            showTasksForDay(day);
        }
    }

    public static void main(String[] args) {
        WeeklyToDoList toDoList = new WeeklyToDoList();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Options:(Type in number 1 to 5 to pick your action) \n 1-Add schedule,\n 2-Remove schedule,\n 3-Show schedule for a Day,\n 4-Show All schedule,\n 5-Exit");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (option) {
                case 1:
                    System.out.print("Enter day of the week: ");
                    String day = scanner.nextLine();
                    System.out.print("Enter schedule for: ");
                    String schedule = scanner.nextLine();
                    System.out.print("Enter time (e.g., 10:00 AM): ");
                    String time = scanner.nextLine();
                    toDoList.addTask(day, schedule, time);
                    break;
                case 2:
                    System.out.print("Enter day of the week: ");
                    day = scanner.nextLine();
                    toDoList.showTasksForDay(day);
                    System.out.print("Enter task index to remove: ");
                    int index = scanner.nextInt();
                    toDoList.removeTask(day, index);
                    break;
                case 3:
                    System.out.print("Enter day of the week to view tasks: ");
                    day = scanner.nextLine();
                    toDoList.showTasksForDay(day);
                    break;
                case 4:
                    toDoList.showAllTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}