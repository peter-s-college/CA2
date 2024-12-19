import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize scanner for user input

        try {
            int size;
            // Loop until a valid positive integer is entered
            while (true) {
                System.out.print("Enter a positive integer: ");
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

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner
        }
    }
}
