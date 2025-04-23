package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.media.Track;

public class Track {
	private int length;
	private String title;
	
	public int getLength() {
		return length;
	}
	public String getTitle() {
		return title;
	}
	public Track(String title, int length) {
		super();
		this.length = length;
		this.title = title;
	}
	public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track)) return false;

        return ((Track)obj).getTitle() == this.getTitle() && ((Track)obj).getLength() == this.getLength();
    }
}
