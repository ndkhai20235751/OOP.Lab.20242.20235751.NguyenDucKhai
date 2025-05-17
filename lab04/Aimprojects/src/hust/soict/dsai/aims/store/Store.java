package hust.soict.dsai.aims.store;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;

import javax.management.modelmbean.InvalidTargetObjectTypeException;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
 private ArrayList<Media> itemsStore=new ArrayList<Media>();
 private int count =0;
 
 public void addMedia(Media media) {
	 if (!itemsStore.contains(media)) {
	        itemsStore.add(media);
	        System.out.println("ADD MEDIA");
	    } else {
	        System.out.println("have in the store.");
	    }
 }
 
 public void removeMedia(Media media) {
	 if (itemsStore.contains(media)) {
	        itemsStore.remove(media);
	        System.out.println("REMOVE MEDIA");
	    } else {
	        System.out.println(" not in the store.");
	    }

 }
 public void print() {
		if (itemsStore.size() == 0) {
			System.out.println("The store is empty!");
		} else {
			System.out.println("************************INVENTORY***********************");
			for (Media media : itemsStore) {
				System.out.println(media);
			}
			System.out.println("********************************************************");
		}
	}
 public ArrayList<Media> getItemsInStore() {
		return itemsStore;
	}
 public Media search(String title) {
		for (Media media : itemsStore) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
	
}
