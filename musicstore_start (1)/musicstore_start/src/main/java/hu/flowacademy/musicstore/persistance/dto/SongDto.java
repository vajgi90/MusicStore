package hu.flowacademy.musicstore.persistance.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import hu.flowacademy.musicstore.persistance.Genre;
import hu.flowacademy.musicstore.persistance.model.Album;
import hu.flowacademy.musicstore.persistance.model.Artist;
import hu.flowacademy.musicstore.persistance.model.Song;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SongDto {
/*    private String title;

    private Long length;

    private String lyrics;

    private LocalDate year;

    private String writerName;

    private Genre genre;

    private Artist artist;

    private Album album;

    public SongDto(Song song) {
        this.title = song.getTitle();
        this.length = song.getLength();
        this.lyrics = song.getLyrics();
        this.year = song.getYear();
        this.writerName = song.getWriterName();
        this.genre = song.getGenre();
        this.artist = song.getArtist();
        this.album = song.getAlbum();
    }*/

/*    public Song toEntity(SongDto songDto) {
        return Song.builder().
                title(songDto.getTitle())
                .length(songDto.getLength())
                .lyrics(songDto.getLyrics())
                .year(songDto.getYear())
                .writerName(songDto.getWriterName())
                .genre(songDto.getGenre())
                .artist(songDto.getArtist())
                .album(songDto.getAlbum()).build();
    }*/

}
