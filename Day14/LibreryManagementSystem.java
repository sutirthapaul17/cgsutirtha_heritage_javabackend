class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean issued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                ", Title: " + title +
                ", Author: " + author +
                ", Status: " + (issued ? "Issued" : "Available");
    }
}

class Member {
    private int memberId;
    private String memberName;

    public Member(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }
}

class Library {
    private Book[] books;
    private int count;

    public Library(int size) {
        books = new Book[size];
        count = 0;
    }
    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        } else {
            System.out.println("Library is full!");
        }
    }
    public Book searchBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
    public void issueBook(String title, Member member) {
        Book book = searchBook(title);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book already issued!");
            return;
        }

        book.setIssued(true);
        System.out.println(
                book.getTitle() +
                        " issued to " +
                        member.getMemberName()
        );
    }
    public void returnBook(String title) {
        Book book = searchBook(title);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("Book was not issued!");
            return;
        }

        book.setIssued(false);
        System.out.println(book.getTitle() + " returned successfully.");
    }
    public void displayAvailableBooks() {
        System.out.println("\nAvailable Books:");

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (!books[i].isIssued()) {
                System.out.println(books[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books available.");
        }
    }
}

public class LibreryManagementSystem {
    public static void main(String[] args) {

        Library library = new Library(10);

        library.addBook(new Book(1, "Java Basics", "James Gosling"));
        library.addBook(new Book(2, "Data Structures", "Mark Allen"));
        library.addBook(new Book(3, "Operating Systems", "Galvin"));

        Member m1 = new Member(101, "Rahul");
        library.displayAvailableBooks();
        library.issueBook("Java Basics", m1);
        library.issueBook("Java Basics", m1);
        Book book = library.searchBook("Data Structures");
        if (book != null) {
            System.out.println("\nBook Found:");
            System.out.println(book);
        }
        library.returnBook("Java Basics");

        library.displayAvailableBooks();
    }
}