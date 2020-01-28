package hu.flowacademy.musicstore.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hu.flowacademy.musicstore.persistance.model.Album;
import hu.flowacademy.musicstore.persistance.model.Artist;
import hu.flowacademy.musicstore.persistance.model.Song;
import hu.flowacademy.musicstore.persistance.repository.AlbumRepository;
import hu.flowacademy.musicstore.persistance.repository.ArtistRepository;
import hu.flowacademy.musicstore.persistance.repository.SongRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


@Component
@Transactional
@Slf4j
public class InitDataLoader {


    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    @Autowired
    JsonLoader jsonLoader;


    public InitDataLoader(AlbumRepository albumRepository, ArtistRepository artistRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

/*    @PostConstruct
    public void init() {
        loadAlbums();
        loadArtists();
        loadSongs();
    }

    public void loadAlbums() {
        List<Album> albums = jsonLoader.loadByFilename("albums", jsonLoader.getReturnType(List.class, Album.class));
        albums.stream().forEach(this.albumRepository::save);
    }

    public void loadArtists() {
        List<Artist> artists = jsonLoader.loadByFilename("artists", jsonLoader.getReturnType(List.class, Artist.class));
        artists.stream().forEach(this.artistRepository::save);
    }

    public void loadSongs() {
        List<Song> songs = jsonLoader.loadByFilename("songs", jsonLoader.getReturnType(List.class, Artist.class));
        songs.stream().forEach(this.songRepository::save);
    }*/

}
