import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize scanner for user input

        try {
            int size;
            // Loop until a valid positive integer is entered
            while (true) {
                System.out.print("Enter size of multiplication table: ");
                if (scanner.hasNextInt()) { // Check if input is an integer
                    size = scanner.nextInt();
                    if (size > 0) { // Check if the integer is positive
                        break; // Exit the loop if valid input
                    } else {
                        System.out.println("Size must be a positive integer. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Consume the invalid input
                }
            }

            // Create a 2D array to store the multiplication table
            int[][] table = new int[size][size];

            // Populate the 2D array with multiplication values
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    table[i][j] = (i + 1) * (j + 1); // (i+1) and (j+1) to start from 1 instead of 0
                }
            }

            // Display the multiplication table in matrix form
            System.out.println("\nMultiplication Table:");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.printf("%4d", table[i][j]); // Print each value formatted to align in columns
                }
                System.out.println(); // Move to the next row
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner
        }
    }
}
