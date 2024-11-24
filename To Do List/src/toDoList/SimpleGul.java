//package toDoList;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//
//public class SimpleGul extends JFrame {
//
//    private static final long serialVersionUID = 6909850517279747320L;
//    private WeeklyToDoList toDoList;
//    private JTextField textField;
//    private JTextArea displayArea;
//    JPanel taskPanel;
//    JPanel mainPanel;
//
//    public SimpleGul() {
//        toDoList = new WeeklyToDoList();
//        setTitle("Schedule List");
//        setSize(500, 500);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        initComponents();
//        setVisible(true);
//    }
//
//    private void initComponents() {
//        mainPanel = new JPanel();
//        mainPanel.setLayout(new BorderLayout());
//
//        // Instruction Label
//        JLabel label = new JLabel("Enter option: 1-Add, 2-Remove, 3-Show Day, 4-Show All, 5-Exit");
//        mainPanel.add(label, BorderLayout.NORTH);
//
//        // Input Field and Submit Button
//        JPanel inputPanel = new JPanel();
//        textField  = new JTextField(15);
//        JTextField titleTextField = new JTextField(15);
//        JButton button = new JButton("Add");
//        inputPanel.add(textField);
//        inputPanel.add(titleTextField);
//        inputPanel.add(button);
//        mainPanel.add(inputPanel, BorderLayout.CENTER);
//        
//        // add the taskPanel
//        taskPanel = new JPanel();
//        taskPanel.setLayout(new FlowLayout());
//        mainPanel.add(taskPanel);
//
//
//        // Display Area
//        displayArea = new JTextArea(15, 30);
//        displayArea.setEditable(false);
//        mainPanel.add(new JScrollPane(displayArea), BorderLayout.SOUTH);
//        
//
//
//        // Day Buttons Panel
//        JPanel dayButtonsPanel = new JPanel();
//        dayButtonsPanel.setLayout(new FlowLayout());
//
//        String[] daysOfWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
//        for (String day : daysOfWeek) {
//            JButton dayButton = new JButton(day);
//            dayButton.addActionListener(e -> showTasksForDay(day));
//            dayButtonsPanel.add(dayButton);
//        }
//        mainPanel.add(dayButtonsPanel, BorderLayout.NORTH);
//
//        // Action for Submit Button
//        button.addActionListener(e -> processInput());
//        
//        
//       
//        // Add main panel to the frame
//        add(mainPanel);
//    }
//
//    private void processInput() {
//        String input = textField.getText();
//        try {
//            int option = Integer.parseInt(input);
//            switch (option) {
//                case 1:
//                    addTask();
//                    break;
//                case 2:
//                    removeTask();
//                    break;
//                case 3:
//                    showTasksForDayPrompt();
//                    break;
//                case 4:
//                    showAllTasks();
//                    break;
//                case 5:
//                    System.exit(0);
//                    break;
//                default:
//                    displayArea.setText("Invalid option. Please enter a number between 1 and 5.");
//            }
//        } catch (NumberFormatException e) {
//            displayArea.setText("Please enter a valid number.");
//        }
//    }
//
//    private void addTask() {
//        String day = JOptionPane.showInputDialog("Enter day of the week:");
//        String schedule = JOptionPane.showInputDialog("Enter schedule:");
//        String time = JOptionPane.showInputDialog("Enter time (e.g., 10:00 AM):");
//
//        if (day != null && schedule != null && time != null) {
//            toDoList.addTask(day, schedule, time);
//            displayArea.setText("Added task to " + day + ": " + schedule + " at " + time);
//        }
//    }
//
//    private void removeTask() {
//        String day = JOptionPane.showInputDialog("Enter day of the week:");
//        String indexStr = JOptionPane.showInputDialog("Enter task index to remove:");
//        try {
//            int index = Integer.parseInt(indexStr);
//            toDoList.removeTask(day, index);
//            displayArea.setText("Removed task from " + day + " at index " + index);
//        } catch (NumberFormatException e) {
//            displayArea.setText("Invalid index entered.");
//        }
//    }
//
//    private void showTasksForDay(String day) {
//        ArrayList<Task> tasks = toDoList.getWeeklyTasks().get(day);
//        // clear taskPanle.children
//        taskPanel.removeAll();
//        
//        if (tasks != null && !tasks.isEmpty()) {
//        	
//        	for(Task task: tasks) {
//        		JTextField taskTF= new JTextField(String.format("%s: %s",task.getTime(),task.getReason()));
//        		taskPanel.add(taskTF);
//        	}
//        	
//            StringBuilder tasksList = new StringBuilder("Tasks for " + day + ":\n");
//            for (int i = 0; i < tasks.size(); i++) {
//                tasksList.append(i).append(". ").append(tasks.get(i)).append("\n");
//            }
//            displayArea.setText(tasksList.toString());
//        } else {
//            displayArea.setText(day + " has no tasks.");
//        }
//        
//        mainPanel.repaint();
//       
//    }
//
//    private void showTasksForDayPrompt() {
//        String day = JOptionPane.showInputDialog("Enter day of the week to view tasks:");
//        showTasksForDay(day);
//    }
//
//    private void showAllTasks() {
//        StringBuilder allTasks = new StringBuilder("All tasks:\n");
//        for (String day : toDoList.getDaysOfWeek()) {
//            ArrayList<Task> tasks = toDoList.getTasksForDay(day);
//            allTasks.append(day).append(":\n");
//            if (tasks != null && !tasks.isEmpty()) {
//                for (int i = 0; i < tasks.size(); i++) {
//                    allTasks.append("  ").append(i).append(". ").append(tasks.get(i)).append("\n");
//                }
//            } else {
//                allTasks.append("  No tasks\n");
//            }
//        }
//        displayArea.setText(allTasks.toString());
//    }
//
//    public static void main(String[] args) {
//        new SimpleGul();
//    }
//}