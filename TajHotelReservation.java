package fundamentals;

import java.util.Scanner;

	public class TajHotelReservation {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Welcome to Taj Hotel Reservation System!");

	        int luxuryRooms = 5;
	        int acRooms = 10;
	        int nonAcRooms = 15;
	        int deluxeRooms = 20;

	        int luxuryCostPerDay = 2500;
	        int acCostPerDay = 2000;
	        int nonAcCostPerDay = 1500;
	        int deluxeCostPerDay = 2200;

	        while (true) {
	            System.out.println("\nAvailable Room Types:");
	            System.out.println("1. Luxury (Rs. 2500 per day)");
	            System.out.println("2. A/C (Rs. 2000 per day)");
	            System.out.println("3. Non A/C (Rs. 1500 per day)");
	            System.out.println("4. Deluxe (Rs. 2200 per day)");
	            System.out.println("5. Exit");

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            if (choice == 1) {
	                if (luxuryRooms > 0) {
	                    System.out.print("Enter the number of days: ");
	                    int days = scanner.nextInt();

	                    int cost = luxuryCostPerDay * days;
	                    luxuryRooms--;

	                    System.out.println("Room Booked! Your total cost is Rs. " + cost);
	                } else {
	                    System.out.println("Sorry, all Luxury rooms are occupied!");
	                }
	            } else if (choice == 2) {
	                if (acRooms > 0) {
	                    System.out.print("Enter the number of days: ");
	                    int days = scanner.nextInt();

	                    int cost = acCostPerDay * days;
	                    acRooms--;

	                    System.out.println("Room Booked! Your total cost is Rs. " + cost);
	                } else {
	                    System.out.println("Sorry, all A/C rooms are occupied!");
	                }
	            } else if (choice == 3) {
	                if (nonAcRooms > 0) {
	                    System.out.print("Enter the number of days: ");
	                    int days = scanner.nextInt();

	                    int cost = nonAcCostPerDay * days;
	                    nonAcRooms--;

	                    System.out.println("Room Booked! Your total cost is Rs. " + cost);
	                } else {
	                    System.out.println("Sorry, all Non A/C rooms are occupied!");
	                }
	            } else if (choice == 4) {
	                if (deluxeRooms > 0) {
	                    System.out.print("Enter the number of days: ");
	                    int days = scanner.nextInt();

	                    int cost = deluxeCostPerDay * days;
	                    deluxeRooms--;

	                    System.out.println("Room Booked! Your total cost is Rs. " + cost);
	                } else {
	                    System.out.println("Sorry, all Deluxe rooms are occupied!");
	                }
	            } else if (choice == 5) {
	                System.out.println("Thank you for using Taj Hotel Reservation System!");
	                break;
	            } else {
	                System.out.println("Invalid choice! Please try again.");
	            }
	        }

	        scanner.close();
	    }
	}
}
