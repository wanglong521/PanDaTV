package com.example.admin.pandatv.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/8/27.
 */

public class RllingBean {


    private List<BigImgBean> bigImg;
    private List<ListBean> list;

    public List<BigImgBean> getBigImg() {
        return bigImg;
    }

    public void setBigImg(List<BigImgBean> bigImg) {
        this.bigImg = bigImg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class BigImgBean {
        /**
         * url : http://live.ipanda.com/2017/08/25/VIDEJvTwO9EOZRnmC1sZmceq170825.shtml
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/8/26/1503715367378_489.jpg
         * title : 《当熊不让》大熊猫生日扎堆是什么体验？
         * id : TITE1503715198346756
         * type : 2
         * stype :
         * pid : 026839787dfb4eb597e724e835b44782
         * vid :
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String id;
        private String type;
        private String stype;
        private String pid;
        private String vid;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStype() {
            return stype;
        }

        public void setStype(String stype) {
            this.stype = stype;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    public static class ListBean {
        /**
         * url : http://live.ipanda.com/2017/08/21/VIDEkIyralrrjjG4oF2fqmiI170821.shtml
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/08/21/2017082113472411863.jpg
         * title : 《熊猫TOP榜》
         * brief : 第二季第十一期：一起惹的祸，妹妹背黑锅
         * type : 2
         * videoLength : 04:33
         * id : VSET100284428835
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String brief;
        private String type;
        private String videoLength;
        private String id;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
