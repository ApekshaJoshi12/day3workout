class Student {
   
    private String name;
    private int marks;

    
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

   
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        if (marks >= 0) {
            this.marks = marks;
        } else {
            System.out.println("Marks cannot be negative!");
        }
    }

   
    public String calculateGrade() {
        if (marks >= 80) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 40) return "C";
        else return "Fail";
    }
}


class GraduateStudent extends Student {

    public GraduateStudent(String name, int marks) {
        super(name, marks);
    }

   
    @Override
    public String calculateGrade() {
        int bonusMarks = getMarks() + 5;   

        if (bonusMarks >= 80) return "A";
        else if (bonusMarks >= 60) return "B";
        else if (bonusMarks >= 40) return "C";
        else return "Fail";
    }
}


public class Main4 {
    public static void main(String[] args) {

        Student s1 = new Student("Apeksha", 75);
        System.out.println("Student Name: " + s1.getName());
        System.out.println("Grade: " + s1.calculateGrade());

        GraduateStudent g1 = new GraduateStudent("Rahul", 75);
        System.out.println("\nGraduate Student Name: " + g1.getName());
        System.out.println("Grade with Bonus: " + g1.calculateGrade());
    }
}