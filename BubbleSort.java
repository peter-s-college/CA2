import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;

        // Validate the array size input to ensure it's a single positive integer
        while (true) {
            System.out.print("Enter the size of the array: ");
            String input = scanner.nextLine().trim();
            
            // Check if the input is a valid single integer
            if (input.matches("\\d+")) { // Match one or more digits
                size = Integer.parseInt(input);
                if (size > 0) {
                    break; // valid positive size input
                } else {
                    System.out.println("Size must be a positive integer. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid positive integer.");
            }
        }

        int[] array = new int[size];

        // Input array elements in a single line
        System.out.println("Enter the elements of the array (space-separated):");

        // Read the entire line of input
        String inputLine = scanner.nextLine();
        String[] inputElements = inputLine.split("\\s+"); // Split input into array elements

        // Validate the number of elements
        while (inputElements.length != size) {
            System.out.println("You must enter exactly " + size + " numbers. Try again.");
            inputLine = scanner.nextLine();
            inputElements = inputLine.split("\\s+");
        }

        // Validate each element is an integer
        for (int i = 0; i < size; i++) {
            try {
                array[i] = Integer.parseInt(inputElements[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers only.");
                return; // Exit the program if invalid input is found
            }
        }
        scanner.close();
    }
}
