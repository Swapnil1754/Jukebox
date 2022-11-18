package org.example.DAOInterfaces;

import org.example.Model.PlayList_Details;
import org.example.Model.PlayLists;

import java.util.List;

public interface PlayListsInterface {
    public List<PlayLists> displayAllPlayLists(String ch,long Uid);
    public void playPlayList();
    public void deletePlayList();
}
