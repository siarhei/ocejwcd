package murach.data;

import java.nio.file.Path;

/**
 * @author siarhei
 */
public class Song {
    private final String name;
    private final Path path;

    public Song(String name, Path path) {
        this.path = path;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Path getPath() {
        return path;
    }

    @Override
    public String toString() {
        return name;
    }
}
