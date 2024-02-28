package fundamentals;

public class Lab3_Book {
	
	    int bookid;
	    String title;
	    String author;
	    double price;

	    // Parameterized constructor for convenience
	    public Lab3_Book(int bookid, String title, String author, double price) {
	        this.bookid = bookid;
	        this.title = title;
	        this.author = author;
	        this.price = price;
	    }

	    // Method to print book details or show a message if not available
	    void displayBookDetails() {
	        if (bookid != 0) {
	            System.out.println("Book ID: " + bookid);
	            System.out.println("Title: " + title);
	            System.out.println("Author: " + author);
	            System.out.println("Price: $" + price);
	        } else {
	            System.out.println("Sorry, the book is not available.");
	        }
	    }
}
