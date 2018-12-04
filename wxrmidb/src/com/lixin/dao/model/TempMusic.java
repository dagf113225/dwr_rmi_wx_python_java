package com.lixin.dao.model;

public class TempMusic {


    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getTid() {
        return tid;
    }

    public String getTname() {
        return tname;
    }

    public String getTurl() {
        return turl;
    }

    public int getState() {
        return state;
    }

    private int tid;

    private String tname;

    private String turl;

    private int state;




}
