package org.example.Model;

public class PlayList_Details {
    private int seqid;
    private int listNo;
    private int songid;
    private String sname;

    private int pod_id;
    private String pname;
    private String file_P;

    public PlayList_Details(int seqid, int listNo, int songid, String sname, int pod_id, String pname, String file_P) {
        this.seqid = seqid;
        this.listNo = listNo;
        this.songid = songid;
        this.sname = sname;
        this.pod_id = pod_id;
        this.pname = pname;
        this.file_P = file_P;
    }

    public int getSeqid() {
        return seqid;
    }

    public void setSeqid(int seqid) {
        this.seqid = seqid;
    }

    public int getListNo() {
        return listNo;
    }

    public void setListNo(int listNo) {
        this.listNo = listNo;
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

    public int getPod_id() {
        return pod_id;
    }

    public void setPod_id(int pod_id) {
        this.pod_id = pod_id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getFile_P() {
        return file_P;
    }

    public void setFile_P(String file_P) {
        this.file_P = file_P;
    }

    @Override
    public String toString() {
        return String.format("%8s %8s %8s %8s %8s %8s %10s",seqid,listNo,songid,sname,pod_id,pname,file_P);
    }
}