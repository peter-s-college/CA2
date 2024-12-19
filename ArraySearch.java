import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

            // Parse the inputs into integers
            int[] array = new int[sizeOfArray]; // Create an integer array to store the parsed values
            for (int i = 0; i < sizeOfArray; i++) {
                try {
                    array[i] = Integer.parseInt(inputStrings[i]); // Convert each input string to an integer
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter integers only."); // Handle invalid number format
                    return; // Exit the program if a non-integer is found
                }
            }

            // Find the first repeated element
            Set<Integer> seen = new HashSet<>(); // Create a HashSet to track seen numbers
            for (int i = 0; i < array.length; i++) {
                int num = array[i]; // Get the current number
                if (seen.contains(num)) { // Check if the number has already been seen
                    System.out.println("First repeated element: " + num); // Print the first repeated element
                    return; // Exit the program after finding the first repeated element
                }
                seen.add(num); // Add the number to the set of seen numbers
            }

            System.out.println("No repeated elements found."); // Print if no repeated elements are found

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage()); // Handle unexpected exceptions
        } finally {
            scanner.close(); // Ensure the scanner is closed to release system resources
        }
    }
}
