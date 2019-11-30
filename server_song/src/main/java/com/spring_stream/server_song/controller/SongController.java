package com.spring_stream.server_song.controller;

import com.spring_stream.FileClass;
import com.spring_stream.server_song.model.Song;
import com.spring_stream.server_song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.io.Resource;
import java.io.InputStream;
import java.util.List;

@RestController
public class SongController {

    @Autowired
    private SongService songService;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(path = "/insertSong", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insert(@RequestBody Song song) {
        Song insSong = songService.insert(song);
        return insSong.toString();
    }

    @GetMapping(value = "/getAllSongs",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Song> findAll() {
        return (List<Song>) songService.getAllSongs();
    }




    //pre testing
    @GetMapping(value = "/getPath")
    public String findPath(@RequestParam String auth, @RequestParam String alb, @RequestParam String name) {
        return songService.findPath(auth,alb,name);
    }

    @GetMapping(value = "/getStreamSong")
    public Resource download(@RequestParam String auth, @RequestParam String alb, @RequestParam String name) {
//        logger.info(songService.findPath(auth,alb,name));
        FileClass fileClass = new FileClass(songService.findPath(auth,alb,name));
        Resource resourceSong = null;
            InputStream inputStream = fileClass.getFile();
            resourceSong = (Resource) fileClass.prepareResponse(inputStream);

        return resourceSong;
    }

}
