import java.util.Scanner; // Import Scanner class for user input

public class SpiralMatrixTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read input

        int rows = 0, columns = 0; // Variables to store the number of rows and columns

        // Loop to validate and accept rows and columns input
        while (true) {
            System.out.print("Enter rows and columns of matrix: ");
            String input = scanner.nextLine().trim(); // Read the input and remove extra spaces
            String[] dimensions = input.split("\\s+"); // Split the input into parts based on spaces

            // Check if the input contains exactly two parts (rows and columns)
            if (dimensions.length != 2) {
                System.out.println("Invalid input. Please enter exactly two positive integers.");
                continue; // Retry input if not valid
            }

            try {
                // Parse the two parts as integers
                rows = Integer.parseInt(dimensions[0]);
                columns = Integer.parseInt(dimensions[1]);

                // Check if both integers are positive
                if (rows > 0 && columns > 0) {
                    break; // Valid input; exit the loop
                } else {
                    System.out.println("Rows and columns must be positive integers. Try again.");
                }
            } catch (NumberFormatException e) {
                // Handle invalid number input
                System.out.println("Invalid input. Please enter exactly two positive integers.");
            }
        }

        // Create a matrix (2D array) with the specified dimensions
        int[][] matrix = new int[rows][columns];

        // Prompt the user to input the elements of the matrix row by row
        System.out.println("Enter the elements row by row (space-separated):");

        // Loop to input each row of the matrix
        for (int i = 0; i < rows; i++) {
            while (true) {
                System.out.print("Row " + (i + 1) + ": "); // Prompt for the current row
                String input = scanner.nextLine().trim(); // Read the input and remove extra spaces
                String[] rowElements = input.split("\\s+"); // Split the input into parts based on spaces

                // Check if the number of elements matches the number of columns
                if (rowElements.length != columns) {
                    System.out.println("Please enter exactly " + columns + " numbers for this row.");
                    continue; // Retry row input if not valid
                }

                try {
                    // Parse the row elements as integers and fill the matrix
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = Integer.parseInt(rowElements[j]);
                    }
                    break; // Row input is valid; exit the loop
                } catch (NumberFormatException e) {
                    // Handle invalid number input in the row
                    System.out.println("Invalid input. Please enter integers only.");
                }
            }
        }
        scanner.close(); // Close the scanner to release resources
    }
}