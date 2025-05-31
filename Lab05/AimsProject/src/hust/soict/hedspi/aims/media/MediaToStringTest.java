package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class MediaToStringTest {
	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<>();

		DigitalVideoDisc dvd = new DigitalVideoDisc("Interstellar", "Sci-fi", "Christopher Nolan", 169, 21.5f);

		ArrayList<Track> cdTracks = new ArrayList<>();
		cdTracks.add(new Track("Numb", 185));
		cdTracks.add(new Track("In the End", 216));

		CompactDisc cd = new CompactDisc("Hybrid Theory", "Rock", 14.99f, "Linkin Park", cdTracks);

		ArrayList<String> bookAuthors = new ArrayList<>();
		bookAuthors.add("Cal Newport");

		Book book = new Book("Deep Work", "Productivity", 18.0f, bookAuthors);

		mediae.add(dvd);
		mediae.add(cd);
		mediae.add(book);

		float totalCost = 0f;

		for (Media m : mediae) {
			System.out.println("-------- MEDIA --------");
			System.out.println(m.toString());
			totalCost += m.getCost();
		}
		System.out.printf("\n>> Total cost of media: $%.2f\n", totalCost);
	}
}
