package be.pxl.oefeningen.musicplaylist.api;

import be.pxl.oefeningen.musicplaylist.domain.Genre;
import be.pxl.oefeningen.musicplaylist.domain.Song;
import be.pxl.oefeningen.musicplaylist.service.MusicPlaylistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/playlist/songs")

public class MusicPlaylistController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(MusicPlaylistController.class);
    private final MusicPlaylistService musicPlaylistService;

    @Autowired
    public MusicPlaylistController(MusicPlaylistService musicPlaylistService) {
        this.musicPlaylistService = musicPlaylistService;
    }

    @PostMapping
    public void addSong(@RequestBody Song song) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Adding song [" + song.getTitle() + "]");
        }
        musicPlaylistService.addSong(song);
    }

    @GetMapping
    public List<Song> getSongs() {
        return musicPlaylistService.getSongs();
    }

    @GetMapping("{genre}")
    public List<Song> getSongs(@PathVariable Genre genre) {
        return musicPlaylistService.getSongsByGenre(genre);
    }

    @PutMapping("{index}")
    public void updateSong(@PathVariable int index, @RequestBody Song song) {
        musicPlaylistService.updateSong(index, song);
    }

    @DeleteMapping("{index}")
    public void updateSong(@PathVariable int index) {
        musicPlaylistService.deleteSong(index);
    }
}
