package Day4;

import java.io.*;

public class Task4 {
	public static void main(String[] args) {
		String inputFile = "marks.txt";
		String outputFile = "src/results.txt";  // will appear inside the src folder

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));) {
			String line;

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				String name = parts[0];
				int total = 0;

				for (int i = 1; i < parts.length; i++) {
					total += Integer.parseInt(parts[i]);
				}

				double average = total / (parts.length - 1.0);
				String result = average >= 40 ? "Pass" : "Fail";

				writer.write(name + " - Average: " + String.format("%.2f", average) + " - Result: " + result);
				writer.newLine();
			}

			System.out.println("Results written to " + outputFile);

		} catch (IOException e) {
			System.err.println("Error processing files: " + e.getMessage());
		}
	}
}
