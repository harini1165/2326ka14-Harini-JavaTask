package Day5;

import java.util.*;

public class Task4{
    static ArrayList<String> students = new ArrayList<>();
    static HashMap<String, ArrayList<String>> courseMap = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Course Enrollment System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Add Course to Student");
            System.out.println("4. Remove Course from Student");
            System.out.println("5. Display All Students and Courses");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> addCourse();
                case 4 -> removeCourse();
                case 5 -> displayAll();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        if (!students.contains(name)) {
            students.add(name);
            courseMap.put(name, new ArrayList<>());
            System.out.println("Student added.");
        } else {
            System.out.println("Student already exists.");
        }
    }

    static void removeStudent() {
        System.out.print("Enter student name to remove: ");
        String name = scanner.nextLine();
        if (students.remove(name)) {
            courseMap.remove(name);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    static void addCourse() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        if (students.contains(name)) {
            System.out.print("Enter course name: ");
            String course = scanner.nextLine();
            ArrayList<String> courses = courseMap.get(name);
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println("Course added.");
            } else {
                System.out.println("Course already enrolled.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    static void removeCourse() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        if (students.contains(name)) {
            System.out.print("Enter course name to remove: ");
            String course = scanner.nextLine();
            ArrayList<String> courses = courseMap.get(name);
            if (courses.remove(course)) {
                System.out.println("Course removed.");
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
            return;
        }

        System.out.println("\n--- Student Enrollments ---");
        Iterator<String> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            String student = studentIterator.next();
            System.out.print("Student: " + student + " → Courses: ");

            ArrayList<String> courses = courseMap.get(student);
            Iterator<String> courseIterator = courses.iterator();
            if (!courseIterator.hasNext()) {
                System.out.print("None");
            }
            while (courseIterator.hasNext()) {
                System.out.print(courseIterator.next());
                if (courseIterator.hasNext()) System.out.print(", ");
            }
            System.out.println();
        }
    }
}
