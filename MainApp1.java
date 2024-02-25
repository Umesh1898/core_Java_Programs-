import java.util.Scanner;

class Employee {
    private String empId; 
    private String empName;
    private double empSalary;
    private int empAge;

    public Employee(String empId, String empName, double empSalary, int empAge) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
    }

    // Getters
    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public int getEmpAge() {
        return empAge;
    }

    // Setters
     
    public void setEmpSalary(double empSalary) {
        if (empSalary >= 10000 && empSalary <= 50000) {
            this.empSalary = empSalary;
            System.out.println("Salary updated successfully.");
        } else {
            System.out.println("Invalid salary. Salary should be between 10,000 and 50,000.");
        }
    }

    public void setEmpAge(int empAge) {
        if (empAge >= 25 && empAge <= 35) {
            this.empAge = empAge;
            System.out.println("Age updated successfully.");
        } else {
            System.out.println("Invalid age. Age should be between 25 and 35.");
        }
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee Salary: " + empSalary);
        System.out.println("Employee Age: " + empAge);
    }
}

public class MainApp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID : ");
        String empId = scanner.nextLine();

        System.out.print("Enter Employee Name : ");
        String empName = scanner.nextLine();

        System.out.print("Enter Employee Salary : ");
        double empSalary = scanner.nextDouble();

        System.out.print("Enter Employee Age ");
        int empAge = scanner.nextInt();

        
        Employee employee = new Employee(empId, empName, empSalary, empAge);

        
        System.out.println("\n Employee Details:");
        employee.displayEmployeeDetails();

        System.out.println("\nDo you want to edit?");
        System.out.println("1: Edit Salary");
        System.out.println("2: Edit Age");

        int option = scanner.nextInt();


        switch (option) {
            case 1:
                System.out.print("Enter new Salary: ");
                double newSalary = scanner.nextDouble();
                employee.setEmpSalary(newSalary);
                break;
            case 2:
                System.out.print("Enter new Age: ");
                int newAge = scanner.nextInt();
                employee.setEmpAge(newAge);
                break;
            default:
                System.out.println("Invalid option.");
        }

        System.out.println("\nUpdated Employee Details:");
        employee.displayEmployeeDetails();
    }
}
