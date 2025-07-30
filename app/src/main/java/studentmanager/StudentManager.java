package studentmanager;

import java.util.List;

public class StudentManager {
    // List to store all student records
    private List<Student> students;

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

    
}
