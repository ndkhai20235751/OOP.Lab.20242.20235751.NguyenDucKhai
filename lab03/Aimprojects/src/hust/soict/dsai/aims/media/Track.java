package hust.soict.dsai.aims.media;

public class Track implements Playable{
 private String title;
 private int length;
 public Track(String title,int length)  {
	 this.title=title;
	 this.length=length;
 }
public String getTitle() {
	return title;
}

public int getLength() {
	return length;
}
@Override
public void play() {
	// TODO Auto-generated method stub
	System.out.println("Play:"+getTitle());
	System.out.println("length:"+getLength());
}
public boolean equals(Object obj) {
	if (obj == this) {
		return true;
	}
	if (!(obj instanceof Track)) {
		return false;
	}
	return (((Track)obj).getTitle() == this.getTitle() && ((Track)obj).getLength() == this.getLength());
}
 
}
