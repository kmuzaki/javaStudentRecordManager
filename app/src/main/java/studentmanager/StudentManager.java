package studentmanager;

import java.util.List;
import java.util.Scanner;

public class StudentManager {
    // List to store all student records
    private List<Student> students;

    // Scanner for user input
    Scanner scanner = new Scanner(System.in);
    int selectionInt;
    String selectionString;

    // Clear screen method
    public void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    // Method to add a new student
    public void addStudent(Student student) {
        // Logic to add student to the database or collection
        System.out.println("Adding student: " + student.getFirstName() + " " + student.getLastName());
    }

    // Method to update or edit a student's information
    public void updateStudent(Student student) {
        // Logic to update student information in the database or collection
        System.out.println("Updating student: " + student.getFirstName() + " " + student.getLastName());
    }

    // Method to retrieve a student by ID
    public Student getStudentById(String studentId) {
        // Logic to find and return student's information by ID
        // Temp code
        return null;
    }

    // Method to list all students
    public List<Student> gettAllStudents() {
        return null; //Placeholder (Will be replace with actual logic)
    }

    // Method to remove a student by ID
    public void removeStudent(String studentId) {
        // Logic to remove student from the database or collection
        System.out.println("Removing student with ID: " + studentId);
    }

    // Method for main menu to manage students
    public void mainMenu(){
        
        while (true){
            System.out.println("=============================");
            System.out.println("Please select your selection:");
            System.out.println("1. Add new student");
            System.out.println("2. View all students");
            System.out.println("3. Edit student information");
            System.out.println("4. Search student by ID");
            System.out.println("5. Remove student");
            System.out.println("0. Exit");
            System.out.println("=============================");

            try {
                System.out.print("Type in selection> ");
                selectionInt = scanner.nextInt();

                if (selectionInt == 1) {
                    // Block of array code
                    clearScreen();
                    // System.out.println("You selected Array.");
                    addStudent(null);
                } else if (selectionInt == 2) {
                    // Block of Linked List code
                    clearScreen();
                    gettAllStudents();
                }
                
                else if (selectionInt == 3) {
                    System.out.println("See you next time!");
                    break;
                } 
                
                else if (selectionInt == 4) {
                    System.out.println("See you next time!");
                    break;
                } 
                
                else if (selectionInt == 5) {
                    System.out.println("See you next time!");
                    break;
                } 
                
                else if (selectionInt == 0) {
                    System.out.println("See you next time!");
                    break;
                } 
                
                else {
                    System.out.println("Invalid Input! Please check your input again.");
                    System.out.println("");
                }
                
            } catch (Exception e) {
                System.out.println("Invalid Input! Please check your input again.");
                clearScreen();
                scanner.nextLine();
            }
        }
    }
    
}
