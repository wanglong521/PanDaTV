package com.example.admin.pandatv.model.entity;

/**
 * Created by lenovo on 2017/8/27.
 */

public class LvieItemBean {
    private String brief;
    private String image;
    private String title;

    public LvieItemBean() {
    }

    public LvieItemBean(String brief, String image, String title) {
        this.brief = brief;
        this.image = image;
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
