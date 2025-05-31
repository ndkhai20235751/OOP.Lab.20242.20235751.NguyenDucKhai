package aims;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	public int addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is nearly full! Please don't add more disc.");
			return 0;
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The DVD " + disc.getTitle() + " have been added!");
			return 1;
		}
	}
	
	public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (itemsOrdered[0] == null) {
			System.out.println("Your cart is empty right now!");
			return 0;
		}
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].equals(disc)) {
				for (int j = i + 1; j < qtyOrdered - 1; j++) {
					itemsOrdered[i] = itemsOrdered[j];
				}
				itemsOrdered[qtyOrdered - 1] = null;
				qtyOrdered--;
				System.out.println("Remove DVD " + disc.getTitle() + " successfully!");
				return 1;
			}
		}
		System.out.println("No DVD match!");
		return 0;
	}
	
	public float totalCost() {
		float sum = 0.00f;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
	
	public int addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		int count = 0;
		for (DigitalVideoDisc disc : dvdList) {
			if (qtyOrdered == MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is nearly full! Please don't add more disc.");
				break;
			} else {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println("The DVD " + disc.getTitle() + " has been added!");
				count++;
			}
		}
		return count;
	}
	
	public int addDigitalVideoDisc(DigitalVideoDisc... dvdArray) {
		int count = 0;
		for (DigitalVideoDisc disc : dvdArray) {
			if (qtyOrdered == MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is nearly full! Please don't add more disc.");
				break;
			} else {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println("The DVD " + disc.getTitle() + " has been added!");
				count++;
			}
		}
		return count;
	}
	
	public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DiditalVideoDisc dvd2) {
		if (qtyOrdered + 1 >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is nearly full! Please don't add more disc.");
			return 0;
		} else {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			System.out.println("The DVD " + dvd1.getTitle() + " has been added!");
			
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;
			System.out.println("The DVD " + dvd2.getTitle() + " has been added!");
			
			return 2;
		}
		
		
	}
}
