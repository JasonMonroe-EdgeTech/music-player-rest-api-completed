package com.musicplayer.musicplayerrestapi.repositoriestests;

import com.musicplayer.musicplayerrestapi.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {
}
