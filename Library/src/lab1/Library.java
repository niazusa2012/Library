package lab1;

import java.util.ArrayList;

/**
 * A representation of a library of books.
 *
 * @author Niaz Morshed and Devaya Gurung.
 */
public class Library {

    String address = "";
    ArrayList<Book> books = new ArrayList<>();
    int numBooks = 0;

    public Library(String new_address) {
        address = new_address;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress() {
        System.out.println(address);
    }

    public void borrowBook(String title) {
        if (null != title) {
            for (Book book : books) {
                if (book.getTitle().equals(title)) {
                    if (true == book.isBorrowed()) {
                        System.out.println("Sorry, this book was already borrowed.");
                        return;
                    } else {
                        System.out.println("You successfully borrowed " + book.getTitle());
                        book.isBorrowed();
                        return;
                    }
                }
            }
            System.out.println("Sorry, that book was not found in our library.");
        }
    }

    public void returnBook(String title) {
        if (null != title) {
            for (Book book : books) {
                if (book.getTitle().equals(title)) {
                    System.out.println("You successfully returned " + title);
                    book.returned();
                    return;
                }
            }
        }
    }

    public void printAvailableBooks() {
        if (books.isEmpty()) {
            System.out.println("No books were found in the catalog.");
        }
        for (Book book : books) {
            if (book.isBorrowed()) {

            } else {
                System.out.println(book.getTitle());
            }
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
