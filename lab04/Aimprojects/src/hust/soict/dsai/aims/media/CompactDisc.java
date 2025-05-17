package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	

	
	private String artist;
     private ArrayList<Track> track=new ArrayList<Track>();
     private int count=0;
	public CompactDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String title, String category,String artist, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
		this.artist=artist;
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		// TODO Auto-generated constructor stub
	}
     
	
	public void addTrack(Track tra) {
		if(!track.contains(tra)) {
			track.add(tra);
			System.out.println("ADD TRACK");
		}
		else {
			System.out.println("HAD TRACK");
		}
	}
	
	public void removeTrack(Track tra) {
		if(track.contains(tra)) {
			track.remove(tra);
			System.out.println("Remove track");
		}
		else {
			System.out.println("NO have track");
		}
	}
	public int getLength() {
	   	int total=0;
	   	for(Track tra:track) {
	   		total+=tra.getLength();
	   	}
	   	return total;
	
	}
	@Override
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for (Track tra : track) {
			tra.play();
		}
		
	}

	public String getArtist() {
		return artist;
	}

	
	public String toString() {
		return this.getId() + " " + this.getTitle() + " " + this.getCategory() + " " + this.getArtist() + "  " + this.getLength()  + "  " + this.getCost();
	}
}
