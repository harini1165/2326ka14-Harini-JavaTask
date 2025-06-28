package Day1;


	import java.util.Scanner;
	public class Task5 {
	
	    
	    // Function to calculate grade based on marks
	    public static String calculateGrade(int marks) {
	        if (marks >= 90) {
	            return "A+";
	        } else if (marks >= 80) {
	            return "A";
	        } else if (marks >= 70) {
	            return "B";
	        } else if (marks >= 60) {
	            return "C";
	        } else if (marks >= 50) {
	            return "D";
	        } else {
	            return "F (Fail)";
	        }
	    }

	    public static void main(String[] args) {
	        Scanner mark = new Scanner(System.in);

	        // Input student marks
	        System.out.print("Enter student marks : ");
	        int marks = mark.nextInt();

	        // Validate input
	        if (marks < 0 || marks > 100) {
	            System.out.println("Invalid marks. Please enter a value between 0 and 100.");
	        } else {
	            // Calculate and print grade
	            String grade = calculateGrade(marks);
	            System.out.println("Student Result:");
	            System.out.println("Marks: " + marks);
	            System.out.println("Grade: " + grade);
	        }

	       mark.close();
	    }
	}


