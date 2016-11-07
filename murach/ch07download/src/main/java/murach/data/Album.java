package murach.data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author siarhei
 */
public class Album {
    private final String name;
    private List<Song> songs = new LinkedList<>();

    public Album(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public String toString() {
        return name;
    }
}
