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

    // Private temp method to find a student by ID
    private Student findStudentById(int id) {
    for (Student student : studentList) {
        if (student.getStudentId() == id) {
            return student;
        }
    }
    return null; // Not found
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
            while (true) {
                System.out.print("Please enter student's age: ");
                try {
                    age = scanner.nextInt(); // Read integer input
                    if (age < 0) {
                        System.out.println("Age cannot be negative. Please try again.");
                        // continue;
                    } else if (age > 0 && age < 18) {
                        System.out.println("Age must be 18 or older. Please try input age again.");
                        // continue;
                    } else {
                        scanner.nextLine(); // Consume the newline character after reading an integer
                        break; // Exit the loop if age is valid
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input for age. Please enter a valid number.");
                    scanner.nextLine(); // Clear the invalid input
                    // continue;
                }    
            }
            
            System.out.println("");
            System.out.print("Please enter Student's email: ");
            email = scanner.nextLine(); // Read string input correctly

            System.out.println("");
            System.out.print("Please enter Student's course: ");
            course = scanner.nextLine(); // Read string input correctly

            studentList.add(new Student(firstName, lastName, age, email, course));
            System.out.println("Student added successfully! Enter key to continue...");
            scanner.nextLine(); // Consume the newline character after reading input
            break; // Exit the loop after successful addition
        }
        
    }

    // Method to update or edit a student's information
    public void updateStudent() {
        gettAllStudents(); // Display student information to be updated
        while (true) {
            System.out.println("Please enter the ID of the student you want to update:");
            try {
                int id = scanner.nextInt(); // Read integer input for student ID
                Student student = findStudentById(id); // Use the helper method
                if (student != null) {
                    System.out.println("Student found: " + student.getFirstName() + " " + student.getLastName());
                    // Logic to update student information
                    System.out.print("Enter new first name (or press Enter to keep current): ");
                    scanner.nextLine(); // Consume newline
                    String newFirstName = scanner.nextLine();
                    if (!newFirstName.isEmpty()) {
                        student.setFirstName(newFirstName);
                    }

                    System.out.print("Enter new last name (or press Enter to keep current): ");
                    String newLastName = scanner.nextLine();
                    if (!newLastName.isEmpty()) {
                        student.setLastName(newLastName);
                    }

                    System.out.print("Enter new age (or press Enter to keep current): ");
                    String ageStr = scanner.nextLine();
                    if (!ageStr.isEmpty()) {
                        try {
                            int newAge = Integer.parseInt(ageStr);
                            if (newAge < 0) {
                                System.out.println("Age cannot be negative. Please try again.");
                            } else if (newAge < 18) {
                                System.out.println("Age must be 18 or older. Please try input age again.");
                            } else {
                                student.setAge(newAge);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input for age. Please enter a valid number.");
                        }
                    }

                    System.out.print("Enter new email (or press Enter to keep current): ");
                    String newEmail = scanner.nextLine();
                    if (!newEmail.isEmpty()) {
                        student.setEmail(newEmail);
                    }

                    System.out.print("Enter new course (or press Enter to keep current): ");
                    String newCourse = scanner.nextLine();
                    if (!newCourse.isEmpty()) {
                        student.setCourse(newCourse);
                    }

                    System.out.println("Student updated successfully!");
                } else {
                    System.out.println("Student with ID " + id + " not found.");
                }
                return; // Exit the method after processing

            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter an integer.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    // Method to retrieve a student by ID
    // public Student getStudentById(String studentId) {
    //     // Logic to find and return student's information by ID
    //     // Temp code
    //     return null;
    // }

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
    public void removeStudent() {
        gettAllStudents(); // Display all students before removal
        while (true) {
            System.out.print("Please enter ID of the student's data you want to remove: ");
            try {
                int id = scanner.nextInt(); // Read integer input
                Student student = findStudentById(id); // Use the helper method
                if (student != null) {
                    studentList.remove(student);
                    System.out.println("Student with ID " + id + " has been removed successfully.");
                } else {
                    System.out.println("Student with ID " + id + " not found.");
                }
                return; // Exit the method after processing
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter an integer.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
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
                        addStudent();
                        break;
                    case 2:
                        gettAllStudents();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        // getStudentById();
                        break;
                    case 5:
                        removeStudent();
                        break;
                    case 0:
                        System.out.println("See you next time!");
                        scanner.close();
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

