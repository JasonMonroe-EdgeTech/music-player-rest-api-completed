package com.musicplayer.musicplayerrestapi.repositoriestests;

import com.musicplayer.musicplayerrestapi.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer> {
    public List<Song> findByTitle(String title);
}
