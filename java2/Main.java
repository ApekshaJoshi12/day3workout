import java.util.ArrayList;
import java.util.Scanner;


abstract class Student {
    private int studentId;
    private String name;
    private double marks;
    private char grade;

    public Student(int studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        setMarks(marks); 
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks! Must be between 0 and 100.");
            return;
        }
        this.marks = marks;
        calculateGrade(); 
    }

    public char getGrade() {
        return grade;
    }

    protected void setGrade(char grade) {
        this.grade = grade;
    }

    
    public double getEffectiveMarks() {
        return marks;
    }

    public abstract void calculateGrade();

    public void displayDetails() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------");
    }
}


class RegularStudent extends Student {

    public RegularStudent(int studentId, String name, double marks) {
        super(studentId, name, marks);
    }

    @Override
    public void calculateGrade() {
        double marks = getMarks();

        if (marks >= 90)
            setGrade('A');
        else if (marks >= 75)
            setGrade('B');
        else if (marks >= 60)
            setGrade('C');
        else
            setGrade('F');
    }
}


class ScholarshipStudent extends Student {

    public ScholarshipStudent(int studentId, String name, double marks) {
        super(studentId, name, marks);
    }

    @Override
    public double getEffectiveMarks() {
        return getMarks() + 5; 
    }

    @Override
    public void calculateGrade() {
        double bonusMarks = getEffectiveMarks();

        if (bonusMarks >= 90)
            setGrade('A');
        else if (bonusMarks >= 75)
            setGrade('B');
        else if (bonusMarks >= 60)
            setGrade('C');
        else
            setGrade('F');
    }
}


class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {
            s.displayDetails();
        }
    }

    public Student searchStudentById(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null;
    }

    public void updateMarks(int id, double newMarks) {
        Student s = searchStudentById(id);

        if (s != null) {
            s.setMarks(newMarks);
            System.out.println("Marks updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void findTopper() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student topper = students.get(0);

        for (Student s : students) {
            if (s.getEffectiveMarks() > topper.getEffectiveMarks()) {
                topper = s;
            }
        }

        System.out.println("Top Performer:");
        topper.displayDetails();
    }
}


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice;

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Find Topper");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    System.out.println("1. Regular Student");
                    System.out.println("2. Scholarship Student");
                    System.out.print("Select type: ");
                    int type = sc.nextInt();

                    Student student;

                    if (type == 1)
                        student = new RegularStudent(id, name, marks);
                    else if (type == 2)
                        student = new ScholarshipStudent(id, name, marks);
                    else {
                        System.out.println("Invalid type selected!");
                        break;
                    }

                    service.addStudent(student);
                    break;

                case 2:
                    service.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    Student found = service.searchStudentById(searchId);

                    if (found != null)
                        found.displayDetails();
                    else
                        System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter new marks: ");
                    double newMarks = sc.nextDouble();

                    service.updateMarks(updateId, newMarks);
                    break;

                case 5:
                    service.findTopper();
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}