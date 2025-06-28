package Day5;

//Arraylist of students and displayes using iterator
import java.util.ArrayList;
import java.util.Iterator;

class Student {
    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void display() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name);
    }
}

public class Task1 {
    public static void main(String[] args) {
        // Create ArrayList of Student
        ArrayList<Student> students = new ArrayList<>();

        // Add Student objects
        students.add(new Student("Harish", 1));
        students.add(new Student("Harini", 2));
        students.add(new Student("charu", 3));

        // Display using Iterator
        System.out.println("Student List:");
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            s.display();
        }
    }
}

