package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public String toString() {
		return title + " (" + length + " min)";
	}

	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
		} else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
	}

	public boolean equals(Object O) {
		if (this == O) {
			return true;
		}
		if (O == null || !(O instanceof Track)) {
			return false;
		}
		Track other = (Track) O;
		return this.title.equals(other.getTitle()) && this.length == other.getLength();
	}

}
