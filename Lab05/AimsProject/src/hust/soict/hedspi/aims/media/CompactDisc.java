package hust.soict.hedspi.aims.media;
import java.util.ArrayList;


public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}
	public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
		super(id,title,category,cost,director);
		this.artist=artist;
	}
	public CompactDisc(String title) {
        super(title);
    }
	
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("The track has been added");
		}else {
			System.out.println("The track aready exists");
		}
	}
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("The track has been removed");
		}
		else {
			System.out.println("The track not found");
		}
	}
	public int getLength() {
		int total = 0;
		for(Track track : tracks) {
			total += track.getLength();
		}
		return total;
	}
	public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }
	public String toString() {
		return this.getId()+" - "+"CD"+" - "+this.getTitle()+" - "+this.getCategory()+" - "+this.getArtist()+" - "+this.getLength()+" - "+this.getCost()+"$";
	}
	public ArrayList<Track> getTracks() {
		return tracks;
	}
	
}
