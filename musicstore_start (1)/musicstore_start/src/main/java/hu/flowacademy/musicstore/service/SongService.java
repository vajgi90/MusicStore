package hu.flowacademy.musicstore.service;


import hu.flowacademy.musicstore.exception.ValidationException;
import hu.flowacademy.musicstore.persistance.model.Artist;
import hu.flowacademy.musicstore.persistance.model.Song;
import hu.flowacademy.musicstore.persistance.repository.SongRepository;
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
public class SongService {

    private SongRepository songRepository;

    public List<Song> getAllSong() {
        return songRepository.findAll();
    }

    public Song getOneSongById(Long id) {
        return songRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<?> saveSong(Song song) {
        validateSong(song);
        if(StringUtils.isEmpty(song.getLyrics())) {
            song.setLyrics(null);
        }
        if(StringUtils.isEmpty(song.getWriterName()) || song.getWriterName() == null) {
            song.setWriterName(song.getArtist().getFirstName() + " " + song.getArtist().getLastName());
        }
        Song savedItem = songRepository.save(song);
        return new ResponseEntity<>(savedItem,HttpStatus.CREATED);
    }

    public void delete(Long id) {
        songRepository.deleteById(id);
    }

    private void validateSong(Song song) {
        if (StringUtils.isEmpty(song.getTitle())){
            throw new ValidationException("empty title");
        }
        if (song.getArtist() != null){
            throw new ValidationException("missing artist");
        }
        if (song.getAlbum() != null){
            throw new ValidationException("missing album");
        }
        if (song.getGenre() != null){
            throw new ValidationException("missing genre");
        }
        if (song.getYear() != null){
            throw new ValidationException("missing year");
        }
        if (song.getLength() <= 0){
            throw new ValidationException("length must bigger than 0");
        }
        if (song.getLength() <= 0){
            throw new ValidationException("length must bigger than 0");
        }
    }

    public boolean isExist(Long id) { return songRepository.existsById(id);}
}
