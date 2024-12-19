import java.util.Scanner;

public class ArraySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize a scanner to read user input

        try {
            System.out.print("Enter the size of the array: ");
            int sizeOfArray = 0;

            // Validate the size of the array
            while (true) {
                if (scanner.hasNextInt()) { // Check if the input is a valid integer
                    sizeOfArray = scanner.nextInt(); // Read the integer
                    if (sizeOfArray > 0) { // Ensure the size is a positive integer
                        break; // Exit the loop if valid input is provided
                    } else {
                        System.out.println("Size must be a positive integer. Try again:"); // Prompt for positive input
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer for size:"); // Handle non-integer input
                    scanner.next(); // Consume the invalid input to avoid infinite loop
                }
            }

            scanner.nextLine(); // Consume leftover newline character after reading size
            System.out.println("Enter " + sizeOfArray + " elements of the array, separated by spaces:");

            // Read the entire line of input
            String inputLine = scanner.nextLine();
            String[] inputStrings = inputLine.trim().split("\\s+"); // Split the input line by spaces into an array

            // Validate if the input length matches the array size
            if (inputStrings.length != sizeOfArray) {
                System.out.println("Error: Number of elements does not match the specified size of the array.");
                return; // Exit the program if the number of elements is incorrect
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage()); // Handle unexpected exceptions
        } finally {
            scanner.close(); // Ensure the scanner is closed to release system resources
        }
    }
}
