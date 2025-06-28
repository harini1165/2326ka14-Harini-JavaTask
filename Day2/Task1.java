package Day2;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner rs = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        int n = rs.nextInt();
        
        int[] numbers = new int[n];

        // Input array elements
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = rs.nextInt();
        }

        // Display array in reverse order
        System.out.println("Reversed array:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }

        rs.close();
    }
}

