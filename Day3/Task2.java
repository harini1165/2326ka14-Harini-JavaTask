package Day3;
    //Basic salary calculation using class fields and methods

	//  class
	class Person {
	    String name;
	    int age;
	}

	// Subclass
	class Employee extends Person {
	    double basicSalary;
	    double hra;         // House Rent Allowance
	    double deduction;

	    // Method to calculate salary
	    double calculateSalary() {
	        return basicSalary + hra - deduction;
	    }

	    // Method to display employee info
	    void display() {
	        System.out.println("Name: " + name);
	        System.out.println("Age: " + age);
	        System.out.println("Basic Salary: " + basicSalary);
	        System.out.println("HRA: " + hra);
	        System.out.println("Deduction: " + deduction);
	        System.out.println("Net Salary: " + calculateSalary());
	    }
	}

	// Main class
	public class Task2 {
	    public static void main(String[] args) {
	        // Create an employee object
	        Employee emp = new Employee();

	        // Assign values
	        emp.name = "John";
	        emp.age = 28;
	        emp.basicSalary = 3000;
	        emp.hra = 1000;
	        emp.deduction = 500;

	        // Display details
	        emp.display();
	    }
	}


