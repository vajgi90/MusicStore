package hu.flowacademy.musicstore.resource;


import hu.flowacademy.musicstore.persistance.model.Artist;
import hu.flowacademy.musicstore.persistance.model.Song;
import hu.flowacademy.musicstore.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SongResource {

    private SongService songService;

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> findAll() {
        List<Song> songs = songService.getAllSong();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Song song = songService.getOneSongById(id);
        if (song == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(song, HttpStatus.OK);
        }
    }

    @PostMapping("/songs")
    public ResponseEntity<?> create(@RequestBody Song song) {
        songService.saveSong(song);
        return new ResponseEntity<>(song, HttpStatus.CREATED);
    }

    @DeleteMapping("/artists/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (songService.isExist(id)) {
            songService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
