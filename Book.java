//The class should have the constructor public Book(String title, String publisher, int year) and methods public String title(), 
//public String publisher(), public int year() and public String toString().
package exercises;

public class Book {

    String title;
    String publisher;
    int year;

    public static void main(String[] args) {
        Book cheese = new Book("Cheese Problems Solved", "Woodhead Publishing", 2007);

        System.out.println(cheese.title());
        System.out.println(cheese.publisher());
        System.out.println(cheese.year());

        System.out.println(cheese);
    }

    public Book(String title, String publisher, int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    public String title() {
        return title;
    }

    public String publisher() {
        return publisher;
    }

    public int year() {
        return year;
    }

}
