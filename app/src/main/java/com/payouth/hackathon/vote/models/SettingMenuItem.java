package com.payouth.hackathon.vote.models;

import me.goldze.mvvmhabit.base.BaseModel;

public class SettingMenuItem extends BaseModel {

    public SettingMenuItem(String title, int type , String url){
        this.type = type;
        this.title = title;
        this.url = url;
    }

    private String title;

    private String url;
    private int type;

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
