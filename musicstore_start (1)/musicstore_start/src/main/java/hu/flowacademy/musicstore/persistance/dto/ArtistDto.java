package hu.flowacademy.musicstore.persistance.dto;

import hu.flowacademy.musicstore.persistance.model.Album;
import hu.flowacademy.musicstore.persistance.model.Artist;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArtistDto {
/*
    private String firstName;
    private String lastName;

    public ArtistDto(Artist artist) {
        this.firstName = artist.getFirstName();
        this.lastName = artist.getLastName();
    }
*/

/*    public Artist toEntity(ArtistDto artistDto) {
        return Artist.builder().firstName(artistDto.getFirstName()).lastName(artistDto.getLastName()).build();
    }*/
}
