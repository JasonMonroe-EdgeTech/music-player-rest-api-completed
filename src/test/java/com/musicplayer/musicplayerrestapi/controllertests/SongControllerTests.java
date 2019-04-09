package com.musicplayer.musicplayerrestapi.controllertests;

import TestUtils.TestSongs;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicplayer.musicplayerrestapi.models.Song;
import com.musicplayer.musicplayerrestapi.services.SongService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SongController.class)
public class SongControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongService songService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void postingSong_savesTheSong() throws Exception{
        //act
        Song song = TestSongs.getSongs().get(0);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/song")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(song));

        //assert
        mockMvc.perform(builder).andExpect(status().isOk());
        verify(songService,times(1)).saveSong(any(Song.class));

    }

    @Test
    public void searchingByTitle_returnsSongsWithThatTitle() throws Exception {
        List<Song> returnedSongs = new ArrayList<Song>();
        returnedSongs.add(TestSongs.getSongs().get(0));
        returnedSongs.add(TestSongs.getSongs().get(1));

        SongService songService = mock(SongService.class);
        when(songService.findSongByTitle(any(String.class))).thenReturn(returnedSongs);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/songs/Africa"))
                .andExpect(status().isOk())
                .andReturn();

        String content = response.getResponse().getContentAsString();
        System.out.println(content);

    }
}
