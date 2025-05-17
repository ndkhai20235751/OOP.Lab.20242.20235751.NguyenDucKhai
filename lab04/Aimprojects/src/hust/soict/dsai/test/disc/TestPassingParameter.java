package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungle = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderella = new DigitalVideoDisc("Cinderella");
		
		swap(jungle, cinderella);
		System.out.println("jungle dvd title: " + jungle.getTitle());
		System.out.println("cinderella dvd title: " + cinderella.getTitle());
		
		changeTitle(jungle, cinderella.getTitle());
		System.out.println("jungle dvd title: " + jungle.getTitle());
	}
	
	public static void swap(Object obj1, Object obj2) {
		Object tmp = obj1;
		obj1 = obj2;
		obj2 = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
