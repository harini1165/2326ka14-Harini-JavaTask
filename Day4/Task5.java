package Day4;

import java.io.*;
import java.util.*;

class Employee {
    String id;
    String name;
    String designation;
    double salary;

    public Employee(String id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + designation + "," + salary;
    }

    public static Employee fromString(String record) {
        String[] parts = record.split(",");
        return new Employee(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }
}

public class Task5 {
    static final String FILE_NAME = "employees.txt";

    public static void createEmployee(Employee emp) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(emp.toString());
            writer.newLine();
        }
    }

    public static List<Employee> readAllEmployees() throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                employees.add(Employee.fromString(line));
            }
        }
        return employees;
    }

    public static void updateEmployee(String id, Employee updatedEmployee) throws IOException {
        List<Employee> employees = readAllEmployees();
        boolean found = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee emp : employees) {
                if (emp.id.equals(id)) {
                    writer.write(updatedEmployee.toString());
                    found = true;
                } else {
                    writer.write(emp.toString());
                }
                writer.newLine();
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void deleteEmployee(String id) throws IOException {
        List<Employee> employees = readAllEmployees();
        boolean found = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee emp : employees) {
                if (!emp.id.equals(id)) {
                    writer.write(emp.toString());
                    writer.newLine();
                } else {
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEmployee Record System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Designation: ");
                    String designation = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = Double.parseDouble(scanner.nextLine());

                    createEmployee(new Employee(id, name, designation, salary));
                    System.out.println("Employee added successfully.");
                }
                case 2 -> {
                    List<Employee> employees = readAllEmployees();
                    if (employees.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        System.out.println("Employee Records:");
                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter New Designation: ");
                    String designation = scanner.nextLine();
                    System.out.print("Enter New Salary: ");
                    double salary = Double.parseDouble(scanner.nextLine());

                    updateEmployee(id, new Employee(id, name, designation, salary));
                    System.out.println("Update attempted.");
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    String id = scanner.nextLine();
                    deleteEmployee(id);
                    System.out.println("Delete attempted.");
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
            scanner.close();  }
    }
}

