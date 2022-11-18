package org.example;

import org.example.DAOImplClasses.Songimpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SongImplTest {
    Songimpl songimpl=null;
    @BeforeEach
    public void setup(){
        songimpl=new Songimpl();
    }
    @AfterEach
    public void tearDown(){
        songimpl=null;
    }
    @Test
    public void displayAllSongs(){
        assertEquals(5,songimpl.displayAllSongs().size());
    }
    @Test
    public void sortSongs(){
        assertEquals("Chaldi_Kudi",songimpl.sortSongs().get(2).getSname());
    }
    @Test
    public void searchSong(){
        assertEquals("Shambhoo_re",songimpl.searchSong("Shambhoo_re").getSname());
    }
}
