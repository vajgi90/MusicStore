package hu.flowacademy.musicstore.persistance.repository;

import hu.flowacademy.musicstore.persistance.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
