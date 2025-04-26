package hust.soict.dsai.aims;

import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	
	public static void main(String[] args) throws LimitExceededException {
		
		boolean emerge = false;
		while (!emerge) {
			showMenu();
			
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
				case 0:
					emerge = true;
					System.out.println("Thank you for using our product! Goodbye and see you later.");
					break;
				case 1:
					storeMenu(scanner);
					break;
				case 2:
					updateStoreMenu(scanner);
					break;
				case 3:
					cartMenu(scanner);
					break;
				default:
					System.out.println("Invalid choice! Please choose again.");
					break;
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
		System.out.println("Please choose a number: 0-1-2-3");
		
	}
	
	public static void storeMenu(Scanner scanner) throws LimitExceededException {
		boolean back = false;
		while(!back) {
			
			store.print();
			
			System.out.println("Options: ");
			System.out.println("--------------------------------"); 
			System.out.println("1. See a media’s details"); 
			System.out.println("2. Add a media to cart"); 
			System.out.println("3. Play a media"); 
			System.out.println("4. See current cart"); 
			System.out.println("0. Back"); 
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2-3-4");
			
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
				case 0:
					back = true;
					break;
				case 1:
					boolean foundForDetails = false;
					while (!foundForDetails) {
						System.out.println("Enter the title of the media (type '#' to stop): ");
						String title = scanner.nextLine();
						if (title.equals("#")) {
							break;
						}
						Media media = store.search(title);
						if (media != null) {
							System.out.println("Details: ");
							System.out.println(media);
							mediaDetailsMenu(scanner, media);
							foundForDetails = true;
						} else {
							System.out.println("Media not found!");
						}
					}
					break;
				case 2:
					boolean foundToAdd = false;
					while (!foundToAdd) {
						System.out.println("Enter the title of the media (tpe '#' to stop): ");
						String title = scanner.nextLine();
						if (title.equals("#")) {
							break;
						}
						Media media = store.search(title);
						if (media != null) {
							if (media instanceof Disc || media instanceof CompactDisc) {
								media.play();
							} else {
								System.out.println("Media not found!");
							}
						}
					}
					break;
				case 4:
					cartMenu(scanner);
					break;
				default:
					System.out.println("Invalid choice! Please choose again.");
					
			}
		}
		
	}
	
	public static void mediaDetailsMenu(Scanner scanner, Media media) throws LimitExceededException {
		boolean back = false;
		while (!back) {
			
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. Add to cart"); 
			System.out.println("2. Play"); 
			System.out.println("0. Back"); 
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2");
			
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch(option) {
				case 0:
					back = true;
					break;
				case 1:
					cart.addMedia(media);
					break;
				case 2:
					if (media instanceof Disc || media instanceof CompactDisc) {
						media.play();
					} else {
						System.out.println("This type of media haven't been supported yet!");
					}
					break;
				default:
					System.out.println("Invalid choice! Please choose again.");
					break;
			}
		}
		
	}
	
	public static void cartMenu(Scanner scanner) {
		boolean back = false;
		while(!back) {

			cart.print();
			
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. Filter media in cart"); 
			System.out.println("2. Sort media in cart"); 
			System.out.println("3. Remove media from cart"); 
			System.out.println("4. Play a media"); 
			System.out.println("5. Place order"); 
			System.out.println("0. Back"); 
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2-3-4-5");
			
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
				case 0:
					back = true;
					break;
				case 1:
					System.out.println("Filter by id (1) or title (2): ");
					int filterChoice = scanner.nextInt();
					scanner.nextLine();
					boolean found = false;
					while (!found) {
						if (filterChoice == 1) {
							System.out.println("Enter the id to filter (type '0' to stop): ");
							int id = scanner.nextInt();
							scanner.nextLine();
							if (id == 0) {
								break;
							}
							cart.searchByID(id);;
							found = true;
						} else if (filterChoice == 2) {
							System.out.println("Enter the title to filter (type '#' to stop): ");
							String title = scanner.nextLine();
							if (title.equals("#")) {
								break;
							}
							cart.searchByTitle(title);
							found = true;
						} else if (filterChoice == 0) {
							break;
						} else {
							System.out.println("Invalid choice!");
						}
					}
					break;
				case 2:
					System.out.println("Sort media by title (1) or cost (2): ");
					int sortChoice = scanner.nextInt();
					scanner.nextLine();
					if (sortChoice == 1) {
						cart.sortMediaBytitle();;
					} else if (sortChoice == 2) {
						cart.sortMediaByCost();
					} else {
						System.out.println("Invalid choice!");
					}
					break;
				case 3:
					boolean foundToDelete = false;
					while (!foundToDelete) {
						System.out.println("Enter the title of the media (type '#' to stop): ");
						String title = scanner.nextLine();
						if (title.equals("#")) {
							break;
						}
						Media media = cart.searchToRemove(title);
						if (media != null) {
							cart.removeMedia(media);
							foundToDelete = true;
						} else {
							System.out.println("Media not found!");
						}
					}
					break;
				case 4:
					boolean foundToPlay = false;
					while (!foundToPlay) {
						System.out.println("Enter the title of the media (type '#' to stop): ");
						String title = scanner.nextLine();
						if (title.equals("#")) {
							break;
						}
						Media media = store.search(title);
						if (media != null) {
							if (media instanceof Disc || media instanceof CompactDisc) {
								media.play();
							} else {
								System.out.println("This type of media haven't been supported yet!");
							}
							foundToPlay = true;
						} else {
							System.out.println("Media not found!");
						}
					}
					break;
				case 5:
					cart.empty();
					break;
				default:
					System.out.println("Invalid choice!");
					break;
			}
		}

	}
	
	public static void updateStoreMenu(Scanner scanner) {
		boolean back = false;
		while (!back) {
			
		}
	}
	
}
