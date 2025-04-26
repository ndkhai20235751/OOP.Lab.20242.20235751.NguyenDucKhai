package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
   private int id;
   private String title;
   private String category;
   private float cost;
   private static int i=0;
   public Media(String title) {
		this.title = title;
		this.id = ++i;
	}
	
	public Media(String title, String category) {
		this.title = title;
		this.category = category;
		this.id = ++i;
	}
	
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = ++i;
	}
  public int getId() {
	return id;
 }
 public void setId(int id) {
	this.id = id;
 }
 public String getTitle() {
	return title;
 }
 public void setTitle(String title) {
	this.title = title;
 }
 public String getCategory() {
	return category;
 }
 public void setCategory(String category) {
	this.category = category;
 }
 public float getCost() {
	return cost;
 }
 public void setCost(float cost) {
	this.cost = cost;
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
		return " " + this.getTitle() + "  " + this.getCategory() + "  " + this.getCost() ;
	}
  public boolean isMatch(String title) {
		return this.getTitle().toLowerCase().contains(title.toLowerCase());
	}
  public void play() {
      System.out.println("Playing media");
  }
}
