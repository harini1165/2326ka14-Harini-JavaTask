package Day3;

public class Task3 {
     //overloading sum(int) and sum(double)
	
	// Method 1: sum with two int parameters
	public int sum(int a, int b) {
		return a + b;
	}

	// Method 2: sum with two double parameters
	public double sum(double a, double b) {
		return a + b;
	}

	public static void main(String[] args) {
		Task3 obj = new Task3();

		int intResult = obj.sum(10, 20); // calls sum(int, int)
		double doubleResult = obj.sum(10.5, 20.5); // calls sum(double, double)

		System.out.println("Sum of integers: " + intResult);
		System.out.println("Sum of doubles: " + doubleResult);
	}
}
