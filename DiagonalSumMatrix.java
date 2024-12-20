import java.util.Scanner;

public class DiagonalSumMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = 0; // Variable to store the size of the matrix

        // Validate matrix size input
        while (true) {
            System.out.print("Enter size of matrix: "); // Prompt the user to input the size of the matrix
            if (scanner.hasNextInt()) { // Check if the input is an integer
                size = scanner.nextInt(); // Read the size
                if (size > 0) { // Ensure the size is a positive integer
                    break; // Exit the loop if the input is valid
                } else {
                    System.out.println("Size must be a positive integer. Try again."); // Error message for non-positive size
                }
            } else {
                System.out.println("Invalid input. Please enter an integer."); // Error message for non-integer input
                scanner.next(); // Consume invalid input to prevent infinite loop
            }
        }

        // Create a 2D array (square matrix) with the given size
        int[][] matrix = new int[size][size];

        // Input matrix elements row by row
        System.out.println("Enter elements row by row:");
        scanner.nextLine(); // Consume leftover newline after reading the size

        for (int i = 0; i < size; i++) { // Loop through each row of the matrix
            while (true) {
                System.out.print("Row " + (i + 1) + ": "); // Prompt user to enter elements for the current row
                String input = scanner.nextLine().trim(); // Read the entire row input and remove extra spaces
                String[] rowElements = input.split("\\s+"); // Split the input into individual numbers based on spaces

                if (rowElements.length != size) { // Check if the user entered the correct number of elements
                    System.out.println("Please enter exactly " + size + " integers for this row."); // Error message
                    continue; // Restart the current row input loop
                }
            }
        }
        scanner.close(); // Close the scanner to release resources
    }
}
