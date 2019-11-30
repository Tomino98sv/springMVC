package com.spring_stream.server_song.controller;

import com.spring_stream.server_song.model.Song;
import com.spring_stream.server_song.service.SongService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
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


    @RequestMapping(value="download", method=RequestMethod.GET)
    public void getDownload(HttpServletResponse response, @RequestParam String auth, @RequestParam String alb, @RequestParam String name) {
        File f = new File(songService.findPath(auth,alb,name));
        InputStream targetStream = null;
        try {
            targetStream = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Set the content type and attachment header.
        String contentType = response.getContentType();

        response.addHeader("Content-Disposition:", "attachment;filename=\"" + f.getName() + "\"");
        response.setContentType(contentType);

        // Copy the stream to the response's output stream.
        try {
            IOUtils.copy(targetStream, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
