package hust.soict.hedspi.aims.media;
import java.util.*;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

    // Constructor
    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }
    
	public List<String> getAuthors() {
		return authors;
	}

	public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
	public void addAuthor(String authorsName) {
		if(!authors.contains(authorsName)) {
			authors.add(authorsName);
			System.out.println("The author has been added");
		}
		else {
			System.out.println("The author already exists");
		}
	}
	
	public void removeAuthor(String authorsName) {
		if(authors.contains(authorsName)) {
			authors.remove(authorsName);
			System.out.println("The author has been revomed");
		}
		else {
			System.out.println("The author does not exist");
		}
	}
	public String toString() {
		return this.getId()+" - "+"BOOK"+" - "+this.getTitle()+" - "+this.getCategory()+" - "+this.getAuthors()+" - "+this.getCost()+"$";
	}
}