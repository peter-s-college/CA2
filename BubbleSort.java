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

        // Display the array before sorting
        System.out.println("Array before sorting: ");
        displayArray(array);

        // Perform Bubble Sort and count swaps
        int swapCount = bubbleSort(array);

        // Display the array after sorting
        System.out.println("Array after sorting: ");
        displayArray(array);

        // Display the number of swaps
        System.out.println("Total number of swaps: " + swapCount);

        scanner.close();
    }

    // Bubble Sort method
    public static int bubbleSort(int[] array) {
        int swapCount = 0;
        int n = array.length;
        boolean swapped;

        // Perform Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap the elements if they are in the wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                    swapCount++;
                }
            }
            // If no elements were swapped, the array is already sorted
            if (!swapped) {
                break;
            }
        }
        return swapCount;
    }

    // Method to display the array
    public static void displayArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
