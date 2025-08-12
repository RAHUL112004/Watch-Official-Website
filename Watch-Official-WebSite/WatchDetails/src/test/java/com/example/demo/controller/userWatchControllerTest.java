package com.example.demo.controller;

import com.example.demo.Controller.userWatchController;
import com.example.demo.Model.Watch;
import com.example.demo.Service.WatchService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;

@WebMvcTest(userWatchController.class)
public class userWatchControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @SuppressWarnings("removal")
    @MockBean
    private WatchService watchService;

    @Test
    public void testGetAllWatch() throws Exception {
        List<Watch> fakeWatches = List.of(
            new Watch("Titan", "Titan", "Titan analog watch", 3500.0, "/images/titan1.jpg"),
            new Watch("Fastrack", "Fastrack", "Fastrack digital watch", 2200.0, "/images/fast1.jpg")
        );

        Mockito.when(watchService.getallWatch()).thenReturn(fakeWatches);

        mockMvc.perform(get("/user/allWatch"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", is(2)))
                .andExpect(jsonPath("$[0].name", is("Titan")))
                .andExpect(jsonPath("$[1].name", is("Fastrack")));
    }

    @Test
    public void testSearchWatchByKeyword() throws Exception {
        List<Watch> filtered = List.of(
            new Watch("Fastrack", "Fastrack", "Fastrack digital watch", 2200.0, "/images/fast1.jpg")
        );

        Mockito.when(watchService.getWatchUsingKeyword("Fastrack")).thenReturn(filtered);

        mockMvc.perform(get("/user/search").param("keyword", "Fastrack"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", is(1)))
                .andExpect(jsonPath("$[0].name", is("Fastrack")));
    }
}
