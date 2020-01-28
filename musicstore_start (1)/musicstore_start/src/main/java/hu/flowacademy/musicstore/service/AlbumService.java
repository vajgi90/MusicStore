package hu.flowacademy.musicstore.service;


import hu.flowacademy.musicstore.exception.ValidationException;
import hu.flowacademy.musicstore.persistance.dto.AlbumDto;
import hu.flowacademy.musicstore.persistance.model.Album;
import hu.flowacademy.musicstore.persistance.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AlbumService {

    private AlbumRepository albumRepository;

    @Autowired
    AlbumDto albumDto;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public AlbumDto getOneAlbumById(Long id) {
        Album album = albumRepository.findById(id).orElse(null);
        AlbumDto output = new AlbumDto(album);
        return output;
    }

    public ResponseEntity<?> saveAlbum(AlbumDto input) {
            Album album = albumDto.toEntity(input);
            validateAlbum(album);
            Album savedItem = albumRepository.save(album);
            return new ResponseEntity<>(savedItem,HttpStatus.CREATED);
    }

    public void delete(Long id) {
        albumRepository.deleteById(id);
    }

    private void validateAlbum(Album album) {
        if (StringUtils.isEmpty(album.getTitle()) || album.getTitle() == null) {
            throw new ValidationException("missing title");
        }
        if (album.getCount() <= 0) {
            throw new ValidationException("count must be bigger than zero");
        }
    }

    public boolean isExist(Long id) { return albumRepository.existsById(id);}


}
