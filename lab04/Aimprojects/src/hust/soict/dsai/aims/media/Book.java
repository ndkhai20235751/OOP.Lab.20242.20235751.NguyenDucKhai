package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	



	
private List<String> authors=new ArrayList<String>();
   
public Book(String title) {
	super(title);
	// TODO Auto-generated constructor stub
}



public Book(String title, String category) {
	super(title, category);
	// TODO Auto-generated constructor stub
}


public Book(String title, String category, float cost) {
	super(title, category, cost);
	// TODO Auto-generated constructor stub
}


	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println("Add author");
		}
		else {
			System.out.println("Had author");
		}
	}
	

	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Remove author");
		}
		else {
			System.out.println("NO have author");
		}
	}
	
	public String toString() {
		return this.getId() + "  " + this.getTitle() + "  " + this.getCategory() + "  " + this.getCost();
	}
	
	
}
