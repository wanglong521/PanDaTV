package com.example.admin.pandatv.model.modelutils.chinalive_greendao;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by lenovo on 2017/8/30.
 */
@Entity
public class GreenDao_China_Tab {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private Boolean aBoolean;
    @Property
    private String tabtitle;
    @Generated(hash = 1108458942)
    public GreenDao_China_Tab(Long id, Boolean aBoolean, String tabtitle) {
        this.id = id;
        this.aBoolean = aBoolean;
        this.tabtitle = tabtitle;
    }
    @Generated(hash = 1887296274)
    public GreenDao_China_Tab() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getABoolean() {
        return this.aBoolean;
    }
    public void setABoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }
    public String getTabtitle() {
        return this.tabtitle;
    }
    public void setTabtitle(String tabtitle) {
        this.tabtitle = tabtitle;
    }

}
