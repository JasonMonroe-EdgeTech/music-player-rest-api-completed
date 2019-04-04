package com.musicplayer.musicplayerrestapi.controllertests;

import com.musicplayer.musicplayerrestapi.models.Song;
import com.musicplayer.musicplayerrestapi.services.SongService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SongController.class)
public class SongControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongService songService;

    @Test
    public void postingSong_savesTheSong() throws Exception{
        //act
        mockMvc.perform(MockMvcRequestBuilders.post("/song"))
                .andExpect(status().isOk());

        //assert
        verify(songService,times(1)).saveSong(any(Song.class));

    }
}
