package org.example.DAOInterfaces;

import org.example.Model.Podcast;

import java.util.List;

public interface PodcastInterface {
    public List<Podcast> displayAllPodcasts();
    public List<Podcast> sortPodcasts();
    public Podcast searchPodcast(String pname);
}
