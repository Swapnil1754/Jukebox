package org.example;

import org.example.DAOImplClasses.PodcastImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PodcastImplTest {
    PodcastImpl podcast=null;
    @BeforeEach
    public void setup(){
        podcast=new PodcastImpl();
    }
    @AfterEach
    public void tearDown(){
        podcast=null;
    }
    @Test
    public void displayAllPodcasts(){
        assertEquals(2,podcast.displayAllPodcasts().size());
    }
    @Test
    public void sortPodcast(){
        assertEquals("Khidki",podcast.sortPodcasts().get(1).getPname());

    }
    @Test
    public void serachPodcast(){
        assertEquals("Bachpan",podcast.searchPodcast("Bachpan").getPname());
    }
}
