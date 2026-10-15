package be.pxl.oefeningen.musicplaylist.service;
import be.pxl.oefeningen.musicplaylist.domain.Genre;
import be.pxl.oefeningen.musicplaylist.domain.Song;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MusicPlaylistService {
    private final List<Song> myPlaylist = new ArrayList<>();
    public void addSong(Song song) {
        myPlaylist.add(song);
    }
    public List<Song> getSongs() {return myPlaylist;}

    public List<Song> getSongsByGenre(Genre genre) {
        List<Song> response = new ArrayList<>();
        for (Song song : myPlaylist) {
            if (song.getGenre() == genre) {
                response.add(song);
            }
        }
        return response;
    }

    public void updateSong(int index, Song song) {
        myPlaylist.set(index, song);
    }

    public void deleteSong(int index) {
        myPlaylist.remove(index);
    }
}