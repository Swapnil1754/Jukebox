package org.example.Model;

public class Podcast {
    private int podid;
    private String pname;
    private String artist;
    private String duration;
    private String file_P;

    public Podcast(int podid, String pname, String artist, String duration, String file_P) {
        this.podid = podid;
        this.pname = pname;
        this.artist = artist;
        this.duration = duration;
        this.file_P = file_P;
    }

    public int getPodid() {
        return podid;
    }

    public void setPodid(int podid) {
        this.podid = podid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFile_P() {
        return file_P;
    }

    public void setFile_P(String file_P) {
        this.file_P = file_P;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "podid=" + podid +
                ", pname='" + pname + '\'' +
                ", artist='" + artist + '\'' +
                ", duration='" + duration + '\'' +
                ", file_P='" + file_P + '\'' +
                '}';
    }
}