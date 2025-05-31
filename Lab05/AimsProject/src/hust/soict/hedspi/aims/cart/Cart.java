package hust.soict.hedspi.aims.cart;

import java.util.Comparator;

import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;

	// xoa het roi thay bang Arraylist cho media
	private static ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	// them
	public static void addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			throw new LimitExceededException("ERROR: The number of media has reached its limit.");
		}
		itemsOrdered.add(media);
	}

	// xoa
	public void removeMedia(Media media) {
		if (itemsOrdered.remove(media)) {
			System.out.println("The item has been removed: " + media.getTitle());
		} else {
			System.out.println("The item was not found in the cart.");
		}
	}

	// tổng chi phí
	public float totalCost() {
		float total = 0.0f;
		for (Media m : itemsOrdered) {
			total += m.getCost();
		}
		return total;
	}

	// In nội dung giỏ và tổng giá
	public void printCart() {
		System.out.println("*************** CART ***************");
		int i = 1;
		for (Media m : itemsOrdered) {
			System.out.printf("%-4d %-20s %6.2f$\n", i++, m.getTitle(), m.getCost());
		}
		System.out.printf("\n%-20s %6.2f$\n", "Total cost:", totalCost());
		System.out.println("************************************");
	}

	// Tìm theo ID
	public void searchById(int id) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				System.out.println(media.toString());
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println("No media found with ID: " + id);
	}

	// Tìm theo tiêu đề
	public void searchByTitle(String title) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				System.out.println(media.toString());
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println("No media found with title: " + title);
	}

	// Tìm và trả về Media (dùng cho remove/play)
	public Media findByTitle(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				return media;
			}
		}
		return null;
	}

	// Sắp xếp bằng Comparator (title hoặc cost)
	public void sort(Comparator<Media> comparator) {
		itemsOrdered.sort(comparator);
		System.out.println("Cart sorted successfully.");
	}

	// Xoá toàn bộ giỏ hàng
	public void clear() {
		itemsOrdered.clear();
		System.out.println("Cart has been cleared.");
	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

}
