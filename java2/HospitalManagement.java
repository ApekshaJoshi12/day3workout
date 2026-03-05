abstract class Patient {
    protected int patientId;
    protected String name;

    
    public Patient(int patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }

    
    abstract double calculateBill();

   
    public void displayDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
    }
}


class InPatient extends Patient {
    private int numberOfDays;
    private double roomChargePerDay;

    public InPatient(int patientId, String name, int numberOfDays, double roomChargePerDay) {
        super(patientId, name);
        this.numberOfDays = numberOfDays;
        this.roomChargePerDay = roomChargePerDay;
    }

    @Override
    double calculateBill() {
        return numberOfDays * roomChargePerDay + 2000; 
    }
}


class OutPatient extends Patient {
    private double consultationFee;
    private double medicineCharge;

    public OutPatient(int patientId, String name, double consultationFee, double medicineCharge) {
        super(patientId, name);
        this.consultationFee = consultationFee;
        this.medicineCharge = medicineCharge;
    }

    @Override
    double calculateBill() {
        return consultationFee + medicineCharge;
    }
}


public class HospitalManagement {
    public static void main(String[] args) {

        Patient p1 = new InPatient(101, "Apeksha", 5, 3000);
        Patient p2 = new OutPatient(102, "Rahul", 500, 1500);

        System.out.println("---- InPatient Details ----");
        p1.displayDetails();
        System.out.println("Total Bill: " + p1.calculateBill());

        System.out.println("\n---- OutPatient Details ----");
        p2.displayDetails();
        System.out.println("Total Bill: " + p2.calculateBill());
    }
}