package com.example.admin.pandatv.model.modelutils.pandalive_greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by LiYRong on 2017/8/31.
 */
@Entity
public class LookTalkBean {

    @Id
    private Long id;
    @Property
    private String ed_content;
    @Property
    private String time;
    @Property
    private int floor;
    public int getFloor() {
        return this.floor;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getEd_content() {
        return this.ed_content;
    }
    public void setEd_content(String ed_content) {
        this.ed_content = ed_content;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 410573095)
    public LookTalkBean(Long id, String ed_content, String time, int floor) {
        this.id = id;
        this.ed_content = ed_content;
        this.time = time;
        this.floor = floor;
    }
    @Generated(hash = 1628067155)
    public LookTalkBean() {
    }
  
   
}
