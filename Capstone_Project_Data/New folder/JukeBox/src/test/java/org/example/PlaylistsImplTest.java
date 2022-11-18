package org.example;

import org.example.DAOImplClasses.PlayListsImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistsImplTest {
    PlayListsImpl playLists=null;
    @BeforeEach
    public void setup(){
        playLists=new PlayListsImpl();
    }
    @AfterEach
    public void tearDown(){
        playLists=null;
    }
    @Test
    public void displayAll(){
       // assertEquals("Mylist1",playLists.displayAllPlayLists("Songs",816448995024).get(0).getPlaylist());
    }

}
