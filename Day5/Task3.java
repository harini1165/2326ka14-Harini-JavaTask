package Day5;

import java.util.HashMap;
import java.util.Scanner;

public class Task3{
    public static void main(String[] args) {
        HashMap<String, Integer> studentMarks = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student name and marks (type 'done' to stop):");

        while (true) {
            System.out.print("Student Name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Marks: ");
            int marks = Integer.parseInt(scanner.nextLine());

            studentMarks.put(name, marks);
        }

        scanner.close();

        // Display all entries
        System.out.println("\nStudent Marks:");
        int total = 0;
        for (String name : studentMarks.keySet()) {
            int marks = studentMarks.get(name);
            System.out.println(name + " → " + marks);
            total += marks;
        }

        // Compute average
        int count = studentMarks.size();
        if (count > 0) {
            double average = (double) total / count;
            System.out.printf("\nAverage Marks: %.2f\n", average);
        } else {
            System.out.println("No students entered.");
        }
    }
}


