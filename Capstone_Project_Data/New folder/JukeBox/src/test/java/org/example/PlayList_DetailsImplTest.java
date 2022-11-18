package org.example;

import org.example.DAOImplClasses.PlayList_DetailsImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class PlayList_DetailsImplTest {
    PlayList_DetailsImpl playList_details=null;
    @BeforeEach
    public void setup(){
        playList_details=new PlayList_DetailsImpl();
    }
    @AfterEach
    public void tearDown(){
        playList_details=null;
    }

}
