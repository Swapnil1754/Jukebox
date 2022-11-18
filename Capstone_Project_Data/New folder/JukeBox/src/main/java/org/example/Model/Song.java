package org.example.Model;

public class Song {
    private int songid;
    private String sname;
    private String duration;
    private String artist;
    private String genre;
    private String fileP;

    public Song(int songid, String sname, String duration, String artist, String genre, String fileP) {
        this.songid = songid;
        this.sname = sname;
        this.duration = duration;
        this.artist = artist;
        this.genre = genre;
        this.fileP = fileP;
    }

    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFileP() {
        return fileP;
    }

    public void setFileP(String fileP) {
        this.fileP = fileP;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songid=" + songid +
                ", sname='" + sname + '\'' +
                ", duration='" + duration + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", fileP='" + fileP + '\'' +
                '}';
    }
}