/** To_do list ( final project)
 * @author Hong Huynh
 * @version 1.0
 * @since 1.0
 * 
 *This is a to-do list that organizes tasks by day of the week, reason, and time schedule, 
 *this project layout that should give us a comprehensive, day-specific to-do list.
 
 *Adding Tasks:

The addTask() method takes the day, reason, and time, creating a new Task object and adding it to the corresponding day's ArrayList.
Removing Tasks:

The removeTask() method takes the day and index of the task to remove.
Showing Tasks:

The showTasksForDay() method displays tasks for a specified day.
The showAllTasks() method iterates over each day of the week and displays all tasks.
Menu Options:

The main() method provides a user interface to add, remove, and view tasks, looping until the user decides to exit.
*/




package toDoList;

public class Task {

	private String schedule;
    private String time;

    public Task(String schedule, String time) {
        this.schedule = schedule;
        this.time = time;
    }

    public String getReason() {
        return schedule;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Time: " + time + ", schedule for: " + schedule;
    }
}
