package com.musicplayer.musicplayerrestapi.controllertests;

import com.musicplayer.musicplayerrestapi.models.Song;
import com.musicplayer.musicplayerrestapi.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {

    SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService;
    }

    @GetMapping("/songs/{title}")
    public List<Song> searchSongsByTitle(@PathVariable String title){
        return null;
    }

    @PostMapping("/song")
    public String postSong(@RequestBody Song song){
        songService.saveSong(song);
        return "saved";
    }
}
