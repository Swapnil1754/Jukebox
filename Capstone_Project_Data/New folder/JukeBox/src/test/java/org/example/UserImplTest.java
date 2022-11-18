package org.example;

import org.example.DAOImplClasses.UserImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserImplTest {
    UserImpl user=null;
    @BeforeEach
    public void setup(){
        user=new UserImpl();
    }
    @AfterEach
    public void tearDown(){
        user=null;
    }
    @Test
    public void userRegistraition(){

    }
}
