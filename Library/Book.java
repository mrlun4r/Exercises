public class Book {

    String title;
    String publisher;
    int year;

// main function already exists in "Main" class, main function shouldnt be declared more than once
/*
    public static void main(String[] args) {
        Book cheese = new Book("Cheese Problems Solved", "Woodhead Publishing", 2007);

        System.out.println(cheese.getTitle());
        System.out.println(cheese.getPublisher());
        System.out.println(cheese.getYear());

        System.out.println(cheese);
    }
*/
    public Book(String title, String publisher, int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }
    
    public String toString(){
    	return "Title: " +title+ " \t Publisher: "+ publisher + " \t year: "+year;
    }

}
