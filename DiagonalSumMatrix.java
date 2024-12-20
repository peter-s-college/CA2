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

                try {
                    // Parse the input into integers and fill the current row of the matrix
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = Integer.parseInt(rowElements[j]); // Convert each string to an integer
                    }
                    break; // Break the loop once the row input is valid
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter integers only."); // Error message for non-integer values
                }
            }
        }

        // Variables to store the sums of the diagonals
        int mainDiagonalSum = 0; // Sum of the main diagonal
        int secondaryDiagonalSum = 0; // Sum of the secondary diagonal

        // Calculate the sums of the main and secondary diagonals
        for (int i = 0; i < size; i++) {
            mainDiagonalSum += matrix[i][i]; // Add element from the main diagonal (row = column)
            secondaryDiagonalSum += matrix[i][size - 1 - i]; // Add element from the secondary diagonal (row + column = size - 1)
        }

        // Display the results
        System.out.println("Main diagonal sum: " + mainDiagonalSum); // Print the sum of the main diagonal
        System.out.println("Secondary diagonal sum: " + secondaryDiagonalSum); // Print the sum of the secondary diagonal

        scanner.close(); // Close the scanner to release resources
    }
}
