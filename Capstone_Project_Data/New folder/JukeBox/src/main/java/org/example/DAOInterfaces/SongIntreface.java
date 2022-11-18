package org.example.DAOInterfaces;

import org.example.Model.Song;

import java.util.List;

public interface SongIntreface {
    public List<Song> displayAllSongs();
    public List<Song> sortSongs();
    public Song searchSong(String sname);

}
