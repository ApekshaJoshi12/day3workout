abstract class Employee {
    String name;
    int id;

    
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    
    abstract double calculateSalary();

    
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}


class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    
    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}


class PartTimeEmployee extends Employee {
    double hoursWorked;
    double hourlyRate;

    PartTimeEmployee(String name, int id, double hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    
    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}


public class New1 {
    public static void main(String[] args) {

        Employee emp1 = new FullTimeEmployee("Apeksha", 101, 50000);
        Employee emp2 = new PartTimeEmployee("Rahul", 102, 5, 500);

        emp1.displayDetails();
        System.out.println("Salary: " + emp1.calculateSalary());

        System.out.println();

        emp2.displayDetails();
        System.out.println("Salary: " + emp2.calculateSalary());
    }
}