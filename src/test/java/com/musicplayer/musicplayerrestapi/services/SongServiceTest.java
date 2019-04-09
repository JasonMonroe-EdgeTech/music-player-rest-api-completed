package com.musicplayer.musicplayerrestapi.services;

import com.musicplayer.musicplayerrestapi.models.Song;
import com.musicplayer.musicplayerrestapi.repositoriestests.SongRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class SongServiceTest {
    @Mock
    private SongRepository songRepository;

    private SongService songService;

    @Before
    public void setUp(){
        this.songService = new SongService(songRepository);
    }

    @Test
    public void saveSong_invokesRepoSave(){
        //arrange
        Song song = new Song("FKJ and Masego","Tadow", Duration.ofSeconds(274));

        //act
        songService.saveSong(song);

        //assert
        verify(songRepository,times(1)).save(song);

    }

}