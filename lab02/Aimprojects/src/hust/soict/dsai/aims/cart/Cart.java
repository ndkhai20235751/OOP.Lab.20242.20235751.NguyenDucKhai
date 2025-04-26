package hust.soict.dsai.aims.cart;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
 int qtyOrdered;
  public int MAX_NUMBERS_ORDERED=20;
  private ArrayList<Media> itemsOrdered=new ArrayList<Media>();
  
  
  
  public void addMedia(Media media) {
	  if(itemsOrdered.size()>=MAX_NUMBERS_ORDERED) {
		  System.out.println("Error");
	  }
	  else if (!itemsOrdered.contains(media)) {
	        itemsOrdered.add(media);
	        qtyOrdered++;
	  }
	  else {
		  System.out.println("Had");
	  }
  }
  
  public void removeMedia(Media media) {
	  if (itemsOrdered.contains(media)) {
	        itemsOrdered.remove(media);
	  }
	  else {
		  System.out.println("NO HAVE");
	  }
  }
  
  public float totalCost() {
	  float total=0.00f;
	for(Media media:itemsOrdered) {
		total+=media.getCost();
	}
	return total;
  }
  
  public void print() {
	  System.out.println("Ordered items:");
    for(Media media:itemsOrdered) {
    	System.out.println(media);
    }
    System.out.println("Total items:"+qtyOrdered);
    System.out.println("Total cost:"+String.format("%.2f",totalCost()));
  }
 public void searchByID(int id) {
	 int check=0;
	 for(Media media:itemsOrdered) {
		 if(media.getId()==id) {
			 System.out.println(media);
			 check=1;
			 break;
		 }
	 }
	 if(check==0) {
		 System.out.println("NO HAVE: "+id);
	 }
 }
 
 
 public void searchByTitle(String title) {
	 int check=0;
	 for(Media media:itemsOrdered) {
		 if(media.isMatch(title)) {
			 System.out.println(media);
			 check=1;
			 break;
		 }
	 }
	 if(check==0) {
		 System.out.println("NO HAVE: "+title);
	 }
	 
 }
 
 public void sortMediaBytitle() {
	 Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		Iterator<Media> iterator = itemsOrdered.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(((Media)iterator.next()).toString());
		}
 
 }
 
 public void sortMediaByCost() {
		Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		Iterator<Media> iterator = itemsOrdered.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(((Media)iterator.next()).toString());
		}
	}
 
 
 public Media searchToRemove(String title) {
	 for(Media media:itemsOrdered) {
		 if(media.getTitle().equals(title)) {
			 return media;
		 }
	 }
	 return null;
 }
 public void empty() {
	 if (itemsOrdered.size() == 0) {
			System.out.println("Nothing in cart!");
		} else {
			qtyOrdered = 0;
			itemsOrdered.clear();
			System.out.println("Order created successfully!");
			System.out.println("Your cart is empty!");
			System.out.println();
		}
	
 }
  
}
