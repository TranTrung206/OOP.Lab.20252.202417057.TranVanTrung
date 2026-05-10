package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists.");
        }
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }

    public int getLength() {
        int total = 0;
        for (Track t : tracks) total += t.getLength();
        return total;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by " + artist);
        for (Track t : tracks) {
            t.play();
        }
    }

    @Override
    public String toString() {
        return id + ". CD: " + title + " - Artist: " + artist + " - Tracks: " + tracks.size() + " - Cost: " + cost + "$";
    }
}