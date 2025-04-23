package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.media.Disc;

public class Disc extends Media {
	protected int length;
	protected String director;
	
	public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
    
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	public int compareTo(Media other) {
        if (other instanceof Disc) {
            Disc otherDVD = (Disc) other;
            int title_cmp = this.getTitle().compareTo(otherDVD.getTitle());
            if (title_cmp != 0) return title_cmp;
            else {
                int length_cmp = Integer.compare(otherDVD.getLength(), this.getLength());
                if (length_cmp != 0) return length_cmp;
                else return Double.compare(this.getCost(), otherDVD.getCost());
            }
        } else return super.compareTo(other);
    }
}
