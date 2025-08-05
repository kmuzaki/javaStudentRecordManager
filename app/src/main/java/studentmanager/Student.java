package studentmanager;

public class Student {
    // Fields for student attributes
    private static int idCounter = 0; // Static counter for unique student IDs
    private int studentId;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String course;

    // Full constructor for Student object class
    public Student(String firstName, String lastName, int age, String email, String course) {
        this.studentId = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getter methods for each attribute
    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }


    // Setter methods for each attribute
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
