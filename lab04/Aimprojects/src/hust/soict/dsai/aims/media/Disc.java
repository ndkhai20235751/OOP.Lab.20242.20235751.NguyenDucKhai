package hust.soict.dsai.aims.media;

public class Disc extends Media {
	
	
	
	private int length;
	 private String director;
	 public Disc( String title, String category,String director, int length,float cost) {
			super( title, category, cost);
			// TODO Auto-generated constructor stub
			this.length=length;
			this.director=director;
	 }
		public Disc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}
	 
		public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
	

}
