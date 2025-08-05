package studentmanager;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    // List to store all student records
    private List<Student> studentList; //To declare what objects' data type is stored in the list

    // Constructor to initialize studentList
    public StudentManager() {
        studentList = new ArrayList<>(); //ArrayList is used as the concrete implementation of List
        studentList.add(new Student("John", "Doe", 20, "email", "Computer Science"));
        studentList.add(new Student("Jane", "Smith", 22, "email", "Mathematics"));
        studentList.add(new Student("Alice", "Johnson", 21, "email", "Physics"));
    }

    // Scanner for user input
    Scanner scanner = new Scanner(System.in);
    int selectionInt;

    // Clear screen method
    public void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    // Method to add a new student
    public void addStudent() {
        String firstName;
        String lastName;
        int age;
        String email;
        String course;
        scanner.nextLine(); //Consume leftover newline
        while (true) {
            System.out.print("Please enter Student's first name: ");
            firstName = scanner.nextLine(); // Read string input correctly

            System.out.println("");
            System.out.print("Please enter Student's last name: ");
            lastName = scanner.nextLine(); // Read string input correctly

            System.out.println("");
            System.out.print("Please enter student's age: ");
            try {
                age = scanner.nextInt(); // Read integer input
                if (age < 0) {
                    System.out.println("Age cannot be negative. Please try again.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid input for age. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            System.out.println("");
            System.out.print("Please enter Student's email: ");
            email = scanner.nextLine(); // Read string input correctly

            System.out.println("");
            System.out.print("Please enter Student's course: ");
            course = scanner.nextLine(); // Read string input correctly

            studentList.add(new Student(firstName, lastName, age, email, course));
            System.out.println("Student added successfully!");
            break; // Exit the loop after successful addition
        }
        
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
    public void gettAllStudents() {
        System.out.println("");
        System.out.println("Listing all students:");
        System.out.println("==============================");
        System.out.println("ID\tFirst Name\tLast Name\tAge\tEmail\tCourse");
        for (Student student : studentList) {
            System.out.printf("%d\t%s\t%s\t%d\t%s\t%s%n", 
                student.getStudentId(), 
                student.getFirstName(), 
                student.getLastName(), 
                student.getAge(), 
                student.getEmail(), 
                student.getCourse());
        }
        System.out.println("==============================");
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

                clearScreen();
                switch (selectionInt) {
                    case 1:
                        // Block of array code
                        addStudent();
                    case 2:
                        // Block of Linked List code
                        gettAllStudents();
                    case 3:
                        updateStudent(null);
                    case 4:
                        // getStudentById();
                    case 5:
                        // removeStudent();
                    case 0:
                        System.out.println("See you next time!");
                        break;
                    default:
                        System.out.println("Invalid Input! Please check your input again.");
                        System.out.println("");
                        break;
                }
                if (selectionInt == 0) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("");
                // System.out.println("Invalid Input! Please check your input again.");
                // clearScreen();
                scanner.nextLine();
            }
        }
    }

    // Constructor to initialize studentList and add dummy records
    // public StudentManager() {
    //     studentList = new ArrayList<>();
    //     studentList.add(new Student("John", "Doe", 20, "email", "Computer Science"));
    //     studentList.add(new Student("Jane", "Smith", 22, "email", "Mathematics"));
    //     studentList.add(new Student("Alice", "Johnson", 21, "email", "Physics"));
    // }

}

