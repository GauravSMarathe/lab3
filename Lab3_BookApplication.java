package fundamentals;


	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;



	public class Lab3_BookApplication {
	    public static void main(String[] args) {
	        // Create a predefined list of programming books
	        List<Lab3_Book> programmingBooks = new ArrayList<>();
	        programmingBooks.add(new Lab3_Book(101, "Clean Code", "Robert C. Martin", 29.99));
	        programmingBooks.add(new Lab3_Book(102, "Design Patterns", "Erich Gamma", 24.95));
	        programmingBooks.add(new Lab3_Book(103, "Java: The Complete Reference", "Herbert Schildt", 39.99));

	        // Display details for each predefined programming book
	        for (Lab3_Book book : programmingBooks) {
	            book.displayBookDetails();
	            System.out.println("---------------------");
	        }

	        // Get user input for book ID
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the Book ID to get details: ");
	        int userBookId = scanner.nextInt();

	        // Find and display the details of the selected book
	        boolean bookFound = false;
	        for (Lab3_Book book : programmingBooks) {
	            if (book.bookid == userBookId) {
	                book.displayBookDetails();
	                bookFound = true;
	                break;
	            }
	        }

	        // Display a message if the book is not found
	        if (!bookFound) {
	            System.out.println("Book with ID " + userBookId + " not found.");
	        }

	        // Close the Scanner to prevent resource leak
	        scanner.close();
	    }
}
