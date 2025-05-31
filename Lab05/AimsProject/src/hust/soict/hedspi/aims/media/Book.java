package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private ArrayList<String> authors = new ArrayList<>();

	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.authors = new ArrayList<>(authors);
	}

	public void addAuthor(String AName) {
		if (authors.contains(AName)) {
			System.out.println("Author " + AName + " already exists");
		} else {
			authors.add(AName);
			System.out.println("Author " + AName + " is add to the authors list");
		}
	}

	public void removeAuthor(String AName) {
		if (authors.contains(AName)) {
			authors.remove(AName);
			System.out.println("Author " + AName + " is removed ");
		} else {
			System.out.println("Author " + AName + " is not in the authors list");
		}
	}

	@Override
	public String toString() {
		return "BOOK - " + this.getTitle() + " - " + this.getCategory() + " : " + this.getCost() + " $";
	}

}
