package hu.flowacademy.musicstore.resource;

import hu.flowacademy.musicstore.persistance.dto.AlbumDto;
import hu.flowacademy.musicstore.persistance.model.Album;
import hu.flowacademy.musicstore.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AlbumResource {

    private AlbumService albumService;

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> findAll() {
        List<Album> albums = albumService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        AlbumDto album = albumService.getOneAlbumById(id);
        if (album == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(album, HttpStatus.OK);
        }
    }

    @PostMapping("/albums")
    public ResponseEntity<?> create(@RequestBody AlbumDto album) {
        albumService.saveAlbum(album);
        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

    @DeleteMapping("/albums/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (albumService.isExist(id)) {
            albumService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
