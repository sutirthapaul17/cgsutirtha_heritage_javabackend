// Create a Book class and add a method displayBookInfo() to print all book details.

package ClassesAndObjects;

class Book {
    int bookId;
    String title;
    String author;
    double price;

    Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }


    void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }
}

public class q3 {
    public static void main(String[] args) {
        Book book1 = new Book(101, "Java Programming", "James Gosling", 499.99);

        book1.displayBookInfo();
    }
}