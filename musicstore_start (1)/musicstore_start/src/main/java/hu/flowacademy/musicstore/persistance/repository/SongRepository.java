package hu.flowacademy.musicstore.persistance.repository;

import hu.flowacademy.musicstore.persistance.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}
