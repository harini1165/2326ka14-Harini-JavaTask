package Day5;

import java.util.HashSet;
import java.util.Scanner;

public class Task2{
    public static void main(String[] args) {
        HashSet<String> emails = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter email addresses (type 'done' to stop):");

        while (true) {
            System.out.print("Email: ");
            String email = scanner.nextLine();

            if (email.equalsIgnoreCase("done")) {
                break;
            }

            if (emails.add(email)) {
                System.out.println("Added.");
            } else {
                System.out.println("Duplicate email. Not added.");
            }
        }

        scanner.close();

        // Display unique email addresses
        System.out.println("\nUnique email addresses:");
        for (String email : emails) {
            System.out.println(email);
        }
    }
}

