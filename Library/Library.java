import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    private ArrayList<Book> book;
    private Scanner reader;

    public Library() {
        this.book = new ArrayList<Book>();
    }

    public Library(Scanner reader) {
        this.reader = reader;
    }

    public void addBook(Book newBook) {
        this.book.add(newBook);
    }

    public void printBooks() {
        for (Book result : book) {
            System.out.println(result);
        }
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> found = new ArrayList<Book>();
        for (Book result : this.book) {
            if (strToLowerCase(result.getTitle()).contains(title)) {
                found.add(result);
            }
        }
        return found;
    }

    public ArrayList<Book> searchByPublisher(String publisher) {
        ArrayList<Book> found = new ArrayList<Book>();
        for (int i = 0; i < book.size(); i++) {
            if (this.book.get(i).getPublisher().contains(publisher)) {
                found.add(this.book.get(i));
            }
        }
        return found;
    }

    public String strToLowerCase(String str) {
        String result = str.toLowerCase();
        return result;
    }

    public String readInput() {
        String result = reader.nextLine();
        return result.toLowerCase().trim();
    }
}
