package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private String director;
	private int length;

	// ── Constructors ────────────────────────────────────────
	public Disc(String title) {
		super(title);
		this.director = "";
		this.length = 0;
	}

	public Disc(String title, String category, float cost) {
		super(title, category, cost);
		this.director = "";
		this.length = 0;
	}

	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = 0;
	}

	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}

	// ── Getters & (optional) Setters ────────────────────────
	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

}
