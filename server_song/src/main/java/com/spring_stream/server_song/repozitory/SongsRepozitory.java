package com.spring_stream.server_song.repozitory;

import com.spring_stream.server_song.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongsRepozitory extends MongoRepository<Song, String> {

    public Optional<Song> findByAuthorAndAlbumAndSongName(String auth, String alb, String sngnam);

}
