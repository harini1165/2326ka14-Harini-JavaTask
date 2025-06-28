package Day2;

import java.util.Scanner;

public class Task2 {

	public static void main(String args[]) {

		Scanner count = new Scanner(System.in);

		System.out.println("the string is:");

		String s = count.nextLine().toLowerCase();

		int vowels = 0, consonants = 0;

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (ch >= 'a' && ch <= 'z') {

				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {

					vowels++;

				} else {

					consonants++;

				}

			}

		}

		System.out.println("vowels:" + vowels);

		System.out.println("consonants:" + consonants);

		count.close();

	}

}
