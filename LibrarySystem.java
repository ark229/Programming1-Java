// Unit 2 Assignment - Create a library System with Java

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    String author;
    int quantity;

    Book(String author, int quantity) {
        this.author = author;
        this.quantity = quantity;
    }
}

public class LibrarySystem {
    private static HashMap<String, Book> library = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nOptions:\n1. Add Books\n2. Borrow Books\n3. Return Books\n4. Show Books\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    borrowBooks();
                    break;
                case 3:
                    returnBooks();
                    break;
                case 4:
                    showBooks();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addBooks() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (library.containsKey(title)) {
            Book book = library.get(title);
            book.quantity += quantity;
            System.out.println("Quantity updated. Total quantity: " + book.quantity);
        } else {
            library.put(title, new Book(author, quantity));
            System.out.println("Book added to the library.");
        }
    }

    private static void borrowBooks() {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity to borrow: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (library.containsKey(title) && library.get(title).quantity >= quantity) {
            library.get(title).quantity -= quantity;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Requested number of books not available.");
        }
    }

    private static void returnBooks() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity to return: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (library.containsKey(title)) {
            library.get(title).quantity += quantity;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book does not belong to our library.");
        }
        scanner.close();

    }

    private static void showBooks() {
        if (library.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        System.out.println("\nBooks in the Library:");
        for (Map.Entry<String, Book> entry : library.entrySet()) {
            System.out.println("Title: " + entry.getKey() + ", Author: " + entry.getValue().author + ", Quantity: "
                    + entry.getValue().quantity);
        }

    }

}
