package Day5;

import java.io.*;
import java.util.*;

public class Task5 {
    static ArrayList<String> studentNames = new ArrayList<>();
    static HashMap<Integer, ArrayList<String>> studentCourses = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("\n--- Mini Student Management App ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course to Student");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All");
            System.out.println("6. Save Courses to File");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addCourse();
                case 3 -> searchStudent();
                case 4 -> deleteStudent();
                case 5 -> displayAll();
                case 6 -> saveCoursesToFile();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        studentNames.add(name);
        int id = studentNames.size(); // ID is index + 1
        studentCourses.put(id, new ArrayList<>());
        System.out.println("Student added with ID: " + id);
    }

    static void addCourse() {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (studentCourses.containsKey(id)) {
            System.out.print("Enter course name: ");
            String course = scanner.nextLine();
            studentCourses.get(id).add(course);
            System.out.println("Course added.");
        } else {
            System.out.println("Invalid student ID.");
        }
    }

    static void searchStudent() {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (studentCourses.containsKey(id)) {
            System.out.println("Student Name: " + studentNames.get(id - 1));
            System.out.println("Courses: " + studentCourses.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (studentCourses.containsKey(id)) {
            studentCourses.remove(id);
            studentNames.set(id - 1, "[Deleted]");
            System.out.println("Student deleted.");
        } else {
            System.out.println("Invalid ID.");
        }
    }

    static void displayAll() {
        System.out.println("\n--- All Students ---");
        for (int id = 1; id <= studentNames.size(); id++) {
            String name = studentNames.get(id - 1);
            if (!name.equals("[Deleted]")) {
                System.out.println("ID: " + id + ", Name: " + name + ", Courses: " + studentCourses.get(id));
            }
        }
    }

    static void saveCoursesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("courses.txt"))) {
            for (int id : studentCourses.keySet()) {
                String name = studentNames.get(id - 1);
                if (!name.equals("[Deleted]")) {
                    writer.write("ID: " + id + ", Name: " + name + ", Courses: " + studentCourses.get(id));
                    writer.newLine();
                }
            }
            System.out.println("Course list saved to courses.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}

