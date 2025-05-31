package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
	// Doan nay lam giong nhu ben cart
	public static final int MAX_ITEMS = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<>();

	// Thêm Media
	public void addMedia(Media media) {
		if (itemsInStore.size() < MAX_ITEMS) {
			itemsInStore.add(media);
			System.out.println("The item has been added: " + media.getTitle());
		} else {
			System.out.println("The store is almost full");
		}
	}

	// Xóa một Media
	public void removeMedia(Media media) {
		if (itemsInStore.remove(media)) {
			System.out.println("The item has been removed: " + media.getTitle());
		} else {
			System.out.println("The item was not found in the store.");
		}
	}

	public Media getMedia(String titleMedia) {
		for (Media media : itemsInStore) {
			if (media.getTitle().equals(titleMedia)) {
				return media;
			}
		}

		return null;
	}

	// In danh sách hàng hoá
	public void printStore() {
		System.out.println("*************** STORE ***************");
		int i = 1;
		for (Media m : itemsInStore) {
			System.out.printf("%-4d %-20s %6.2f$\n", i++, m.getTitle(), m.getCost());
		}
		System.out.println("*************************************");
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
}
