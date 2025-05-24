package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

	private static int nbDigitalVideoDiscs=0;

	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(String title) {
        super(title);
        setTitle(title);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc( String title, String category, float cost) {
        super(category, title, cost);
        setCategory(category);
        setTitle(title);
        setCost(cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(category, title, cost);
        this.director = director;
        setCategory(category);
        setTitle(title);
        setCost(cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(category, title, cost);
        setTitle(title);
        setCategory(category);
        this.director = director;
        this.length = length;
        setCost(cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }
	public String toString() {
	    return this.getId()+" - "+"DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
	}
	public boolean isMatch(String title) {
        return getTitle() != null && getTitle().toLowerCase().contains(title.toLowerCase());
    }
    public int getId() {
        return super.getId(); // Lấy id từ lớp cha
    }
}
