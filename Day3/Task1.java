package Day3;

import java.util.Scanner;

class BankAccount {
	private String accountHolder;
	private double balance;

	public BankAccount(String name, double initialBalance) {
		accountHolder = name;
		balance = initialBalance;
	}

	// Method to deposit money
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("\nDeposited: $" + amount);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	// Method to withdraw money
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawn: $" + amount);
		} else {
			System.out.println("Insufficient balance or invalid amount.");
		}
	}

	// Method to display account info
	public void display() {
		System.out.println("\n Account Holder: " + accountHolder);
		System.out.println(" Current Balance: $" + balance);
	}
}

public class Task1 {
	public static void main(String[] args) {
		Scanner ba = new Scanner(System.in);

		// Input account details
		System.out.print("Enter account holder name: ");
		String name = ba.nextLine();

		System.out.print("Enter initial balance: ");
		double initialBalance = ba.nextDouble();

		// Create bank account
		BankAccount account = new BankAccount(name, initialBalance);

		account.display();
		account.deposit(5);
		account.withdraw(10);
		account.display();

		ba.close();
	}
}
