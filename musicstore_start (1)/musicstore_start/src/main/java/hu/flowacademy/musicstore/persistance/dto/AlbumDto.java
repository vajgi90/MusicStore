package hu.flowacademy.musicstore.persistance.dto;

import hu.flowacademy.musicstore.persistance.model.Album;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

public class AlbumDto {

    private String title;
    private Long count;

    public AlbumDto(String title, Long count) {
        this.title = title;
        this.count = count;
    }



    public AlbumDto(Album album) {
        this.title = album.getTitle();
        this.count = album.getCount();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Album toEntity(AlbumDto albumDto) {
        Album album = new Album(null, albumDto.getTitle(), albumDto.getCount());
        return album;
    }
}
