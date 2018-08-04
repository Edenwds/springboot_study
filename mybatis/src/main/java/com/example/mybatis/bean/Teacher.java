package com.example.mybatis.bean;

public class Teacher {
    private String tid;

    private String tname;

    private String tgender;

    private String tphone;

    private String tjobtitle;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getTgender() {
        return tgender;
    }

    public void setTgender(String tgender) {
        this.tgender = tgender == null ? null : tgender.trim();
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone == null ? null : tphone.trim();
    }

    public String getTjobtitle() {
        return tjobtitle;
    }

    public void setTjobtitle(String tjobtitle) {
        this.tjobtitle = tjobtitle == null ? null : tjobtitle.trim();
    }
}