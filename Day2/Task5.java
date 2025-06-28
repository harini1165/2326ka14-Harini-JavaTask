package Day2;

import java.util.Scanner;

public class Task5 {

	public static void main(String[] args) {

		Scanner book = new Scanner(System.in);

		String[] names = new String[5]; // Array to store names

		String[] phoneNumbers = new String[5]; // Array to store phone numbers

		int count = 0; // Number of contacts stored

		while (true) {

			System.out.println("\nMini Address Book");

			System.out.println("1. Add Contact");

			System.out.println("2. Display Contacts");

			System.out.println("3. Exit");

			System.out.print("Choose an option: ");

			int choice = book.nextInt();

			book.nextLine(); // consume newline

			if (choice == 1) {

				if (count == names.length) {

					System.out.println("Address book full.");

				} else {

					System.out.print("Enter name: ");

					names[count] = book.nextLine();

					System.out.print("Enter phone number: ");

					phoneNumbers[count] = book.nextLine();

					count++;

					System.out.println("Contact added.");

				}

			} else if (choice == 2) {

				if (count == 0) {

					System.out.println("No contacts to display.");

				} else {

					System.out.println("\nContacts:");

					for (int i = 0; i < count; i++) {

						System.out.println((i + 1) + ". " + names[i] + " - " + phoneNumbers[i]);

					}

				}

			} else if (choice == 3) {

				System.out.println("Exiting address book.");

				break;

			} else {

				System.out.println("Invalid option! Try again.");

			}

		}

		book.close();

	}
}
