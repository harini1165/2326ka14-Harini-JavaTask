package Day2;
	import java.util.Scanner;

	public class Task3{

	    public static void main(String[] args) {

	        Scanner split = new Scanner(System.in);

	        System.out.print("Enter a sentence: ");

	        String sentence = split.nextLine();

	        String[] words = sentence.split(" ");

	        System.out.println("The words in the sentence :");

	        for (String word : words) {

	            System.out.println(word);

	        }

	        split.close();

	    }

	}

