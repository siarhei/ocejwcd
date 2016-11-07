package murach.data;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author siarhei
 */
public class Band {
    private final String name;
    private Deque<Album> albums = new LinkedList<>();

    public Band(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Deque<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    @Override
    public String toString() {
        return name;
    }
}
