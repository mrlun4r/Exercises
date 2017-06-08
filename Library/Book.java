public class Book {

    private String title;
    private String publisher;
    private int date;

    public Book(String title, String publisher, int date) {
        this.title = title;
        this.publisher = publisher;
        this.date = date;
    }

    //getters
    public String getTitle() {
        return this.title;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public int getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return "Title: " + title + " \t Publisher: " + publisher + " \t year: " + date;
    }
}
