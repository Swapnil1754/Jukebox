package org.example.Model;

import java.util.List;

public class PlayLists {
    private int listNo;
    private String playlist;
    private String pType;
    private long Uid;

    public PlayLists(int listNo, String playlist, String pType, long uid) {
        this.listNo = listNo;
        this.playlist = playlist;
        this.pType = pType;
        Uid = uid;
    }

    public int getListNo() {
        return listNo;
    }

    public void setListNo(int listNo) {
        this.listNo = listNo;
    }

    public String getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public long getUid() {
        return Uid;
    }

    public void setUid(long uid) {
        Uid = uid;
    }

    @Override
    public String toString() {
        return String.format("%18s %18s %18s %18s",listNo ,playlist ,pType ,Uid +"\n");
    }
}