package Day3;

    //Student management system (create student,marks,display)

	import java.util.Scanner;

	class Student {
	    private String name;
	    private int rollNumber;
	    private int[] marks = new int[3]; // For 3 subjects

	    // Constructor to initialize student
	    public Student(String name, int rollNumber) {
	        this.name = name;
	        this.rollNumber = rollNumber;
	    }

	    // Method to assign marks
	    public void assignMarks(int m1, int m2, int m3) {
	        marks[0] = m1;
	        marks[1] = m2;
	        marks[2] = m3;
	    }

	    // Method to calculate total marks
	    public int getTotalMarks() {
	        return marks[0] + marks[1] + marks[2];
	    }

	    // Method to calculate average
	    public double getAverageMarks() {
	        return getTotalMarks() / 3.0;
	    }

	    // Method to display student information and results
	    public void displayResults() {
	        System.out.println("Student Name: " + name);
	        System.out.println("Roll Number : " + rollNumber);
	        System.out.println("Marks       : " + marks[0] + ", " + marks[1] + ", " + marks[2]);
	        System.out.println("Total Marks : " + getTotalMarks());
	        System.out.printf("Average     : %.2f%n", getAverageMarks());
	    }
	}

	public class Task4 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Create student
	        System.out.print("Enter student name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter roll number: ");
	        int rollNumber = scanner.nextInt();

	        Student student = new Student(name, rollNumber);

	        // Assign marks
	        System.out.println("Enter marks for 3 subjects:");
	        System.out.print("Subject 1: ");
	        int m1 = scanner.nextInt();

	        System.out.print("Subject 2: ");
	        int m2 = scanner.nextInt();

	        System.out.print("Subject 3: ");
	        int m3 = scanner.nextInt();

	        student.assignMarks(m1, m2, m3);

	        // Display results
	        System.out.println("\n--- Student Result ---");
	        student.displayResults();

	        scanner.close();
	    }
	}


