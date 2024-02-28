package fundamentals;

import java.util.Scanner;

	public class Lab3_AverageCal {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Accept the size of the array from the user
	        System.out.print("Enter the size of the numbers you want to find average of: ");
	        int size = scanner.nextInt();

	        // Validate that the size is a positive integer
	        if (size <= 0) {
	            System.out.println("Please enter a valid positive size for the array.");
	            return; // Exit the program if the size is not valid
	        }

	        // Create an array to store the numbers
	        int[] numbers = new int[size];

	        // Accept numbers from the user
	        System.out.println("Enter " + size + " numbers:");

	        for (int i = 0; i < size; i++) {
	            System.out.print("Enter number " + (i + 1) + ": ");
	            numbers[i] = scanner.nextInt();
	        }

	        // Calculate the average
	        double sum = 0;
	        for (int number : numbers) {
	            sum += number;
	        }

	        double average = sum / size;

	        // Display the average
	        System.out.println("Average of the numbers is: " + average);

	        // Close the Scanner to prevent resource leak
	        scanner.close();
	    }

}
