package Day1;

import java.util.Scanner;

public class Task4 {

	public static double add(double a, double b) {

		return a + b;

	}

	public static double sub(double a, double b) {

		return a - b;

	}

	public static double mul(double a, double b) {

		return a * b;

	}

	public static double div(double a, double b) {

		if (b == 0) {

			System.out.println("it is divisible by 0");

			return 0;

		}
		return a / b;

	}

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);

		System.out.println("1.Add");

		System.out.println("2.subtraction");

		System.out.println("3.multiply");

		System.out.println("4.Divide");

		System.out.println("choose(1-4):");

		int choose = scan.nextInt();

		System.out.println("Enter first number:");

		double num1 = scan.nextDouble();

		System.out.println("Enter second number:");

		double num2 = scan.nextDouble();

		double result = 0;

		switch (choose) {

		case 1:
			result = add(num1, num2);
			break;

		case 2:
			result = sub(num1, num2);
			break;

		case 3:
			result = mul(num1, num2);
			break;

		case 4:
			result = div(num1, num2);
			break;

		}

		System.out.println("Result:" + result);

		scan.close();

	}

}