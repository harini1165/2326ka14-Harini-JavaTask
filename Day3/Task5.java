package Day3;

   //library class created (add,issued,display)

class Book {
    String title;
    boolean isIssued = false;

    // Set book title
    void addBook(String bookTitle) {
        title = bookTitle;
        isIssued = false;
        System.out.println("Book added: " + title);
    }

    // Issue the book
    void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book issued: " + title);
        } else {
            System.out.println("Book already issued.");
        }
    }

    // Display book info
    void displayBook() {
        System.out.println("Book Title: " + title);
        System.out.println("Status    : " + (isIssued ? "Issued" : "Available"));
    }
}

public class Task5 {
    public static void main(String[] args) {
        Book b1 = new Book();

        b1.addBook("Java Programming");
        b1.displayBook();

        b1.issueBook();
        b1.displayBook();
    }
}
