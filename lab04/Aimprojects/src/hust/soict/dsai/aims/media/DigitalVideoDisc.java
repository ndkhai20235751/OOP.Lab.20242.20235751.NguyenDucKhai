package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class DigitalVideoDisc extends Disc implements Playable {
	
	 public DigitalVideoDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}
	public DigitalVideoDisc(String title, String category, String director, int length,float cost) {
		super(title,category,director,length,cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Play DVD: " + this.getTitle());

		System.out.println("DVD length: " + this.getLength());
	}

	public String toString() {
		return this.getId() + "  " + this.getTitle() + " " + this.getCategory() + "  " + this.getDirector() + "   "
				+ this.getLength() + "  " + this.getCost() ;
	}



	
}
