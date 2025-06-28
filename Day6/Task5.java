package Day6;



import java.util.*;
import java.io.*;

public class Task5
{

    static ArrayList<String> studentNames = new ArrayList<>();
    static HashMap<String, ArrayList<String>> studentCourses = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        int choice;

        do 
        {
            System.out.println("\n--- Mini Student Management App ---");
            System.out.println("1. Add Student & Courses");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Delete Student");
            System.out.println("4. Save Courses to File");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) 
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    saveToFile();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } 
        while (choice != 5);
    }

    static void addStudent() 
    {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        studentNames.add(name);

        ArrayList<String> courses = new ArrayList<>();
        System.out.print("Enter number of courses: ");
        int num = scanner.nextInt(); scanner.nextLine();

        for (int i = 0; i < num; i++) {
            System.out.print("Enter course " + (i + 1) + ": ");
            courses.add(scanner.nextLine());
        }

        studentCourses.put(id, courses);
        System.out.println("Student added!");
    }

    static void searchStudent() 
    {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();

        if (studentCourses.containsKey(id)) 
        {
            System.out.println("Courses for Student ID " + id + ":");
            for (String course : studentCourses.get(id)) 
            {
                System.out.println("- " + course);
            }
        } 
        else 
        {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() 
    {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();

        if (studentCourses.containsKey(id)) 
        {
            studentCourses.remove(id);
            System.out.println("Student removed.");
        } 
        else 
        {
            System.out.println("Student not found.");
        }
    }

    static void saveToFile() 
    {
        try 
        {
            FileWriter writer = new FileWriter("courses.txt");

            for (Map.Entry<String, ArrayList<String>> entry : studentCourses.entrySet()) 
            {
                writer.write("Student ID: " + entry.getKey() + "\n");
                for (String course : entry.getValue()) {
                    writer.write(" - " + course + "\n");
                }
                writer.write("\n");
            }

            writer.close();
            System.out.println("Course list saved to courses.txt");
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
        }
    }
}
