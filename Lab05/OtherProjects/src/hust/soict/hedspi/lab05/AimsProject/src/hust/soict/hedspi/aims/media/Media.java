package hust.soict.hedspi.aims.media;

import java.util.Comparator;

import hust.soict.hedspi.aims.exception.PlayerException;

public abstract class Media {
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	private int id;
	private String title;
	private String category;
	private float cost;
    private static int nbMedia = 0;
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getId() {
		return id;
	}


	public String getCategory() {
		return category;
	}


	public float getCost() {
		return cost;
	}


	public Media(String title) {
		this.title = title;
		this.id = ++nbMedia;
	}
	
	public Media(String title, String category) {
		this.title = title;
		this.category = category;
		this.id = ++nbMedia;
	}
	
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = ++nbMedia;
	}
	
	public boolean isMatch(String title) {
		return this.getTitle().toLowerCase().contains(title.toLowerCase());
	}
	
    public void play() throws PlayerException {
        System.out.println("Playing media");
    }
	
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Media)) {
			return false;
		}
		return (((Media)obj).getTitle() == this.getTitle());
	}
	
	public String toString() {
		return "Media: " + this.getTitle() + " - Category: " + this.getCategory() + " - Cost: " + this.getCost() + "$";
	}
	
	public int compareTo(Media other) {
        int titleComparison = this.getTitle().compareTo(other.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            return Double.compare(this.getCost(), other.getCost());
        }
    }
}
