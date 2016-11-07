package murach.data;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author siarhei
 */
public class MusicStore {
    private Deque<Band> bands = new LinkedList<>();
    private Path musicRoot;

    public void init(String path) {
        musicRoot = Paths.get(path);
        scanMusic();
    }

    private void scanMusic() {
        if (!bands.isEmpty()) {
            return;
        }
        try {
            Files.walkFileTree(musicRoot, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (isBandDir(dir)) {
                        String bandName = dir.getFileName().toString();
                        bands.add(new Band(bandName));
                    }
                    if (isAlbumDir(dir)) {
                        String albumName = dir.getFileName().toString();
                        Band band = bands.getLast();
                        band.addAlbum(new Album(albumName));
                    }
                    return super.preVisitDirectory(dir, attrs);
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (isSong(file)) {
                        Band band = bands.getLast();
                        Album album = band.getAlbums().getLast();
                        String songName = file.getFileName().toString().replaceAll("\\..+$", "");
                        album.addSong(new Song(songName, file));
                    }
                    return super.visitFile(file, attrs);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isBandDir(Path path) {
        Path relPath = musicRoot.relativize(path).normalize();
        return !relPath.toString().isEmpty() && relPath.getNameCount() == 1;
    }

    private boolean isAlbumDir(Path path) {
        Path relPath = musicRoot.relativize(path).normalize();
        return !relPath.toString().isEmpty() && relPath.getNameCount() == 2;
    }

    private boolean isSong(Path path) {
        if (Files.isRegularFile(path)) {
            Path fileName = path.getFileName();
            String name = fileName.toString();
            String[] fileNameParts = name.split("\\.");
            String fileExt = fileNameParts[fileNameParts.length - 1];
            switch (fileExt.toLowerCase()) {
                case "mp3":
                case "flac":
                case "ogg":
                case "m4a":
                    return true;
            }
        }

        return false;
    }
}
