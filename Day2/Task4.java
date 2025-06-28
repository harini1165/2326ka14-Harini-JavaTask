package Day2;

import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {

		Scanner analyzer = new Scanner(System.in);

		System.out.println("Enter a string:");

		String input = analyzer.nextLine();

		String[] words = input.split(" ");

		int wordCount = words.length;

		int charCount = 0;

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) != ' ') {

				charCount++;

			}

		}

		String reversed = "";

		for (int i = input.length() - 1; i >= 0; i--) {

			reversed += input.charAt(i);

		}

		String longestWord = "";

		for (String w : words) {

			if (w.length() > longestWord.length()) {

				longestWord = w;

			}

		}

		System.out.println("Words count: " + wordCount);

		System.out.println("Characters count  " + charCount);

		System.out.println("Reversed string: " + reversed);

		System.out.println("Longest word: " + longestWord);

		analyzer.close();

	}

}
