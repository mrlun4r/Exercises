import java.util.ArrayList;

public class Library {
    
    private ArrayList<Book> book;
    
    public Library() {
        this.book = new ArrayList<Book>();
    }
    
    public void addBook(Book newBook) {
        this.book.add(newBook);
    }
    
    public void printBooks() {
        for (Book result : book){
            System.out.println(result);
        }
    }
    
    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> found = new ArrayList<Book>();
        for(Book result : this.book){
            if(title.contains(result.getTitle())){
                found.add(result);
            }
        }
        return found;
    }
    
    public ArrayList<Book> searchByPublisher(String publisher){
        ArrayList<Book> found = new ArrayList<Book>();
        for(int i =0; i < book.size(); i++){
            if(publisher.contains(this.book.get(i).getPublisher())){
                found.add(this.book.get(i));
            }
        }
        return found;
    }
}
