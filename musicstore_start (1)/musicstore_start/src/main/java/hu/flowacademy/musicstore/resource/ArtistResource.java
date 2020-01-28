package hu.flowacademy.musicstore.resource;


import hu.flowacademy.musicstore.persistance.model.Album;
import hu.flowacademy.musicstore.persistance.model.Artist;
import hu.flowacademy.musicstore.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ArtistResource {

    private ArtistService artistService;

    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> findAll() {
        List<Artist> artists = artistService.getAllArtist();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Artist artist = artistService.getOneArtistById(id);
        if (artist == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(artist, HttpStatus.OK);
        }
    }

    @PostMapping("/artists")
    public ResponseEntity<?> create(@RequestBody Artist artist) {
        artistService.saveArtist(artist);
        return new ResponseEntity<>(artist, HttpStatus.CREATED);
    }

    @DeleteMapping("/artists/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (artistService.isExist(id)) {
            artistService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
