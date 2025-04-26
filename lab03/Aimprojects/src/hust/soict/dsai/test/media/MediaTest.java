package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class MediaTest {
	public static void main(String[] args) {
        List<Media> media = new ArrayList<Media>();
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book("Detective Conan", "Detective", 20.00f);

        CompactDisc cd = new CompactDisc("Believer", "Music","Imagine Dragon", 2500.99f);
        Track track1 = new Track("THE WXRDIES", 110);
        Track track2 = new Track("Hex", 50);
        Track track3 = new Track("The World", 200);
       cd.addTrack(track1);
       cd.addTrack(track2);
       cd.addTrack(track3);
       media.add(cd);
       media.add(dvd);
       media.add(book);
       for (Media m : media) {
           System.out.println(m.toString());
       }
    }
      
    
}
