package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
	private int id;
	private String title;
	private String category;
	private float cost;
	private static int nbMedia = 0;

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatoryByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatoryByCostTitle();

	// ── Constructors ────────────────────────────────────────
	public Media(String title) {
		this(generateId(), title, "", 0.0f);
	}

	public Media(String title, String category, float cost) {
		this(generateId(), title, category, cost);
	}

	// central constructor
	private Media(int id, String title, String category, float cost) {
		this.id = generateId();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	private static int generateId() {
		return ++nbMedia;
	}

	// ── Getters (no setters for id or nbMedia) ───────────────
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	@Override
	public boolean equals(Object O) {
		if (this == O) {
			return true;
		}
		if (O == null || !(O instanceof Media)) {
			return false;
		}
		Media other = (Media) O;
		return this.title.equals(other.getTitle());
	}

	@Override
	public int compareTo(Media other) {
		int titleCompare = this.title.compareToIgnoreCase(other.title);
		if (titleCompare != 0)
			return titleCompare;

		return Float.compare(this.cost, other.cost);
	}

}
