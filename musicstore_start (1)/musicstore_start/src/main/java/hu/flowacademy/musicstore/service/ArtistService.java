package hu.flowacademy.musicstore.service;


import hu.flowacademy.musicstore.exception.ValidationException;
import hu.flowacademy.musicstore.persistance.model.Artist;
import hu.flowacademy.musicstore.persistance.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ArtistService {

    private ArtistRepository artistRepository;

    public List<Artist> getAllArtist() {
        return artistRepository.findAll();
    }

    public Artist getOneArtistById(Long id) {
        return artistRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<?> saveArtist(Artist artist) {
            validateArtist(artist);
            Artist savedItem = artistRepository.save(artist);
            return new ResponseEntity<>(savedItem,HttpStatus.CREATED);
    }

    public void delete(Long id) {
        artistRepository.deleteById(id);
    }

    private void validateArtist(Artist artist) {
        if (StringUtils.isEmpty(artist.getFirstName()) || artist.getFirstName() == null) {
            throw new ValidationException("missing firstname");
        }
        if (StringUtils.isEmpty(artist.getLastName()) || artist.getLastName() == null) {
            throw new ValidationException("missing lastname");
        }
    }

    public boolean isExist(Long id) { return artistRepository.existsById(id);}
}
