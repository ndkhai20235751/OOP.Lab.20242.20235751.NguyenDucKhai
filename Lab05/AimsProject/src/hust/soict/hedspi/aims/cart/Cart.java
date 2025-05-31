package hust.soict.hedspi.aims.cart;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	private int qtyOrdered;
	private ObservableList<Media> itemsOrdered =  FXCollections.observableArrayList();
	
	public String addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			throw new LimitExceededException("Error: The media's number has reached its limit!");
		} else if (itemsOrdered.contains(media)) {
			return (media.getTitle() + " is already in the cart!");
		} else {
			qtyOrdered++;
			itemsOrdered.add(media);
			return (media.getTitle() + " has been added!");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.size() == 0) {
			System.out.println("There's nothing to remove!");
		} else {
			if (itemsOrdered.remove(media)) {
				System.out.println(media.getTitle() + " has been removed from the cart!");
				qtyOrdered--;
			} else {
				System.out.println("Cannot find media in the cart!");
			}
		}
	}
	
	public float totalCost() {
		float sum = 0.00f;
		for (Media media : itemsOrdered) {
			sum += media.getCost();
		}
		return sum;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (Media media : itemsOrdered) {
			System.out.println(media);
		}
		System.out.println("Total items: " + qtyOrdered);
		System.out.println("Total cost: " + String.format("%.2f", totalCost()) + " $");
		System.out.println("***************************************************");
	}
	
	public void searchById(int id) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				System.out.println("Found DVD: " + media);
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("No DVD is found with ID: " + id);
		}
	}
	
	public void searchByTitle(String title) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.isMatch(title)) {
				System.out.println("Found DVD: " + media);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No DVD is found with Title: " + title);
		}
	}
	
	public void sortMediaByTitle() {
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
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title)) {
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

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
}
