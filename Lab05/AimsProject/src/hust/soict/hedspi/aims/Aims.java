package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	private static final Store store = new Store();
	private static final Cart cart = new Cart();
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws PlayerException, LimitExceededException {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Terminator", "Action", "James Cameron", 107, 15.5f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Naruto", "Anime", "Hayato Date", 25, 10.0f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Dragon Ball", "Anime", "Akira Toriyama", 30, 12.0f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Ultraman", "Sci-fi", "Eiji Tsuburaya", 45, 14.0f);
		Book book1 = new Book("Naruto Databook", "Manga Guide", 20.0f, Arrays.asList("Masashi Kishimoto"));
		Book book2 = new Book("Dragon Ball Encyclopedia", "Manga Guide", 22.0f, Arrays.asList("Akira Toriyama"));
		ArrayList<Track> tracks = new ArrayList<>();
		tracks.add(new Track("Naruto Opening", 180));
		tracks.add(new Track("Dragon Ball Theme", 160));
		CompactDisc cd = new CompactDisc("Anime Classics", "Anime OST", 25.0f, "Various Artists", tracks);
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
		store.addMedia(book1);
		store.addMedia(book2);
		store.addMedia(cd);

		cart.addMedia(dvd1);
		cart.addMedia(cd);

		boolean exit = false;
		while (!exit) {
			showMenu();
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				viewStore();
				break;
			case "2":
				updateStore();
				break;
			case "3":
				seeCart();
				break;
			case "0":
				System.out.println("Exiting AIMS. Goodbye!");
				exit = true;
				break;
			default:
				System.out.println("Invalid option. Please choose again.");
			}
		}
	}

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 0-1-2-3: ");
	}

	public static void viewStore() throws PlayerException, LimitExceededException {
		System.out.println("Store Contents:");
		store.printStore();

		boolean back = false;
		while (!back) {
			storeMenu();
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				seeMediaDetails();
				break;
			case "2":
				addMediaToCart();
				break;
			case "3":
				playMediaFromStore();
				break;
			case "4":
				seeCart();
				break;
			case "0":
				back = true;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 0-1-2-3-4: ");
	}

	public static void seeMediaDetails() throws PlayerException, LimitExceededException {
		System.out.print("Enter the title of the media: ");
		String title = scanner.nextLine();
		Media media = store.getMedia(title);

		if (media != null) {
			System.out.println(media);
			boolean back = false;
			while (!back) {
				mediaDetailsMenu();
				String option = scanner.nextLine();
				switch (option) {
				case "1":
					cart.addMedia(media);
					break;
				case "2":
					if (media instanceof Playable) {
						((Playable) media).play();
					} else {
						System.out.println("This media cannot be played.");
					}
					break;
				case "0":
					back = true;
					break;
				default:
					System.out.println("Invalid input.");
				}
			}
		} else {
			System.out.println("Media not found.");
		}
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 0-1-2: ");
	}

	public static void addMediaToCart() throws LimitExceededException {
		System.out.print("Enter media title to add to cart: ");
		String title = scanner.nextLine();
		Media media = store.getMedia(title);
		if (media != null) {
			cart.addMedia(media);
		} else {
			System.out.println("Media not found in store.");
		}
	}

	public static void playMediaFromStore() throws PlayerException {
		System.out.print("Enter media title to play: ");
		String title = scanner.nextLine();
		Media media = store.getMedia(title);
		if (media instanceof Playable) {
			((Playable) media).play();
		} else {
			System.out.println("This media cannot be played or not found.");
		}
	}

	public static void updateStore() {
		System.out.println("1. Add media to store");
		System.out.println("2. Remove media from store");
		System.out.print("Choose option: ");
		String choice = scanner.nextLine();

		System.out.print("Enter media title: ");
		String title = scanner.nextLine();

		if (choice.equals("1")) {
			Media dummy = new DigitalVideoDisc(title, "Dummy Category", "Unknown", 90, 9.99f);
			store.addMedia(dummy);
		} else if (choice.equals("2")) {
			Media media = store.getMedia(title);
			if (media != null) {
				store.removeMedia(media);
			} else {
				System.out.println("Media not found.");
			}
		} else {
			System.out.println("Invalid option.");
		}
	}

	public static void seeCart() throws PlayerException {
		cart.printCart();
		boolean back = false;
		while (!back) {
			cartMenu();
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				filterCart();
				break;
			case "2":
				sortCart();
				break;
			case "3":
				removeFromCart();
				break;
			case "4":
				playMediaFromCart();
				break;
			case "5":
				System.out.println("Order placed successfully!");
				cart.clear();
				back = true;
				break;
			case "0":
				back = true;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 0-1-2-3-4-5: ");
	}

	public static void filterCart() {
		System.out.println("Filter by: 1. ID  2. Title");
		String opt = scanner.nextLine();
		if (opt.equals("1")) {
			System.out.print("Enter ID: ");
			int id = Integer.parseInt(scanner.nextLine());
			cart.searchById(id);
		} else if (opt.equals("2")) {
			System.out.print("Enter title: ");
			String title = scanner.nextLine();
			cart.searchByTitle(title);
		} else {
			System.out.println("Invalid filter option.");
		}
	}

	public static void sortCart() {
		System.out.println("Sort by: 1. Title  2. Cost");
		String opt = scanner.nextLine();
		if (opt.equals("1")) {
			cart.sort(Media.COMPARE_BY_TITLE_COST);
		} else if (opt.equals("2")) {
			cart.sort(Media.COMPARE_BY_COST_TITLE);
		} else {
			System.out.println("Invalid sort option.");
		}
	}

	public static void removeFromCart() {
		System.out.print("Enter media title to remove: ");
		String title = scanner.nextLine();
		Media media = cart.findByTitle(title);
		if (media != null) {
			cart.removeMedia(media);
		} else {
			System.out.println("Media not found in cart.");
		}
	}

	public static void playMediaFromCart() throws PlayerException {
		System.out.print("Enter title of media to play: ");
		String title = scanner.nextLine();
		Media media = cart.findByTitle(title);
		if (media instanceof Playable) {
			((Playable) media).play();
		} else {
			System.out.println("This media cannot be played or not found.");
		}
	}

}
